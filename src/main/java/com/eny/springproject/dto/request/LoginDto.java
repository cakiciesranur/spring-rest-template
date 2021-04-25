package com.eny.springproject.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class LoginDto implements Serializable {

	private static final long serialVersionUID = 2814677594358347811L;
	@NotBlank
	private String usernameOrEmail;

	@NotBlank
	private String password;
}
