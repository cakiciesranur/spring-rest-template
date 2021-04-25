package com.eny.springproject.service;

import com.eny.springproject.dto.response.GenericResponse;

public interface IAuthenticationService {

    GenericResponse login(String usernameOrEmail, String password);
}
