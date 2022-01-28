package com.taniltekdemir.n11.bootcampgraduationproject.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest){

        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), webRequest.getDescription(false), new Date());

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler //TODO: Usernotfoundexception'a düşüyor mu testi gerek
    public final ResponseEntity<Object> handleAllExceptions(UserNotFoundException ex, WebRequest webRequest){

        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), webRequest.getDescription(false), new Date());

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(CommonException ex, WebRequest webRequest){

        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), webRequest.getDescription(false), new Date());

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
