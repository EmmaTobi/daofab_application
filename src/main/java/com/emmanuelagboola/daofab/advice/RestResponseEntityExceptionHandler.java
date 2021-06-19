package com.emmanuelagboola.daofab.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.emmanuelagboola.daofab.exceptions.DaofabException;

/*
 * An Advisory that helps handle unhandled exceptions 
 */
@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	/*
	 *DaofabException handler
	 *@param DaofabException ex the unhandled exception
	 *@param WebRequest request the request instance that results in the exception
	 */
    @ExceptionHandler(value  = { DaofabException.class })
    protected ResponseEntity<DaofabErrorMessage> handleDaofabException(DaofabException exception, WebRequest request) {
    	DaofabErrorMessage message = new DaofabErrorMessage(exception.getMessage(),  HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<DaofabErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }
}
