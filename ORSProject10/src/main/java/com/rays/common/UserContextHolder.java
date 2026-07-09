package com.rays.common;

/**
 * Holds UserContext in ThreadLocal scope.
 * Ensures each request has its own isolated user session data.
 *
 * Used mainly in JWT-based authentication systems
 * to access logged-in user details globally.
 *
 * @author Saket
 */
public class UserContextHolder {

	private static final ThreadLocal<UserContext> threadLocal = new ThreadLocal<>();

	/**
	 * Sets UserContext for current thread.
	 */
	public static void setContext(UserContext context) {
		threadLocal.set(context);
	}

	/**
	 * Returns UserContext for current thread.
	 */
	public static UserContext getContext() {
		return threadLocal.get();
	}

	/**
	 * Clears UserContext from current thread.
	 * Important to prevent memory leaks in thread pools.
	 */
	public static void clear() {
		threadLocal.remove();
	}
}