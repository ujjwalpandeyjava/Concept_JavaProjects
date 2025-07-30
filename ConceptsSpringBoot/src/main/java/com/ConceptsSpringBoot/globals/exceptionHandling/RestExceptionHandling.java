package com.ConceptsSpringBoot.globals.exceptionHandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @return This returns a JSON like
 *         {
 *         "error": "RuntimeException",
 *         "message": "Something went wrong"
 *         }
 */
@RestControllerAdvice(basePackages = "com.ConceptsSpringBoot")
public class RestExceptionHandling {

	// Add more

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleAllExceptions(Exception ex) {
		Map<String, String> error = new HashMap<>();
		error.put("error", ex.getClass().getSimpleName());
		error.put("message", ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
