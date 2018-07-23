package guru.springframework.exceptions;

/**
 * Created by piyush.b.kumar on Jul 23, 2018
 */
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -401969005921783835L;

	public ResourceNotFoundException() {
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}

	public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
