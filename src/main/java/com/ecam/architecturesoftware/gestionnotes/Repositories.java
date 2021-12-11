package com.ecam.architecturesoftware.gestionnotes;

import org.springframework.data.jpa.repository.JpaRepository;

interface StudentRepository extends JpaRepository<Student, Long> {

}

interface TeacherRepository extends JpaRepository<Teacher, String> {

}
interface SectionRepository extends JpaRepository<Section, String> {

}

interface CourseRepository extends JpaRepository<Course, String> {

}

interface ResultsRepository extends JpaRepository<Result, Long> {

}