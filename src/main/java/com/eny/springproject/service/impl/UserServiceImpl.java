package com.eny.springproject.service.impl;

import com.eny.springproject.converter.UserMapper;
import com.eny.springproject.dto.request.SignUpDto;
import com.eny.springproject.dto.request.UpdateUserDto;
import com.eny.springproject.enums.RoleName;
import com.eny.springproject.exception.EmailAlreadyExistsException;
import com.eny.springproject.exception.UserCreationException;
import com.eny.springproject.exception.UserNotFound;
import com.eny.springproject.exception.UsernameAlreadyExistsException;
import com.eny.springproject.model.RoleEntity;
import com.eny.springproject.model.UserEntity;
import com.eny.springproject.repository.RoleRepository;
import com.eny.springproject.repository.UserRespository;
import com.eny.springproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRespository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity createUser(SignUpDto signUpDto) {
        if (userRepository.existsByUsername(signUpDto.getUsername())) {
            throw new UsernameAlreadyExistsException();
        }

        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            throw new EmailAlreadyExistsException();
        }

        // Creating user's account
        UserEntity user = new UserEntity(signUpDto.getName(), signUpDto.getUsername(),
                signUpDto.getEmail(), signUpDto.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        RoleEntity userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(UserCreationException::new);

        user.setRoles(Collections.singleton(userRole));

        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> getAllUsers() {

        List<UserEntity> userList = userRepository.findAll();

        if (!userList.isEmpty()) {
            return userList;
        } else {
            return Collections.emptyList();
        }
    }

    public UserEntity updateUser(UpdateUserDto dto) {
        UserEntity entity = userMapper.toEntity(dto);
        Optional<UserEntity> user = userRepository.findByUsernameOrEmail(entity.getUsername(), entity.getEmail());

        if (user.isPresent()) {
            UserEntity newEntity = user.get();
            newEntity.setName(entity.getName());
            newEntity = userRepository.save(newEntity);

            return newEntity;
        } else {
            throw new UserNotFound();
        }
    }

}