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
import com.rays.dto.MarksheetDTO;
import com.rays.dto.StudentDTO;

/**
 * Implementation class for Marksheet DAO operations.
 * Handles database interactions related to Marksheet entity.
 *
 * @author Saket
 */
@Repository
public class MarksheetDAOImpl extends BaseDAOImpl<MarksheetDTO> implements MarksheetDAOInt {

	/**
	 * DAO for Student operations.
	 */
	@Autowired
	StudentDAOInt studentDao = null;

	/**
	 * Returns the MarksheetDTO class object.
	 *
	 * @return MarksheetDTO class
	 */
	@Override
	public Class<MarksheetDTO> getDTOClass() {
		return MarksheetDTO.class;
	}

	/**
	 * Populates student name in marksheet using student id.
	 *
	 * @param dto Marksheet DTO
	 * @param userContext User context information
	 */
	@Override
	protected void populate(MarksheetDTO dto, UserContext userContext) {

		if (dto.getStudentId() != null) {
			StudentDTO studentDTO = studentDao.findByPK(dto.getStudentId(), userContext);

			if (studentDTO != null) {
				dto.setName(studentDTO.getFirstName() + " " + studentDTO.getLastName());
			}
		}
	}

	/**
	 * Creates dynamic search criteria based on the provided MarksheetDTO.
	 *
	 * @param dto Marksheet DTO containing search parameters
	 * @param builder CriteriaBuilder instance
	 * @param qRoot Root entity reference
	 * @return List of predicates for query execution
	 */
	@Override
	protected List<Predicate> getWhereClause(MarksheetDTO dto,
			CriteriaBuilder builder,
			Root<MarksheetDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getName())) {

			whereCondition.add(
					builder.like(qRoot.get("name"),
							dto.getName() + "%"));
		}

		if (!isEmptyString(dto.getRollNo())) {

			whereCondition.add(
					builder.like(qRoot.get("rollNo"),
							dto.getRollNo() + "%"));
		}

		if (!isZeroNumber(dto.getStudentId())) {

			whereCondition.add(
					builder.equal(qRoot.get("studentId"),
							dto.getStudentId()));
		}

		return whereCondition;
	}

	/**
	 * Retrieves the top merit list based on total marks
	 * (Physics + Chemistry + Maths) in descending order.
	 *
	 * @return List of merit students
	 */
	@Override
	public List<MarksheetDTO> getMeritList() {

		System.out.println("marksheetDao merit marksheett run start");

		// List list = super.runHQL(
		// "from MarksheetDTO order by (physics+chemistry+maths) desc limit 0,10",
		// null);

		List list = super.marksheetMeritList(
				"from MarksheetDTO order by (physics+chemistry+maths) desc",
				null);

		return list;
	}
}