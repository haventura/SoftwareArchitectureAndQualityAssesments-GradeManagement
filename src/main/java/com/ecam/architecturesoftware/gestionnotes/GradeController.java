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
class GradeController {

    private final GradeRepository repository;

    GradeController(GradeRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/grades")
    List<Grade> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/grades")
    Grade newGrade(@RequestBody Grade newGrade) {
        return repository.save(newGrade);
    }

    // Single item

    @GetMapping("/grades/{id}")
    Grade one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new GradeNotFoundException(id));
    }

    @PutMapping("/grades/{id}")
    Grade replaceGrade(@RequestBody Grade newGrade, @PathVariable Long id) {

        return repository.findById(id)
                .map(grade -> {
                    grade.setGrade(newGrade.getGrade());
                    return repository.save(grade);
                })
                .orElseGet(() -> {
                    newGrade.setId(id);
                    return repository.save(newGrade);
                });
    }

    @DeleteMapping("/graddes/{id}")
    void deleteGrade(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
