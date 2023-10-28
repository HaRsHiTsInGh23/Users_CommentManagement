package com.assign.commentsApi.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.assign.commentsApi.Exception.MissingParameterException;

/**
 * This is basically Global Exception Handler. 
 * It Handles all the exception arises in  the whole run of the application.
 * Handles the exception when validation checks fails.
 * Handles MissingParameterExceptions.
 *
 */
@RestControllerAdvice
public class AppExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errorsMap = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        errorsMap.put(error.getCode(), error.getDefaultMessage());
	    });
	    return errorsMap;
	}
	
	
	 @ExceptionHandler(MissingParameterException.class)
	    public ResponseEntity<String> handleMissingParameterException(MissingParameterException ex) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	    }

}

