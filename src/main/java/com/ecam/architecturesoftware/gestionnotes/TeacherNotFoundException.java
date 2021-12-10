package com.ecam.architecturesoftware.gestionnotes;

class TeacherNotFoundException extends RuntimeException {

    TeacherNotFoundException(String id) {
        super("Could not find teacher " + id);
    }
}