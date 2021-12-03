package com.ecam.architecturesoftware.gestionnotes;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class StudentController {
    private final StudentRepository repository;

    StudentController(StudentRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/Students")
    List<Student> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/Students")
    Student newStudent(@RequestBody Student newStudent) {
        return repository.save(newStudent);
    }

    // Single item

    @GetMapping("/Students/{id}")
    Student one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @PutMapping("/Students/{id}")
    Student replaceStudent(@RequestBody Student newStudent, @PathVariable Long id) {

        return repository.findById(id)
                .map(Student -> {
                    Student.setName(newStudent.getName());
                    Student.setRole(newStudent.getRole());
                    return repository.save(Student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return repository.save(newStudent);
                });
    }

    @DeleteMapping("/Students/{id}")
    void deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
