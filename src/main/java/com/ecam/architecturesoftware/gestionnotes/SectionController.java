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
class SectionController {

    private final SectionRepository repository;

    SectionController(SectionRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/sections")
    List<Section> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/sections")
    Section newSection(@RequestBody Section newSection) {
        return repository.save(newSection);
    }

    // Single item

    @GetMapping("/sections/{id}")
    Section one(@PathVariable String id) {

        return repository.findById(id)
                .orElseThrow(() -> new SectionNotFoundException(id));
    }

    @PutMapping("/sections/{id}")
    Section replaceSection(@RequestBody Section newSection, @PathVariable String id) {

        return repository.findById(id)
                .map(section -> {
                    section.setName(newSection.getName());
                    return repository.save(section);
                })
                .orElseGet(() -> {
                    newSection.setId(id);
                    return repository.save(newSection);
                });
    }

    @DeleteMapping("/sections/{id}")
    void deleteSection(@PathVariable String id) {
        repository.deleteById(id);
    }
}
