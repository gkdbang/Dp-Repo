package com.gaurav.ecom2.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gaurav.ecom2.exceptionsModel.ErrorMessage;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
		
		@ExceptionHandler(CustomerNotFoundException.class)
		public final ResponseEntity<ErrorMessage> handleEmployeeNotFoundException
		(CustomerNotFoundException ex, WebRequest request){
			ErrorMessage errorMessage=new ErrorMessage(new Date(),ex.getMessage(),
					"404",request.getDescription(false));
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);	
		}
		
		@ExceptionHandler(CustomException.class)
		public final ResponseEntity<ErrorMessage> handleAllException(CustomException ex, WebRequest request){
			ErrorMessage errorMessage=new ErrorMessage(new Date(),ex.getMessage(),
					"500",request.getDescription(false));
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		
}
