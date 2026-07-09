package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseForm;

/**
 * Form class for forgot password functionality.
 * Used to capture and validate the user's login ID
 * for password recovery process.
 *
 * @author Saket
 */
public class ForgetPasswordForm extends BaseForm {

	@NotEmpty(message = "Login Id is required")
	private String loginId;

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