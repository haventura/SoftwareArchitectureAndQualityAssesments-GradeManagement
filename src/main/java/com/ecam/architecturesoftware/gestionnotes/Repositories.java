package com.ecam.architecturesoftware.gestionnotes;

import org.springframework.data.jpa.repository.JpaRepository;

interface StudentsRepository extends JpaRepository<Student, Long> { }
interface CoursesRepository extends JpaRepository<Course, String> { }
interface TeachersRepository extends JpaRepository<Teacher, String> { }
interface ResultsRepository extends JpaRepository<Result, Long> { }
interface SectionsRepository extends JpaRepository<Section, String> { }

