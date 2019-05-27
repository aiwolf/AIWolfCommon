package org.aiwolf.client.lib;

/**
 * Thrown to indicate that the constructor of Content class has been passed an illegal string.
 * 
 * @author otsuki
 *
 */
public class IllegalContentStringException extends IllegalArgumentException {

	private static final long serialVersionUID = 752514963976415066L;

	/**
	 * Constructs an IllegalContentStringException with no detail message.
	 */
	public IllegalContentStringException() {
	}

	/**
	 * Constructs an IllegalContentStringException with the specified detail message.
	 * 
	 * @param s
	 */
	public IllegalContentStringException(String s) {
		super(s);
	}

	/**
	 * Constructs a new exception with the specified cause and a detail message of (cause==null ? null : cause.toString()) (which typically contains the class and detail message of cause).
	 * 
	 * @param message
	 * @param cause
	 */
	public IllegalContentStringException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * 
	 * @param cause
	 */
	public IllegalContentStringException(String message, Throwable cause) {
		super(message, cause);
	}

}
