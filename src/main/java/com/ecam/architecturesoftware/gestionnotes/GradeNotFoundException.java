package com.ecam.architecturesoftware.gestionnotes;

public class GradeNotFoundException extends RuntimeException {

    GradeNotFoundException(Long id) {
        super("Could not find teacher " + id);
    }
}
