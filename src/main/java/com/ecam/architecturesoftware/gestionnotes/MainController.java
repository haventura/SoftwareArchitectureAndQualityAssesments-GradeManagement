package com.ecam.architecturesoftware.gestionnotes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MainController {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    MainController(StudentRepository studentRepository, CourseRepository courseRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
    }
    //===========================Students=======================================
    /*
    @GetMapping("/students")
    List<Student> allStudents()
    {
        return studentRepository.findAll();
    }
    */
    @PostMapping("/students")
    Student newStudent(@RequestBody Student newStudent)
    {
        return studentRepository.save(newStudent);
    }

    @GetMapping("/students/{id}")
    Student oneStudent(@PathVariable Long id)
    {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @PutMapping("/students/{id}")
    Student replaceStudent(@RequestBody Student newStudent, @PathVariable Long id)
    {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());

                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return studentRepository.save(newStudent);
                });
    }

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable Long id)
    {
        studentRepository.deleteById(id);
    }
    //===========================Courses=======================================
    @GetMapping("/courses")
    List<Course> allCourses()
    {
        return courseRepository.findAll();
    }

    @PostMapping("/courses")
    Course newCourse(@RequestBody Course newCourse)
    {
        return courseRepository.save(newCourse);
    }

    @GetMapping("/courses/{id}")
    Course oneCourse(@PathVariable String id)
    {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
    }

    @PutMapping("/courses/{id}")
    Course replaceCourse(@RequestBody Course newCourse, @PathVariable String id)
    {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setName(newCourse.getName());
                    course.setfk_Section(newCourse.getfk_Section());
                    course.setfk_Teacher(newCourse.getfk_Teacher());
                    return courseRepository.save(course);
                })
                .orElseGet(() -> {
                    newCourse.setId(id);
                    return courseRepository.save(newCourse);
                });
    }

    @DeleteMapping("/courses/{id}")
    void deleteCourse(@PathVariable String id)
    {
        courseRepository.deleteById(id);
    }

    //===========================Teachers=======================================

    @GetMapping("/teachers")
    List<Teacher> allTeachers()
    {
        return teacherRepository.findAll();
    }

    @PostMapping("/teachers")
    Teacher newTeacher(@RequestBody Teacher newTeacher)
    {
        return teacherRepository.save(newTeacher);
    }

    @GetMapping("/teachers/{id}")
    Teacher oneTeacher(@PathVariable String id)
    {

        return teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));
    }

    @PutMapping("/teachers/{id}")
    Teacher replaceTeacher(@RequestBody Teacher newTeacher, @PathVariable String id)
    {
        return teacherRepository.findById(id)
                .map(teacher -> {
                    teacher.setName(newTeacher.getName());
                    return teacherRepository.save(teacher);
                })
                .orElseGet(() -> {
                    newTeacher.setId(id);
                    return teacherRepository.save(newTeacher);
                });
    }

    @DeleteMapping("/teachers/{id}")
    void deleteTeacher(@PathVariable String id)
    {
        teacherRepository.deleteById(id);
    }
}
