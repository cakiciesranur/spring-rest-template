package com.eny.springproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends BaseResponse {
    private String name;
    private String username;
    private String email;
    private String password;

}
