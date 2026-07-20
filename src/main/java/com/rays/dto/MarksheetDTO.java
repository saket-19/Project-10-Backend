package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * DTO class representing Marksheet entity.
 * Contains student marksheet information such as
 * roll number, student details, and subject marks.
 *
 * @author Saket
 */
@Entity
@Table(name = "st_marksheet")
public class MarksheetDTO extends BaseDTO {

	@Column(name = "roll_no", length = 20)
	protected String rollNo = null;

	@Column(name = "student_id")
	protected Long studentId;

	@Column(name = "name", length = 50)
	protected String name = null;

	@Column(name = "physics")
	protected Integer physics;

	@Column(name = "chemistry")
	protected Integer chemistry;

	@Column(name = "maths")
	protected Integer maths;

	/**
	 * Returns roll number.
	 *
	 * @return Roll number
	 */
	public String getRollNo() {
		return rollNo;
	}

	/**
	 * Sets roll number.
	 *
	 * @param rollNo Roll number
	 */
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	/**
	 * Returns student id.
	 *
	 * @return Student ID
	 */
	public Long getStudentId() {
		return studentId;
	}

	/**
	 * Sets student id.
	 *
	 * @param studentId Student ID
	 */
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	/**
	 * Returns student name.
	 *
	 * @return Student name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets student name.
	 *
	 * @param name Student name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns physics marks.
	 *
	 * @return Physics marks
	 */
	public Integer getPhysics() {
		return physics;
	}

	/**
	 * Sets physics marks.
	 *
	 * @param physics Physics marks
	 */
	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	/**
	 * Returns chemistry marks.
	 *
	 * @return Chemistry marks
	 */
	public Integer getChemistry() {
		return chemistry;
	}

	/**
	 * Sets chemistry marks.
	 *
	 * @param chemistry Chemistry marks
	 */
	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	/**
	 * Returns maths marks.
	 *
	 * @return Maths marks
	 */
	public Integer getMaths() {
		return maths;
	}

	/**
	 * Sets maths marks.
	 *
	 * @param maths Maths marks
	 */
	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	/**
	 * Returns unique key field name.
	 *
	 * @return Unique key
	 */
	@Override
	public String getUniqueKey() {
		return "rollNo";
	}

	/**
	 * Returns unique value.
	 *
	 * @return Roll number
	 */
	@Override
	public String getUniqueValue() {
		return rollNo;
	}

	/**
	 * Returns display label.
	 *
	 * @return Label
	 */
	@Override
	public String getLabel() {
		return "Roll No";
	}

	/**
	 * Returns table name.
	 *
	 * @return Table name
	 */
	@Override
	public String getTableName() {
		return "Marksheet";
	}

	/**
	 * Returns display value.
	 *
	 * @return Value
	 */
	@Override
	public String getValue() {
		return null;
	}
}