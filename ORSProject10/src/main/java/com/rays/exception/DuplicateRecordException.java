package com.rays.exception;

/**
 * Custom exception class for duplicate record errors.
 * This exception is thrown when an attempt is made
 * to create or update a record that already exists.
 *
 * @author Saket
 */
public class DuplicateRecordException extends RuntimeException {

	/**
	 * Constructs a new DuplicateRecordException
	 * with the specified message.
	 *
	 * @param msg Exception message
	 */
	public DuplicateRecordException(String msg) {
		super(msg);
	}

}