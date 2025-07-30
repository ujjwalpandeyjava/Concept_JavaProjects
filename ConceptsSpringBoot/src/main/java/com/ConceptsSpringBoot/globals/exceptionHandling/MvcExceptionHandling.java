package com.ConceptsSpringBoot.globals.exceptionHandling;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @return This will return error.html or error.jsp view with the error message
 */
@ControllerAdvice(basePackages = "com.ConceptsSpringBoot")
public class MvcExceptionHandling {

	// Add more

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("message", ex.getMessage());
		return mv;
	}
}
