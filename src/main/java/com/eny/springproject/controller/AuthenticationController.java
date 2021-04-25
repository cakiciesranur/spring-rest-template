package com.eny.springproject.controller;

import com.eny.springproject.dto.request.LoginDto;
import com.eny.springproject.dto.response.GenericResponse;
import com.eny.springproject.service.IAuthenticationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@Api(value = "Authentication Services")
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping("/login")
    @ApiOperation(value="This does authentication for user")
    public GenericResponse authenticateUser(@Valid @RequestBody LoginDto loginRequest) {
        return authenticationService.login(loginRequest.getUsernameOrEmail(), (loginRequest.getPassword()));
    }
}