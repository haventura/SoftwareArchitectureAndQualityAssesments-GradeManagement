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
    CommandLineRunner initDatabase(TeachersRepository repositoryTeacher, StudentsRepository repositoryStudent, CoursesRepository repositoryCourse, ResultsRepository repositoryResult, SectionsRepository repositorySection) {

        return args -> {
            log.info("Preloading " + repositoryStudent.save(new Student(20001l,"Bilbo Baggins")));
            log.info("Preloading " + repositoryStudent.save(new Student(20002l, "Frodo Baggins")));
            log.info("Preloading " + repositoryStudent.save(new Student(20003l,"Jean Claude")));
            log.info("Preloading " + repositoryStudent.save(new Student(20004l,"Dawid Krasowski")));
            //
            log.info("Preloading " + repositoryCourse.save(new Course("id1","math", "LRG")));
            log.info("Preloading " + repositoryCourse.save(new Course("id2","langue", "LRG")));
            log.info("Preloading " + repositoryCourse.save(new Course("id3","python", "MLT")));
            //
            log.info("Preloading " + repositoryTeacher.save(new Teacher("LRG", "André Lorge")));
            log.info("Preloading " + repositoryTeacher.save(new Teacher("MLT", "Philipe Melotte")));
            //
            log.info("Preloading " + repositoryResult.save(new Result(20002l, "id2", 76.0f, 2021, 2)));
        };
    }
}
