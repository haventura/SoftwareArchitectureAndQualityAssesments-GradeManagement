package com.ecam.architecturesoftware.gestionnotes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface StudentRepository extends JpaRepository<Student, Long> {

}

<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
interface TeacherRepository extends JpaRepository<Teacher, String> {

}
interface SectionRepository extends JpaRepository<Section, String> {

}

interface CourseRepository extends JpaRepository<Course, String> {

}

interface Course_Student_LinkRepository extends JpaRepository<Course_Student_Link, Long> {

}