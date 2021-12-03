package com.ecam.architecturesoftware.gestionnotes;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {

    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private Integer Fk_Section ;
    private Integer Fk_Teacher ;

    Course() {}

    Course(String name , Integer Fk_Section, Integer Fk_Teacher) {

        this.name = name;
        this.Fk_Section = Fk_Section;
        this.Fk_Teacher = Fk_Teacher;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Course))
            return false;
        Course course = (Course) o;
        return Objects.equals(this.id, course.id) && Objects.equals(this.name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + this.id + ", name='" + this.name + '\'' + '}';
    }
}
