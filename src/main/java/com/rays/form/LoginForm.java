package com.rays.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Form class for user login.
 * Used to capture and validate login credentials
 * provided by the user during authentication.
 *
 * @author Saket
 */
public class LoginForm {

	@NotEmpty(message = "Login Id is required")
	@Email
	private String loginId;

	@NotEmpty(message = "Password is required")
	private String password;

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

	/**
	 * Returns password.
	 *
	 * @return Password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets password.
	 *
	 * @param password Password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}