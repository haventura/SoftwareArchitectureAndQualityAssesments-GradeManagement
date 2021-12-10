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
class CourseController {

    private final CourseRepository repository;

    CourseController(CourseRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/courses")
    List<Course> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/courses")
    Course newCourse(@RequestBody Course newCourse) {
        return repository.save(newCourse);
    }

    // Single item

    @GetMapping("/courses/{id}")
    Course one(@PathVariable String id) {

        return repository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
    }

    @PutMapping("/courses/{id}")
    Course replaceCourse(@RequestBody Course newCourse, @PathVariable String id) {

        return repository.findById(id)
                .map(course -> {
                    course.setName(newCourse.getName());
                    course.setfk_Section(newCourse.getfk_Section());
                    course.setfk_Teacher(newCourse.getfk_Teacher());
                    return repository.save(course);
                })
                .orElseGet(() -> {
                    newCourse.setId(id);
                    return repository.save(newCourse);
                });
    }

    @DeleteMapping("/courses/{id}")
    void deleteCourse(@PathVariable String id) {
        repository.deleteById(id);
    }
}
