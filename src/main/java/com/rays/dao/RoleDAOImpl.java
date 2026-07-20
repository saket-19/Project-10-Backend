package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.RoleDTO;

/**
 * Implementation class for Role DAO operations.
 * Handles database interactions related to Role entity.
 *
 * @author Saket
 */
@Repository
public class RoleDAOImpl extends BaseDAOImpl<RoleDTO> implements RoleDAOInt {

	/**
	 * Returns the RoleDTO class object.
	 *
	 * @return RoleDTO class
	 */
	@Override
	public Class<RoleDTO> getDTOClass() {
		return RoleDTO.class;
	}

	/**
	 * Creates dynamic search criteria based on the provided RoleDTO.
	 *
	 * @param dto Role DTO containing search parameters
	 * @param builder CriteriaBuilder instance
	 * @param qRoot Root entity reference
	 * @return List of predicates for query execution
	 */
	@Override
	protected List<Predicate> getWhereClause(RoleDTO dto,
			CriteriaBuilder builder,
			Root<RoleDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isZeroNumber(dto.getId())) {

			whereCondition.add(
					builder.equal(qRoot.get("id"),
							dto.getId()));
		}

		if (!isEmptyString(dto.getName())) {

			whereCondition.add(
					builder.like(qRoot.get("name"),
							dto.getName() + "%"));
		}

		return whereCondition;
	}
}