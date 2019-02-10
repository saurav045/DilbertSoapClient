package com.ing.assessment.dilbert.config;

import javax.servlet.http.HttpServletRequest;
import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DilbertException {

	@ExceptionHandler(DatatypeConfigurationException.class)
	public String handleException(HttpServletRequest request, Exception ex){
		return "Error: Incorrect Date format";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleAllException(HttpServletRequest request, Exception ex){
		return "UnExpected Error";
	}
}
