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
import com.rays.dto.CollegeDTO;
import com.rays.dto.CourseDTO;
import com.rays.dto.FacultyDTO;
import com.rays.dto.SubjectDTO;

/**
 * Implementation class for Faculty DAO operations.
 * Handles database interactions related to Faculty entity.
 *
 * @author Saket
 */
@Repository
public class FacultyDAOImpl extends BaseDAOImpl<FacultyDTO> implements FacultyDAOInt {

	/**
	 * DAO for College operations.
	 */
	@Autowired
	CollegeDAOInt collegeDao;

	/**
	 * DAO for Course operations.
	 */
	@Autowired
	CourseDAOInt courseDao;

	/**
	 * DAO for Subject operations.
	 */
	@Autowired
	SubjectDAOInt subjectDao;

	/**
	 * Returns the FacultyDTO class object.
	 *
	 * @return FacultyDTO class
	 */
	@Override
	public Class<FacultyDTO> getDTOClass() {
		return FacultyDTO.class;
	}

	/**
	 * Populates faculty details such as college name,
	 * course name, and subject name.
	 *
	 * @param dto Faculty DTO
	 * @param userContext User context information
	 */
	@Override
	protected void populate(FacultyDTO dto, UserContext userContext) {

		if (dto.getCollegeId() > 0) {
			CollegeDTO collegeDto = collegeDao.findByPK(dto.getCollegeId(), userContext);
			dto.setCollegeName(collegeDto.getName());
		}

		if (dto.getCourseId() > 0) {
			CourseDTO courseDto = courseDao.findByPK(dto.getCourseId(), userContext);
			dto.setCourseName(courseDto.getName());
		}

		if (dto.getSubjectId() > 0) {
			SubjectDTO subjectDto = subjectDao.findByPK(dto.getSubjectId(), userContext);
			dto.setSubjectName(subjectDto.getName());
		}
	}

	/**
	 * Creates dynamic search criteria based on the provided FacultyDTO.
	 *
	 * @param dto Faculty DTO containing search parameters
	 * @param builder CriteriaBuilder instance
	 * @param qRoot Root entity reference
	 * @return List of predicates for query execution
	 */
	@Override
	protected List<Predicate> getWhereClause(FacultyDTO dto,
			CriteriaBuilder builder,
			Root<FacultyDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getFirstName())) {

			whereCondition.add(
					builder.like(qRoot.get("firstName"),
							dto.getFirstName() + "%"));
		}

		if (!isEmptyString(dto.getEmail())) {

			whereCondition.add(
					builder.like(qRoot.get("email"),
							dto.getEmail() + "%"));
		}

		if (!isEmptyString(dto.getCollegeName())) {

			whereCondition.add(
					builder.like(qRoot.get("collegeName"),
							dto.getCollegeName() + "%"));
		}

		if (!isEmptyString(dto.getCourseName())) {

			whereCondition.add(
					builder.like(qRoot.get("courseName"),
							dto.getCourseName() + "%"));
		}

		if (!isEmptyString(dto.getSubjectName())) {

			whereCondition.add(
					builder.like(qRoot.get("subjectName"),
							dto.getSubjectName() + "%"));
		}

		return whereCondition;
	}
}