package com.ConceptsSpringBoot.globals.exceptions.handling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ConceptsSpringBoot.globals.exceptions.ApplicationException;

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
	/**
	 * Handles {@link ApplicationException} thrown in the application and returns a
	 * structured error response.
	 *
	 * @param ex the thrown ApplicationException
	 * @return HTTP response with JSON body like:
	 * 
	 *         <pre>
	 * {
	 *   "code": 1001,
	 *   "message": From the enum example: "Please provide email and password",
	 *   "whatToDo": From the enum example: "Send valid 'email' and 'pass' headers."
	 * }
	 *         </pre>
	 */
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<Map<String, Object>> handleApplicationException(ApplicationException ex) {
		Map<String, Object> body = new HashMap<>();
		body.put("code", ex.getCode());
		body.put("message", ex.getMessage());
		body.put("whatToDo", ex.getWhatToDo());

		return ResponseEntity
				.status(ex.getHttpStatus())
				.body(body);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleAllExceptions(Exception ex) {
		Map<String, String> error = new HashMap<>();
		error.put("error", ex.getClass().getSimpleName());
		error.put("message", ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
