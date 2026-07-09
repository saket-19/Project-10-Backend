package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Form class for managing user profile information.
 * Used to capture and validate profile details
 * of the logged-in user.
 *
 * @author Saket
 */
public class MyProfileForm {

	@NotEmpty(message = "First Name is required")
	private String firstName;

	@NotEmpty(message = "Last Name is required")
	private String lastName;

	@NotEmpty(message = "Login Id is required")
	private String loginId;

	@NotEmpty(message = "Gender is required")
	private String gender;

	@NotEmpty(message = "Mobile No is required")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phone;

	@NotNull(message = "Date of birth is required")
	private Date dob;

	/**
	 * Returns first name.
	 *
	 * @return First name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets first name.
	 *
	 * @param firstName First name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns last name.
	 *
	 * @return Last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets last name.
	 *
	 * @param lastName Last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	/**
	 * Returns gender.
	 *
	 * @return Gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets gender.
	 *
	 * @param gender Gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Returns mobile number.
	 *
	 * @return Mobile number
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets mobile number.
	 *
	 * @param phone Mobile number
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Returns date of birth.
	 *
	 * @return Date of birth
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * Sets date of birth.
	 *
	 * @param dob Date of birth
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
}