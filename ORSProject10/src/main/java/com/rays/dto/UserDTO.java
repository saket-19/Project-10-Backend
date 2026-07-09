package com.rays.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * DTO class representing User entity.
 * Contains user-related information such as personal details,
 * login credentials, role information, and account status.
 *
 * @author Saket
 */
@Entity
@Table(name = "st_user")
public class UserDTO extends BaseDTO {

	/**
	 * Active user status.
	 */
	public static final String ACTIVE = "Active";

	/**
	 * Deactive user status.
	 */
	public static final String DEACTIVE = "Deactive";

	/**
	 * Locked user status.
	 */
	public static final String LOCKED = "Locked";

	@Column(name = "first_name", length = 50)
	private String firstName;

	@Column(name = "last_name", length = 50)
	private String lastName;

	@Column(name = "login_id", length = 50)
	private String loginId;

	@Column(name = "password", length = 50)
	private String password;

	@Column(name = "role_id")
	private Long roleId;

	@Column(name = "role_name", length = 50)
	private String roleName = null;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "gender", length = 10)
	private String gender;

	@Column(name = "phone", length = 50)
	private String phone;

	@Column(name = "alternate_mobile", length = 50)
	private String alternateMobile;

	@Column(name = "status", length = 20)
	private String status;

	@Column(name = "last_login")
	private Timestamp lastLogin;

	@Column(name = "unsucess_login")
	private Integer unsucessfullLoginAttempt = 0;

	@Column(name = "image_id")
	private Long imageId;

	/**
	 * @return User first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName User first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return User last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName User last name
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
	 * @param password User password
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
	 * @return User status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status User status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return Last login timestamp
	 */
	public Timestamp getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin Last login timestamp
	 */
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * @return Unsuccessful login attempts
	 */
	public Integer getUnsucessfullLoginAttempt() {
		return unsucessfullLoginAttempt;
	}

	/**
	 * @param unsucessfullLoginAttempt Unsuccessful login attempts
	 */
	public void setUnsucessfullLoginAttempt(Integer unsucessfullLoginAttempt) {
		this.unsucessfullLoginAttempt = unsucessfullLoginAttempt;
	}

	/**
	 * @return Image ID
	 */
	public Long getImageId() {
		return imageId;
	}

	/**
	 * @param imageId Image ID
	 */
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	/**
	 * Returns full name of the user.
	 *
	 * @return Full name
	 */
	public String getName() {
		return firstName + " " + lastName;
	}

	/**
	 * Returns unique key field name.
	 *
	 * @return Unique key
	 */
	@Override
	public String getUniqueKey() {
		return "loginId";
	}

	/**
	 * Returns unique value.
	 *
	 * @return Login ID
	 */
	@Override
	public String getUniqueValue() {
		return loginId;
	}

	/**
	 * Returns display label.
	 *
	 * @return Label
	 */
	@Override
	public String getLabel() {
		return "Login Id";
	}

	/**
	 * Returns table name.
	 *
	 * @return Table name
	 */
	@Override
	public String getTableName() {
		return "User";
	}

	/**
	 * Returns display value.
	 *
	 * @return Value
	 */
	@Override
	public String getValue() {
		return null;
	}
}