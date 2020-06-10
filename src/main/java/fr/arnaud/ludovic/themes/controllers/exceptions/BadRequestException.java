package fr.arnaud.ludovic.themes.controllers.exceptions;

public class BadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3118794584614139053L;

	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BadRequestException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BadRequestException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
