package com.rays.common;

import java.util.List;

/**
 * Generic DAO interface providing basic CRUD operations
 * and search functionality for all DTO entities.
 *
 * @param <T> type of entity extending BaseDTO
 *
 * @author Saket
 */
public interface BaseDAOInt<T extends BaseDTO> {

	/**
	 * Adds a new entity to the database.
	 *
	 * @param dto entity to add
	 * @param userContext current user context
	 * @return generated primary key
	 */
	public long add(T dto, UserContext userContext);

	/**
	 * Updates an existing entity.
	 *
	 * @param dto entity to update
	 * @param userContext current user context
	 */
	public void update(T dto, UserContext userContext);

	/**
	 * Deletes an entity from the database.
	 *
	 * @param dto entity to delete
	 * @param userContext current user context
	 */
	public void delete(T dto, UserContext userContext);

	/**
	 * Finds an entity by primary key.
	 *
	 * @param pk primary key
	 * @param userContext current user context
	 * @return entity if found, otherwise null
	 */
	public T findByPK(long pk, UserContext userContext);

	/**
	 * Finds an entity by unique attribute.
	 *
	 * @param attribute column name
	 * @param val value to search
	 * @param userContext current user context
	 * @return matching entity
	 */
	public T findByUniqueKey(String attribute, Object val, UserContext userContext);

	/**
	 * Searches entities with pagination.
	 *
	 * @param dto filter criteria
	 * @param pageNo page number
	 * @param pageSize page size
	 * @param userContext current user context
	 * @return list of matching entities
	 */
	public List search(T dto, int pageNo, int pageSize, UserContext userContext);

	/**
	 * Searches entities without pagination.
	 *
	 * @param dto filter criteria
	 * @param userContext current user context
	 * @return list of matching entities
	 */
	public List search(T dto, UserContext userContext);

}