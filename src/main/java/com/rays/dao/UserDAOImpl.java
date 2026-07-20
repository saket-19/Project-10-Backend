package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;

/**
 * Implementation class for User DAO operations.
 * Handles database interactions related to User entity.
 *
 * @author Saket
 */
@Repository
public class UserDAOImpl extends BaseDAOImpl<UserDTO> implements UserDAOInt {

	/**
	 * DAO for Role operations.
	 */
	@Autowired
	RoleDAOInt roleDao;

	/**
	 * DAO for Attachment operations.
	 */
	@Autowired
	AttachmentDAOInt attachmentDao;

	/**
	 * Returns the UserDTO class object.
	 *
	 * @return UserDTO class
	 */
	@Override
	public Class<UserDTO> getDTOClass() {
		return UserDTO.class;
	}

	/**
	 * Populates additional user details before persistence or retrieval.
	 * Sets role name, last login information, and image id.
	 *
	 * @param dto User DTO
	 * @param userContext User context information
	 */
	@Override
	protected void populate(UserDTO dto, UserContext userContext) {

		if (dto.getRoleId() != null && dto.getRoleId() > 0) {
			RoleDTO roleDto = roleDao.findByPK(dto.getRoleId(), userContext);
			dto.setRoleName(roleDto.getName());
		}

		if (dto.getId() != null && dto.getId() > 0) {
			UserDTO userData = findByPK(dto.getId(), userContext);
			dto.setLastLogin(userData.getLastLogin());
		}

		if (dto.getId() != null && dto.getId() > 0) {
			UserDTO userData = findByPK(dto.getId(), null);
			dto.setImageId(userData.getImageId());
		}
	}

	/**
	 * Deletes a user and its associated attachment image if available.
	 *
	 * @param dto User DTO to be deleted
	 * @param userContext User context information
	 */
	@Override
	public void delete(UserDTO dto, UserContext userContext) {

		if (dto.getImageId() != null && dto.getImageId() > 0) {
			attachmentDao.delete(
					attachmentDao.findByPK(dto.getImageId(), null),
					null);
		}

		super.delete(dto, userContext);
	}

	/**
	 * Creates dynamic search criteria based on the provided UserDTO.
	 *
	 * @param dto User DTO containing search parameters
	 * @param builder CriteriaBuilder instance
	 * @param qRoot Root entity reference
	 * @return List of predicates for query execution
	 */
	@Override
	protected List<Predicate> getWhereClause(UserDTO dto,
			CriteriaBuilder builder,
			Root<UserDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getFirstName())) {
			whereCondition.add(
					builder.like(qRoot.get("firstName"),
							dto.getFirstName() + "%"));
		}

		if (!isEmptyString(dto.getLoginId())) {
			whereCondition.add(
					builder.like(qRoot.get("loginId"),
							dto.getLoginId() + "%"));
		}

		if (!isZeroNumber(dto.getRoleId())) {
			whereCondition.add(
					builder.equal(qRoot.get("roleId"),
							dto.getRoleId()));
		}

		if (isNotNull(dto.getDob())) {
			whereCondition.add(
					builder.equal(qRoot.get("dob"),
							dto.getDob()));
		}

		if (!isEmptyString(dto.getStatus())) {
			whereCondition.add(
					builder.equal(qRoot.get("status"),
							dto.getStatus()));
		}

		return whereCondition;
	}
}