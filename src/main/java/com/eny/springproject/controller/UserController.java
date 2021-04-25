package com.eny.springproject.controller;

import com.eny.springproject.dto.request.SignUpDto;
import com.eny.springproject.dto.request.UpdateUserDto;
import com.eny.springproject.model.UserEntity;
import com.eny.springproject.dto.response.ApiResponse;
import com.eny.springproject.dto.response.UserResponse;
import com.eny.springproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<?> registerUser(@Valid SignUpDto signUpDto) {

        UserEntity user = userService.createUser(signUpDto);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(user.getUsername()).toUri();

        //TODO: genel yapıda basarılı response dön!
        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }

/*
    @GetMapping("/getUsers")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public UserListResponse getUsers(){
        userService.getAllUsers();
    }*/

    @PostMapping("/updateUser")
    public UserResponse updateUser(@Valid @RequestBody UpdateUserDto request) {
        UserResponse response = userService.updateUser(request);
        response.setSuccess(true);

        return response;
    }
}
