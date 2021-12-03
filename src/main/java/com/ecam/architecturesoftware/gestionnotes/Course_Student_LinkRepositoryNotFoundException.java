package com.ecam.architecturesoftware.gestionnotes;

class Course_Student_LinkNotFoundException extends RuntimeException {
    Course_Student_LinkNotFoundException(Long id) {
        super("Could not find course_student_link " + id);
    }
}
