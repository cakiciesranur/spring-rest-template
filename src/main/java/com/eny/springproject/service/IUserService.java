package com.eny.springproject.service;

import com.eny.springproject.dto.request.UpdateUserDto;
import com.eny.springproject.model.UserEntity;
import com.eny.springproject.dto.request.SignUpDto;
import com.eny.springproject.dto.response.UserResponse;

import java.util.List;

public interface IUserService {
    UserEntity createUser(SignUpDto signUpDto);

    List<UserEntity> getAllUsers();

    UserResponse updateUser(UpdateUserDto dto);
}
