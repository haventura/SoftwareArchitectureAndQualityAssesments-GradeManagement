package com.ecam.architecturesoftware.gestionnotes;

import org.springframework.data.jpa.repository.JpaRepository;

interface StudentRepository extends JpaRepository<Student, Long> {

}

interface GradeRepository extends JpaRepository<Grade, Long> {

}

interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
interface SectionRepository extends JpaRepository<Section, Long> {

}