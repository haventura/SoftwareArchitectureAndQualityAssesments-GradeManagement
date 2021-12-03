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
    private Integer FK_section ;
    private Integer FK_teacher ;

    Course() {}

    Course(String name , Integer FK_section, Integer FK_teacher) {

        this.name = name;
        this.FK_section = FK_section;
        this.FK_teacher = FK_teacher;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getFK_teacher() {
        return this.FK_teacher;
    }

    public Integer getFK_section() {
        return this.FK_section;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFK_section(Integer FK_section) {
        this.FK_section = FK_section;
    }

    public void setFK_teacher(Integer FK_teacher) {
        this.FK_teacher = FK_teacher;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Course))
            return false;
        Course course = (Course) o;
        return Objects.equals(this.id, course.id)
                && Objects.equals(this.name, course.name)
                && Objects.equals(this.FK_section, course.FK_section)
                && Objects.equals(this.FK_teacher, course.FK_teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.FK_section, this.FK_teacher);
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + this.id + ", name='" + this.name + ", FK_section='" + this.FK_section + ", FK_teacher='" + this.FK_teacher + '\'' + '}';
    }
}
