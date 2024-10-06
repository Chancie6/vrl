package com.vrl.exceptions;

import com.vrl.dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails>ResourceNotFoundException(
            ResourceNotFoundException ex, WebRequest webRequest
            ){
        ErrorDetails error = new ErrorDetails(
                ex.getMessage(),new Date(),webRequest.getDescription(false));
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails>globalecxception(Exception exp,WebRequest webRequest){
        ErrorDetails error2 = new ErrorDetails(exp.getMessage(),new Date(),webRequest.getDescription(false) );
        return new ResponseEntity<>(error2,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
