package com.ecam.architecturesoftware.gestionnotes;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Course_Student_LinkController {

    private final Course_Student_LinkRepository repository;

    Course_Student_LinkController(Course_Student_LinkRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/links")
    List<Course_Student_Link> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/links")
    Course_Student_Link newCourse_Student_Link(@RequestBody Course_Student_Link newCourse_Student_Link) {
        return repository.save(newCourse_Student_Link);
    }

    // Single item

    @GetMapping("/links/{id}")
    Course_Student_Link one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new Course_Student_LinkNotFoundException(id));
    }

    @PutMapping("/links/{id}")
    Course_Student_Link replaceCourse_Student_Link(@RequestBody Course_Student_Link newCourse_Student_Link, @PathVariable Long id) {

        return repository.findById(id)
                .map(link -> {;
                    link.setFK_Student(newCourse_Student_Link.getFK_Student());
                    link.setFK_Course(newCourse_Student_Link.getFK_Course());
                    link.setGrade(newCourse_Student_Link.getGrade());
                    link.setSchoolYear(newCourse_Student_Link.getSchoolYear());
                    link.setSemester(newCourse_Student_Link.getSemester());

                    return repository.save(link);
                })
                .orElseGet(() -> {
                    newCourse_Student_Link.setId(id);
                    return repository.save(newCourse_Student_Link);
                });
    }

    @DeleteMapping("/links/{id}")
    void deleteCourse_Student_Link(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
