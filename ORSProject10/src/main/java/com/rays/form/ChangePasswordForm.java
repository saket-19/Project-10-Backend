package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.rays.common.BaseForm;

/**
 * Form class for changing user password.
 * Used to capture and validate old and new password
 * details provided by the user.
 *
 * @author Saket
 */
public class ChangePasswordForm extends BaseForm {

	@NotEmpty(message = "Old Password is required")
	@Size(min = 2, max = 10)
	private String oldPassword;

	@NotEmpty(message = "New Password is required")
	@Size(min = 2, max = 10)
	private String newPassword;

	private String loginId;

	/**
	 * Returns old password.
	 *
	 * @return Old password
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * Sets old password.
	 *
	 * @param oldPassword Old password
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * Returns new password.
	 *
	 * @return New password
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * Sets new password.
	 *
	 * @param newPassword New password
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * Returns login ID.
	 *
	 * @return Login ID
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * Sets login ID.
	 *
	 * @param loginId Login ID
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
}