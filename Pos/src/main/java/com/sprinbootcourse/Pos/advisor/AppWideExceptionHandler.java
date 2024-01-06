package com.sprinbootcourse.Pos.advisor;

import com.sprinbootcourse.Pos.exception.NotFoundException;
import com.sprinbootcourse.Pos.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> notFoundExceptionHandler(NotFoundException ex){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"ERROR",ex.getMessage()), HttpStatus.NOT_FOUND
        );
    }
}
