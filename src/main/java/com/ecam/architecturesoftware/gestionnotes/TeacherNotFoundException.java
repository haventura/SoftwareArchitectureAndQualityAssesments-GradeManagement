package com.ecam.architecturesoftware.gestionnotes;

class TeacherNotFoundException extends RuntimeException {

    TeacherNotFoundException(Long id) {
        super("Could not find teacher " + id);
    }
}