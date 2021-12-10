package com.ecam.architecturesoftware.gestionnotes;

class CourseNotFoundException extends RuntimeException {

    CourseNotFoundException(String id) {
        super("Could not find course " + id);
    }
}
