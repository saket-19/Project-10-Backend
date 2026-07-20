package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * DTO class representing Role entity.
 * Contains role-related information such as
 * role name and description.
 *
 * @author Saket
 */
@Entity
@Table(name = "st_role")
public class RoleDTO extends BaseDTO {

	@Column(name = "name", length = 50)
	private String name = null;

	@Column(name = "description", length = 100)
	private String description = null;

	/**
	 * Returns role name.
	 *
	 * @return Role name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets role name.
	 *
	 * @param name Role name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns role description.
	 *
	 * @return Role description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets role description.
	 *
	 * @param description Role description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns unique key field name.
	 *
	 * @return Unique key
	 */
	@Override
	public String getUniqueKey() {
		return "name";
	}

	/**
	 * Returns unique value.
	 *
	 * @return Role name
	 */
	@Override
	public String getUniqueValue() {
		return name;
	}

	/**
	 * Returns display label.
	 *
	 * @return Label
	 */
	@Override
	public String getLabel() {
		return "Role Name";
	}

	/**
	 * Returns table name.
	 *
	 * @return Table name
	 */
	@Override
	public String getTableName() {
		return "Role";
	}

	/**
	 * Returns display value.
	 *
	 * @return Role name
	 */
	@Override
	public String getValue() {
		return name;
	}
}