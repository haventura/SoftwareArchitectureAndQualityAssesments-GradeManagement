package com.ecam.architecturesoftware.gestionnotes;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
class MainController {
    private final StudentsRepository studentRepository;
    private final CoursesRepository courseRepository;
    private final TeachersRepository teacherRepository;
    private final ResultsRepository resultsRepository;

    MainController(StudentsRepository studentRepository, CoursesRepository courseRepository, TeachersRepository teacherRepository, ResultsRepository resultsRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.resultsRepository = resultsRepository;
    }
    //===========================Students=======================================
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
    @GetMapping("/students")
    List<Student> allStudents()
    {
        return studentRepository.findAll();
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
    @GetMapping("/courses")
    List<Course> allCourses()
    {
        return courseRepository.findAll();
    }
    @PutMapping("/courses/{id}")
    Course replaceCourse(@RequestBody Course newCourse, @PathVariable String id)
    {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setName(newCourse.getName());
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
    @GetMapping("/teachers")
    List<Teacher> allTeachers()
    {
        return teacherRepository.findAll();
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
    //===============================Results=====================================
    @PostMapping("/results")
    Result newResult(@RequestBody Result newCourse_Student_Link)
    {
        return resultsRepository.save(newCourse_Student_Link);
    }
    @GetMapping("/results/{id}")
    Result one(@PathVariable Long id)
    {
        return resultsRepository.findById(id)
                .orElseThrow(() -> new ResultNotFoundException(id));
    }
    @GetMapping("/results")
    List<Result> allResults()
    {
        return resultsRepository.findAll();
    }
    @PutMapping("/results/{id}")
    Result replaceResult(@RequestBody Result newResult, @PathVariable Long id)
    {
        return resultsRepository.findById(id)
                .map(result -> {;
                    result.setFK_Student(newResult.getFK_Student());
                    result.setFK_Course(newResult.getFK_Course());
                    result.setGrade(newResult.getGrade());
                    result.setSchoolYear(newResult.getSchoolYear());
                    result.setSemester(newResult.getSemester());

                    return resultsRepository.save(result);
                })
                .orElseGet(() -> {
                    newResult.setId(id);
                    return resultsRepository.save(newResult);
                });
    }
    @DeleteMapping("/results/{id}")
    void deleteResult(@PathVariable Long id)
    {
        resultsRepository.deleteById(id);
    }
}
