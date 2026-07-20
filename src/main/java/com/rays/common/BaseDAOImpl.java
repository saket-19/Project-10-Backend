package com.rays.common;

import java.sql.Timestamp;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Generic JPA implementation of BaseDAOInt.
 * Provides common CRUD operations, search functionality,
 * and utility methods for all entity DAOs.
 *
 * @param <T> type of entity extending BaseDTO
 *
 * @author Saket
 */
public abstract class BaseDAOImpl<T extends BaseDTO> implements BaseDAOInt<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Sets EntityManager instance.
	 *
	 * @param entityManager JPA entity manager
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * Returns entity class type.
	 */
	public abstract Class<T> getDTOClass();

	/**
	 * Builds WHERE clause conditions for search queries.
	 *
	 * @param dto filter object
	 * @param builder criteria builder
	 * @param qRoot root entity
	 * @return list of predicates
	 */
	protected abstract List<Predicate> getWhereClause(T dto,
			CriteriaBuilder builder,
			Root<T> qRoot);

	/**
	 * Hook method for populating additional fields before save/update.
	 *
	 * @param dto entity object
	 * @param userContext current user context
	 */
	protected void populate(T dto, UserContext userContext) {
	}

	/**
	 * Adds a new record to database.
	 */
	public long add(T dto, UserContext userContext) {

		dto.setCreatedBy(userContext.getLoginId());
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedBy(userContext.getLoginId());
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

		populate(dto, userContext);

		entityManager.persist(dto);

		return dto.getId();
	}

	/**
	 * Updates an existing record.
	 */
	public void update(T dto, UserContext userContext) {

		dto.setModifiedBy(userContext.getLoginId());
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

		populate(dto, userContext);

		entityManager.merge(dto);
	}

	/**
	 * Deletes an entity.
	 */
	public void delete(T dto, UserContext userContext) {
		entityManager.remove(dto);
	}

	/**
	 * Finds entity by primary key.
	 */
	public T findByPK(long pk, UserContext userContext) {
		T dto = entityManager.find(getDTOClass(), pk);
		return dto;
	}

	/**
	 * Finds entity by unique attribute.
	 */
	public T findByUniqueKey(String attribute, Object val, UserContext userContext) {

		Class<T> dtoClass = getDTOClass();

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> cq = builder.createQuery(dtoClass);

		Root<T> qRoot = cq.from(dtoClass);

		Predicate condition = builder.equal(qRoot.get(attribute), val);

		cq.where(condition);

		TypedQuery<T> query = entityManager.createQuery(cq);

		List<T> list = query.getResultList();

		T dto = null;

		if (list.size() > 0) {
			dto = list.get(0);
		}

		return dto;
	}

	/**
	 * Creates criteria query for search.
	 */
	protected TypedQuery<T> createCriteria(T dto, UserContext userContext) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> cq = builder.createQuery(getDTOClass());

		Root<T> qRoot = cq.from(getDTOClass());

		cq.select(qRoot);

		List<Predicate> whereClause = getWhereClause(dto, builder, qRoot);

		cq.where(whereClause.toArray(new Predicate[whereClause.size()]));

		TypedQuery<T> query = entityManager.createQuery(cq);

		return query;
	}

	/**
	 * Search with pagination.
	 */
	public List search(T dto, int pageNo, int pageSize, UserContext userContext) {

		TypedQuery<T> query = createCriteria(dto, userContext);

		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		List list = query.getResultList();
		return list;
	}

	/**
	 * Search without pagination.
	 */
	public List search(T dto, UserContext userContext) {
		return search(dto, 0, 0, userContext);
	}

	/**
	 * Utility: checks empty string.
	 */
	protected boolean isEmptyString(String val) {
		return val == null || val.trim().length() == 0;
	}

	/**
	 * Utility: checks zero Double.
	 */
	protected boolean isZeroNumber(Double val) {
		return val == null || val == 0;
	}

	/**
	 * Utility: checks zero Long.
	 */
	protected boolean isZeroNumber(Long val) {
		return val == null || val == 0;
	}

	/**
	 * Utility: checks zero Integer.
	 */
	protected boolean isZeroNumber(Integer val) {
		return val == null || val == 0;
	}

	/**
	 * Utility: checks not null.
	 */
	protected boolean isNotNull(Object val) {
		return val != null;
	}

	/**
	 * Returns top 10 merit list results using HQL query.
	 */
	public List marksheetMeritList(String hql, UserContext userContext) {
		Query q = entityManager.createQuery(hql);
		q.setFirstResult(0);
		q.setMaxResults(10);
		List l = q.getResultList();
		return l;
	}
}