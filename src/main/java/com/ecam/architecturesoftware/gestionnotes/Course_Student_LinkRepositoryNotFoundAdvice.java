package com.ecam.architecturesoftware.gestionnotes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class Course_Student_LinkNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(Course_Student_LinkNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String Course_Student_LinkNotFoundHandler(Course_Student_LinkNotFoundException ex) {
        return ex.getMessage();
    }
}
