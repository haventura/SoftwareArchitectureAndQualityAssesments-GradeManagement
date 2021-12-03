package com.ecam.architecturesoftware.gestionnotes;

class StudentNotFoundException extends RuntimeException {

    StudentNotFoundException(Long id) {
        super("Could not find student " + id);
    }
}