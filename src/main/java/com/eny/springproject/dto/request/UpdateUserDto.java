package com.eny.springproject.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class UpdateUserDto implements Serializable {
    private static final long serialVersionUID = -5864930635003583949L;

    @Size(min = 4, max = 40)
    private String name;

    @Size(min = 3, max = 15)
    private String username;

    @Size(max = 40)
    @Email
    private String email;
}
