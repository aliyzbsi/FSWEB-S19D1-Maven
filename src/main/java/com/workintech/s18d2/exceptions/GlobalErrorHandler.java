package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Slf4j
@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(PlantException.class)
    public ResponseEntity<ErrorResponse> handlerException(PlantException plantException){

        ErrorResponse fruitErrorResponse=new ErrorResponse(plantException.getMessage());
        return new ResponseEntity<>(fruitErrorResponse,plantException.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlerException(Exception exception){

        ErrorResponse errorResponse=new ErrorResponse(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
