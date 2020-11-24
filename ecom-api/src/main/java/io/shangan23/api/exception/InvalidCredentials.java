package io.shangan23.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN)
public class InvalidCredentials extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidCredentials(String message) {
		super(message);
	}

}
