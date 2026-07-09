package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.AttachmentDTO;

/**
 * Implementation class for Attachment DAO operations.
 * Handles database interactions related to Attachment entity.
 *
 * @author Saket
 */
@Repository
public class AttachmentDAOImpl extends BaseDAOImpl<AttachmentDTO> implements AttachmentDAOInt {

	/**
	 * Returns the AttachmentDTO class object.
	 *
	 * @return AttachmentDTO class
	 */
	@Override
	public Class<AttachmentDTO> getDTOClass() {
		return AttachmentDTO.class;
	}

	/**
	 * Creates dynamic search criteria based on the provided AttachmentDTO.
	 *
	 * @param dto Attachment DTO containing search parameters
	 * @param builder CriteriaBuilder instance
	 * @param qRoot Root entity reference
	 * @return List of predicates for query execution
	 */
	@Override
	protected List<Predicate> getWhereClause(AttachmentDTO dto,
			CriteriaBuilder builder,
			Root<AttachmentDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		return whereCondition;
	}
}