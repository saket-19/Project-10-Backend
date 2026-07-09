package com.rays.common;

import com.rays.dto.UserDTO;

/**
 * Holds logged-in user context information for the current request/session.
 * Used for audit fields like createdBy, modifiedBy and role-based processing.
 *
 * @author Saket
 */
public class UserContext {

	private Long userId = 0L;
	private String loginId = "root";
	private String name = null;
	private Long roleId = 0L;
	private String roleName = "root";

	private UserDTO userDTO = null;

	/**
	 * Default constructor.
	 */
	public UserContext() {
	}

	/**
	 * Creates UserContext from UserDTO.
	 *
	 * @param dto logged-in user details
	 */
	public UserContext(UserDTO dto) {
		this.userDTO = dto;
		this.userId = dto.getId();
		this.loginId = dto.getLoginId();
		this.name = dto.getName();
		this.roleId = dto.getRoleId();
		this.roleName = dto.getRoleName();
	}

	/**
	 * Returns user ID.
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Sets user ID.
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Returns login ID.
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * Sets login ID.
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * Returns user name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets user name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns role ID.
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * Sets role ID.
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * Returns role name.
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Sets role name.
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * Returns full UserDTO object.
	 */
	public UserDTO getUserDTO() {
		return userDTO;
	}

	/**
	 * Sets UserDTO object.
	 */
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
}