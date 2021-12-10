package com.ecam.architecturesoftware.gestionnotes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(StudentRepository repository, CourseRepository repositoryCourse,SectionRepository repositorySection) {

        return args -> {
            log.info("Preloading " + repository.save(new Student(20001l,"Bilbo Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Student(20002l, "Frodo Baggins", "thief")));
            log.info("Preloading " + repository.save(new Student(20003l,"Jean Claude", "Master")));
            log.info("Preloading " + repository.save(new Student(20004l,"Dawid Krasowski", "DBArchitect")));
            //
            log.info("Preloading " + repositoryCourse.save(new Course("id1","math", "UE1", "mat")));
            log.info("Preloading " + repositoryCourse.save(new Course("id2","langue", "UE1", "lan")));
            log.info("Preloading " + repositoryCourse.save(new Course("id3","python", "UE2", "pyt")));
            //
            log.info("Preloading " + repositorySection.save(new Section("UE1", "coursDeBase")));
        };
    }
}
