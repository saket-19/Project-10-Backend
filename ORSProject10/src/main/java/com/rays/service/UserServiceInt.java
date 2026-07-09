package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.UserDTO;

/**
 * Service interface for User operations.
 * Defines business methods related to user management,
 * authentication, registration, and password operations.
 *
 * @author Saket
 */
public interface UserServiceInt extends BaseServiceInt<UserDTO> {

	/**
	 * Finds a user by login ID.
	 *
	 * @param name Login ID
	 * @param userContext User context information
	 * @return UserDTO object
	 */
	public UserDTO findByLoginId(String name, UserContext userContext);

	/**
	 * Registers a new user.
	 *
	 * @param dto UserDTO containing registration details
	 * @param userContext User context information
	 * @return Registered UserDTO
	 */
	public UserDTO register(UserDTO dto, UserContext userContext);

	/**
	 * Authenticates a user using login ID and password.
	 *
	 * @param loginId Login ID
	 * @param password Password
	 * @return Authenticated UserDTO
	 */
	public UserDTO authenticate(String loginId, String password);

	/**
	 * Processes forgot password request.
	 *
	 * @param loginId Login ID
	 * @return UserDTO object
	 */
	public UserDTO forgotPassword(String loginId);

	/**
	 * Changes the user's password.
	 *
	 * @param loginId Login ID
	 * @param oldPassword Existing password
	 * @param newPassword New password
	 * @param userContext User context information
	 * @return Updated UserDTO
	 */
	public UserDTO changePassword(String loginId,
			String oldPassword,
			String newPassword,
			UserContext userContext);

}