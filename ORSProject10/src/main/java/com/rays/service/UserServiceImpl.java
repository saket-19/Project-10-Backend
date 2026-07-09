package com.rays.service;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

/**
 * Implementation class for User service operations.
 * Provides business logic for user management,
 * registration, authentication, and password-related functions.
 *
 * @author Saket
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserDTO, UserDAOInt> implements UserServiceInt {

	/**
	 * Finds a user by login ID.
	 *
	 * @param login Login ID
	 * @param userContext User context information
	 * @return UserDTO object if found, otherwise null
	 */
	@Override
	@Transactional(readOnly = true)
	public UserDTO findByLoginId(String login, UserContext userContext) {
		return baseDao.findByUniqueKey("loginId", login, userContext);
	}

	/**
	 * Registers a new user.
	 *
	 * @param dto UserDTO containing registration details
	 * @param userContext User context information
	 * @return Registered UserDTO
	 */
	@Override
	public UserDTO register(UserDTO dto, UserContext userContext) {

		Long id = add(dto, userContext);

		dto.setId(id);

		return dto;
	}

	/**
	 * Authenticates a user using login ID and password.
	 *
	 * @param loginId Login ID
	 * @param password Password
	 * @return Authenticated UserDTO if credentials are valid,
	 *         otherwise null
	 */
	@Override
	public UserDTO authenticate(String loginId, String password) {

		UserDTO dto = findByLoginId(loginId, null);

		if (dto != null) {

			UserContext userContext = new UserContext(dto);

			if (password.equals(dto.getPassword())) {

				dto.setLastLogin(new Timestamp((new Date()).getTime()));
				dto.setUnsucessfullLoginAttempt(0);

				update(dto, userContext);

				return dto;

			} else {

				dto.setUnsucessfullLoginAttempt(
						1 + dto.getUnsucessfullLoginAttempt());

				update(dto, userContext);
			}
		}

		return null;
	}

	/**
	 * Retrieves user information for forgot password functionality.
	 *
	 * @param loginId Login ID
	 * @return UserDTO if found, otherwise null
	 */
	@Override
	public UserDTO forgotPassword(String loginId) {

		UserDTO dto = findByLoginId(loginId, null);

		if (dto == null) {
			return null;
		}

		return dto;
	}

	/**
	 * Changes the password of a user after validating
	 * the old password.
	 *
	 * @param loginId Login ID
	 * @param oldPassword Existing password
	 * @param newPassword New password
	 * @param userContext User context information
	 * @return Updated UserDTO if password is changed successfully,
	 *         otherwise null
	 */
	@Override
	public UserDTO changePassword(String loginId,
			String oldPassword,
			String newPassword,
			UserContext userContext) {

		UserDTO dto = findByLoginId(loginId, null);

		if (dto != null && oldPassword.equals(dto.getPassword())) {

			dto.setPassword(newPassword);

			update(dto, userContext);

			return dto;

		} else {
			return null;
		}
	}
}