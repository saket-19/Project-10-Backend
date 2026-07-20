package com.rays.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Standard API response wrapper used across controllers.
 * Encapsulates success status, messages, input errors, and response data.
 *
 * @author Saket
 */
public class ORSResponse {

	public static final String INPUT_ERROR = "inputerror";
	public static final String MESSAGE = "message";
	public static final String DATA = "data";

	private Map<String, Object> result = new HashMap<String, Object>();

	public boolean success = false;

	/**
	 * Default constructor.
	 */
	public ORSResponse() {
	}

	/**
	 * Constructor with success flag.
	 */
	public ORSResponse(boolean success) {
		this.success = success;
	}

	/**
	 * Constructor with success and message.
	 */
	public ORSResponse(boolean success, String message) {
		this.success = success;
		addMessage(message);
	}

	/**
	 * Constructor with success, message, and data.
	 */
	public ORSResponse(boolean success, String message, Object value) {
		this.success = success;
		addMessage(message);
		addData(value);
	}

	/**
	 * Returns success status.
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Sets success status.
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * Returns response map.
	 */
	public Map<String, Object> getResult() {
		return result;
	}

	/**
	 * Sets response map.
	 */
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	/**
	 * Adds input validation error.
	 */
	public void addInputError(Object value) {
		result.put(INPUT_ERROR, value);
	}

	/**
	 * Adds message to response.
	 */
	public void addMessage(Object value) {
		result.put(MESSAGE, value);
	}

	/**
	 * Adds data payload.
	 */
	public void addData(Object value) {
		result.put(DATA, value);
	}

	/**
	 * Adds custom key-value pair to response.
	 */
	public void addResult(String key, Object value) {
		result.put(key, value);
	}
}