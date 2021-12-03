package com.ecam.architecturesoftware.gestionnotes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class GradeNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(GradeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String GradeNotFoundHandler(GradeNotFoundException ex) {
        return ex.getMessage();
    }
}