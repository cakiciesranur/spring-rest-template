package com.eny.springproject.service;

import com.eny.springproject.dto.response.JwtAuthenticationResponse;

public interface IAuthenticationService {

    JwtAuthenticationResponse login(String usernameOrEmail, String password);
}
