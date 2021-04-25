package com.eny.springproject.controller;

import com.eny.springproject.dto.request.LoginDto;
import com.eny.springproject.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDto loginRequest) {
        //TODO check validations responseentity ? ni gider
        return ResponseEntity.ok(authenticationService.login(loginRequest.getUsernameOrEmail(), (loginRequest.getPassword())));
    }
}