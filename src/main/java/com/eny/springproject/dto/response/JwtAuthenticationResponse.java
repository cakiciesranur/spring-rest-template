package com.eny.springproject.dto.response;

import com.eny.springproject.constants.*;
import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    //TODO: tüm responseları base responsedan türet

    private String accessToken;
    private String tokenType = AuthenticationConstants.BEARER_TOKEN_TYPE;

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
