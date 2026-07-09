package com.rays.exception;

/**
 * Custom exception class for database-related errors.
 * This exception is thrown when a database operation
 * fails or encounters an unexpected condition.
 *
 * @author Saket
 */
public class DatabaseException extends RuntimeException {

	/**
	 * Constructs a new DatabaseException with the specified message.
	 *
	 * @param msg Exception message
	 */
	public DatabaseException(String msg) {
		super(msg);
	}
}