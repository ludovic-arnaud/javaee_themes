package fr.arnaud.ludovic.themes.dao.exception;
public class DataAccessException extends RuntimeException {

	public DataAccessException(String message, Throwable exception) {
		super(message, exception);
	}

	public DataAccessException(String message) {
		super(message);
	}

	public DataAccessException(Throwable exception) {
		super(exception);
	}

}
