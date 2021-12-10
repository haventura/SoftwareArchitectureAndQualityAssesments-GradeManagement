package com.ecam.architecturesoftware.gestionnotes;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {

    private @Id String id;
    private String name;
    private String FK_section ;
    private String FK_teacher ;

    Course() {}

    Course(String id,String name , String FK_section, String FK_teacher) {

        this.name = name;
        this.FK_section = FK_section;
        this.FK_teacher = FK_teacher;
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getFK_teacher() {
        return this.FK_teacher;
    }

    public String getFK_section() {
        return this.FK_section;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFK_section(String FK_section) {
        this.FK_section = FK_section;
    }

    public void setFK_teacher(String FK_teacher) {
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
