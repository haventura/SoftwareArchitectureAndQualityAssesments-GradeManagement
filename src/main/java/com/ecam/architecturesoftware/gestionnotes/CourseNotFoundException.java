package com.ecam.architecturesoftware.gestionnotes;

class CourseNotFoundException extends RuntimeException {

    CourseNotFoundException(Long id) {
        super("Could not find course " + id);
    }
}
