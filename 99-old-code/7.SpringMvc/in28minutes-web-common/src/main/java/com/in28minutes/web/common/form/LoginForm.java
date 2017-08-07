package com.in28minutes.web.common.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {

	@NotEmpty(message = "{login.error.email.required}")
	@Email(message = "{login.error.email.invalid}")
	private String email;

	@NotEmpty(message = "{login.error.password.required}")
	@Size(min = 6, message = "{login.error.password.size}")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
