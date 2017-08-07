package com.in28minutes.web.common.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ChangePasswordForm {

	@NotEmpty(message = "{update.currentPassword.required}")
	@Size(min = 6, message = "{update.currentPassword.size}")
	private String currentPassword;

	@NotEmpty(message = "{update.newPassword.required}")
	@Size(min = 6, message = "{update.newPassword.size}")
	private String newPassword;

	@NotEmpty(message = "{update.confirmationPassword.required}")
	@Size(min = 6, message = "{update.confirmationPassword.size}")
	private String confirmationPassword;

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmationPassword() {
		return confirmationPassword;
	}

	public void setConfirmationPassword(String confirmationPassword) {
		this.confirmationPassword = confirmationPassword;
	}
}
