package com.rays.common;

import java.util.List;

/**
 * Generic service interface providing business operations
 * for all DTO entities.
 *
 * @param <T> type of entity extending BaseDTO
 *
 * @author Saket
 */
public interface BaseServiceInt<T extends BaseDTO> {

	/**
	 * Adds a new entity.
	 */
	public long add(T dto, UserContext userContext);

	/**
	 * Updates an existing entity.
	 */
	public void update(T dto, UserContext userContext);

	/**
	 * Saves entity (add or update based on ID).
	 */
	public long save(T dto, UserContext userContext);

	/**
	 * Deletes entity by ID.
	 */
	public T delete(long id, UserContext userContext);

	/**
	 * Finds entity by primary key.
	 */
	public T findById(long id, UserContext userContext);

	/**
	 * Finds entity by unique attribute.
	 */
	public T findByUniqueKey(String attribute, String val, UserContext userContext);

	/**
	 * Search with pagination.
	 */
	public List search(T dto, int pageNo, int pageSize, UserContext userContext);

	/**
	 * Search without pagination.
	 */
	public List search(T dto, UserContext userContext);

}