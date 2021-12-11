package com.ecam.architecturesoftware.gestionnotes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class StudentNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String StudentNotFoundHandler(StudentNotFoundException ex) {
        return ex.getMessage();
    }
}
@ControllerAdvice
class CourseNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CourseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String GradeNotFoundHandler(CourseNotFoundException ex) {
        return ex.getMessage();
    }
}
@ControllerAdvice
class TeacherNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(TeacherNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String TeacherNotFoundHandler(TeacherNotFoundException ex) {
        return ex.getMessage();
    }
}
@ControllerAdvice
class ResultNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ResultNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ResultNotFoundHandler(ResultNotFoundException ex) {
        return ex.getMessage();
    }
}
@ControllerAdvice
class SectionNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(SectionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String SectionNotFoundHandler(SectionNotFoundException ex) {
        return ex.getMessage();
    }
}

class StudentNotFoundException extends RuntimeException {
    StudentNotFoundException(Long id) {
        super("Could not find student " + id);
    }
}
class CourseNotFoundException extends RuntimeException {
    CourseNotFoundException(String id) {
        super("Could not find course " + id);
    }
}
class TeacherNotFoundException extends RuntimeException {
    TeacherNotFoundException(String id) {
        super("Could not find teacher " + id);
    }
}
class ResultNotFoundException extends RuntimeException {
    ResultNotFoundException(Long id) {
        super("Could not find result " + id);
    }
}
class SectionNotFoundException extends RuntimeException{
    SectionNotFoundException(String id) {
        super("Could not find section " + id);
    }
}