package com.rays.common;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * Base entity class for all DTOs.
 * Provides common fields like id, audit information
 * (createdBy, modifiedBy, timestamps) and dropdown support.
 *
 * @author Saket
 */
@MappedSuperclass
public abstract class BaseDTO implements DropdownList {

	@Id
	@GeneratedValue(generator = "ncsPk")
	@GenericGenerator(name = "ncsPk", strategy = "native")
	@Column(name = "id", unique = true, nullable = false)
	protected Long id;

	@Column(name = "created_by", length = 50)
	protected String createdBy = "root";

	@Column(name = "modified_by", length = 50)
	protected String modifiedBy = "root";

	@Column(name = "created_datetime")
	protected Timestamp createdDatetime;

	@Column(name = "modified_datetime")
	protected Timestamp modifiedDatetime;

	/**
	 * Returns unique key column name for the entity.
	 */
	public abstract String getUniqueKey();

	/**
	 * Returns unique value of the entity.
	 */
	public abstract String getUniqueValue();

	/**
	 * Returns label for UI display.
	 */
	public abstract String getLabel();

	/**
	 * Returns database table name.
	 */
	public abstract String getTableName();

	/**
	 * Returns entity ID.
	 *
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets entity ID.
	 *
	 * @param id entity id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns created by user.
	 *
	 * @return createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets created by user.
	 *
	 * @param createdBy creator username
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Returns modified by user.
	 *
	 * @return modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * Sets modified by user.
	 *
	 * @param modifiedBy modifier username
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * Returns created timestamp.
	 *
	 * @return createdDatetime
	 */
	public Timestamp getCreatedDatetime() {
		return createdDatetime;
	}

	/**
	 * Sets created timestamp.
	 *
	 * @param createdDatetime creation time
	 */
	public void setCreatedDatetime(Timestamp createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	/**
	 * Returns modified timestamp.
	 *
	 * @return modifiedDatetime
	 */
	public Timestamp getModifiedDatetime() {
		return modifiedDatetime;
	}

	/**
	 * Sets modified timestamp.
	 *
	 * @param modifiedDatetime modification time
	 */
	public void setModifiedDatetime(Timestamp modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}

	/**
	 * Returns primary key as string.
	 *
	 * @return id as String
	 */
	public String getKey() {
		return String.valueOf(id);
	}

	/**
	 * Returns dropdown value.
	 *
	 * @return value (default null)
	 */
	public String getValue() {
		return null;
	}
}