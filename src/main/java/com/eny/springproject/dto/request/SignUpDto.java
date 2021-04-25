package com.eny.springproject.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@ApiModel(value ="SignUp DTO", description ="SignUp Data Transfer Object")
public class SignUpDto implements Serializable {

    private static final long serialVersionUID = 309271832375484192L;

    @ApiModelProperty(value="name field", required = true)
    @NotBlank
    @Size(min = 4, max = 40)
    private String name;

    @ApiModelProperty(value="username field", required = true)
    @NotBlank
    @Size(min = 3, max = 15)
    private String username;

    @ApiModelProperty(value="email field", required = true)
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @ApiModelProperty(value="password field", required = true)
    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
}
