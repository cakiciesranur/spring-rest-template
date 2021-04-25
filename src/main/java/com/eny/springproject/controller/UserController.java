package com.eny.springproject.controller;

import com.eny.springproject.dto.request.SignUpDto;
import com.eny.springproject.dto.request.UpdateUserDto;
import com.eny.springproject.dto.response.GenericResponse;
import com.eny.springproject.model.UserEntity;
import com.eny.springproject.service.GenericResponseService;
import com.eny.springproject.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private GenericResponseService genericResponseService;

    @PostMapping("/createUser")
    @ApiOperation(value = "This creates a new user")
    public GenericResponse registerUser(@Valid @RequestBody SignUpDto signUpDto) {

        UserEntity user = userService.createUser(signUpDto);
        return genericResponseService.createResponseNoError("Created user successfully!", user);
    }

    @PostMapping("/updateUser")
    @ApiOperation(value = "This updates an existing user")
    public GenericResponse updateUser(@Valid @RequestBody UpdateUserDto request) {

        UserEntity newUser = userService.updateUser(request);
        return genericResponseService.createResponseNoError("Updated user successfully!", newUser);
    }

    @GetMapping("/getUsers")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation(value = "This gives a list of all users")
    public GenericResponse getUsers() {
        List<UserEntity> allUsers = userService.getAllUsers();
        return genericResponseService.createResponseNoError("", allUsers);
    }
}
