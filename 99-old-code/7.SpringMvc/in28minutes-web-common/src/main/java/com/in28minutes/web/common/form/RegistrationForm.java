package com.in28minutes.web.common.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class RegistrationForm {

	@NotEmpty(message = "{registration.error.name.required}")
	private String name;

	@NotEmpty(message = "{registration.error.email.required}")
	@Email(message = "{registration.error.email.invalid}")
	private String email;

	@NotEmpty(message = "{registration.error.password.required}")
	@Size(min = 6, message = "{registration.error.password.size}")
	private String password;

	@NotEmpty(message = "{registration.error.confirmationPassword.required}")
	@Size(min = 6, message = "{registration.error.confirmationPassword.size}")
	private String confirmationPassword;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmationPassword() {
		return confirmationPassword;
	}

	public void setConfirmationPassword(String confirmationPassword) {
		this.confirmationPassword = confirmationPassword;
	}

}
