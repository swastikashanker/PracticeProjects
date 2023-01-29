package com.globallogic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(TutorialNotFoundException.class)
    public ResponseEntity<String> tutorialNotFound(TutorialNotFoundException exception){
        return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TutorialAlreadyExist.class)
    public ResponseEntity<String> tutorialAlreadyExist(TutorialAlreadyExist exception){
        return new ResponseEntity<String>(exception.getMessage(),HttpStatus.ALREADY_REPORTED);
    }
}
