package com.tw.sellsoftware.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BindException.class)
    public ResponseEntity handleBindException(BindException ex) {
        StringBuilder strb = new StringBuilder();
        ex.getBindingResult().getAllErrors().stream().forEach(error -> strb.append(error.getDefaultMessage()).append(";"));
        return new ResponseEntity(strb.toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity globalException(Exception ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
