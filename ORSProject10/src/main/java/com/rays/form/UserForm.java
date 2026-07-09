package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.UserDTO;

/**
 * Form class for User entity.
 * Used to capture and validate user input data
 * before converting it into UserDTO.
 *
 * @author Saket
 */
public class UserForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	private String firstName;

	@NotEmpty(message = "Last Name is required")
	private String lastName;

	@NotEmpty(message = "Login Id is required")
	private String loginId;

	@NotEmpty(message = "Password is required")
	private String password;

	@NotNull(message = "Role is required")
	@Min(1)
	private Long roleId;

	private String roleName = null;

	@NotNull(message = "Date of birth is required")
	private Date dob;

	@NotEmpty(message = "Gender is required")
	private String gender;

	@NotNull(message = "Mobile No is required")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phone;

	@NotEmpty(message = "Alternate Mobile No is required")
	private String alternateMobile;

	@NotEmpty(message = "Status is required")
	private String status;

	/**
	 * @return First name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName First name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return Last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName Last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return Login ID
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId Login ID
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * @return Password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password Password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Role ID
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId Role ID
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return Role name
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName Role name
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return Date of birth
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob Date of birth
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return Gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender Gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return Phone number
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone Phone number
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return Alternate mobile number
	 */
	public String getAlternateMobile() {
		return alternateMobile;
	}

	/**
	 * @param alternateMobile Alternate mobile number
	 */
	public void setAlternateMobile(String alternateMobile) {
		this.alternateMobile = alternateMobile;
	}

	/**
	 * @return Status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status Status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Converts form data into UserDTO object.
	 *
	 * @return UserDTO object
	 */
	@Override
	public BaseDTO getDto() {

		UserDTO dto = initDTO(new UserDTO());

		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setLoginId(loginId);
		dto.setPassword(password);
		dto.setRoleId(roleId);
		dto.setRoleName(roleName);
		dto.setDob(dob);
		dto.setGender(gender);
		dto.setPhone(phone);
		dto.setAlternateMobile(alternateMobile);
		dto.setStatus(status);

		return dto;
	}
}