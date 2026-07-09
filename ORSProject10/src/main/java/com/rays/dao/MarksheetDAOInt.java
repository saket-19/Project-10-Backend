package com.rays.dao;

import java.util.List;

import com.rays.common.BaseDAOInt;
import com.rays.dto.MarksheetDTO;

/**
 * DAO interface for Marksheet entity operations.
 * Defines database access methods for MarksheetDTO.
 *
 * @author Saket
 */
public interface MarksheetDAOInt extends BaseDAOInt<MarksheetDTO> {

	/**
	 * Returns the merit list of students based on marks.
	 *
	 * @return List of MarksheetDTO objects in merit order
	 */
	public List<MarksheetDTO> getMeritList();

}