package com.student.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Student has no content")
public class StudentNoContentException extends RuntimeException {

	public StudentNoContentException(String message) {
		super(message);
	}

}
