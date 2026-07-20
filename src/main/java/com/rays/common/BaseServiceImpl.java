package com.rays.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.exception.DatabaseException;
import com.rays.exception.DuplicateRecordException;

/**
 * Generic service implementation providing common business logic
 * for all entities using BaseDAO.
 *
 * Handles CRUD operations, transaction management, and basic validation.
 *
 * @param <T> DTO type extending BaseDTO
 * @param <D> DAO type extending BaseDAOInt
 *
 * @author Saket
 */
public class BaseServiceImpl<T extends BaseDTO, D extends BaseDAOInt<T>>
		implements BaseServiceInt<T> {

	@Autowired
	protected D baseDao;

	/**
	 * Adds a new record.
	 */
	@Transactional(readOnly = false)
	public long add(T dto, UserContext userContext)
			throws DuplicateRecordException {
		long pk = baseDao.add(dto, userContext);
		return pk;
	}

	/**
	 * Updates an existing record while preserving creation metadata.
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(T dto, UserContext userContext)
			throws DuplicateRecordException {

		T oldDto = baseDao.findByPK(dto.getId(), userContext);

		if (oldDto != null) {
			dto.setCreatedBy(oldDto.getCreatedBy());
			dto.setCreatedDatetime(oldDto.getCreatedDatetime());
		}

		baseDao.update(dto, userContext);
	}

	/**
	 * Saves record (add or update based on ID).
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public long save(T dto, UserContext userContext)
			throws DuplicateRecordException {

		Long id = dto.getId();

		if (id != null && id > 0) {
			update(dto, userContext);
		} else {
			id = add(dto, userContext);
		}

		return id;
	}

	/**
	 * Finds record by primary key.
	 */
	@Transactional(readOnly = true)
	public T findById(long id, UserContext userContext) {
		T dto = baseDao.findByPK(id, userContext);
		return dto;
	}

	/**
	 * Deletes a record by ID.
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public T delete(long id, UserContext userContext) {

		T dto = findById(id, userContext);

		if (dto == null) {
			throw new DatabaseException("Record not found");
		}

		baseDao.delete(dto, userContext);
		return dto;
	}

	/**
	 * Finds record by unique key.
	 */
	@Transactional(readOnly = true)
	public T findByUniqueKey(String attribute, String val,
			UserContext userContext) {

		T dto = baseDao.findByUniqueKey(attribute, val, userContext);
		return dto;
	}

	/**
	 * Search with pagination.
	 */
	@Transactional(readOnly = true)
	public List<T> search(T dto, int pageNo, int pageSize,
			UserContext userContext) {
		return baseDao.search(dto, pageNo, pageSize, userContext);
	}

	/**
	 * Search without pagination.
	 */
	@Transactional(readOnly = true)
	public List<T> search(T dto, UserContext userContext) {
		return baseDao.search(dto, userContext);
	}
}