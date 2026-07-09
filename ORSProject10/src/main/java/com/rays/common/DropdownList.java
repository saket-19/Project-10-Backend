package com.rays.common;

/**
 * Interface used for dropdown list representation.
 * Provides key-value structure for UI dropdowns.
 *
 * @author Saket
 */
public interface DropdownList {

	/**
	 * Returns the key (usually ID or code).
	 */
	public String getKey();

	/**
	 * Returns the display value (label shown in UI).
	 */
	public String getValue();

}