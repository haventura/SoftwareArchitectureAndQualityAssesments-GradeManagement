package com.ecam.architecturesoftware.gestionnotes;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {

    private @Id String id;
    private String name;
    private String fk_Section ;
    private String fk_Teacher ;

    Course() {}

    Course(String id,String name , String fk_Section, String fk_Teacher) {

        this.name = name;
        this.fk_Section = fk_Section;
        this.fk_Teacher = fk_Teacher;
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getfk_Teacher() {
        return this.fk_Teacher;
    }

    public String getfk_Section() {
        return this.fk_Section;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setfk_Section(String fk_Section) {
        this.fk_Section = fk_Section;
    }

    public void setfk_Teacher(String FK_teacher) {
        this.fk_Teacher = fk_Teacher;
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
                && Objects.equals(this.fk_Section, course.fk_Section)
                && Objects.equals(this.fk_Teacher, course.fk_Teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.fk_Section, this.fk_Teacher);
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + this.id + ", name='" + this.name + ", fk_Section='" + this.fk_Section + ", fk_Teacher='" + this.fk_Teacher + '\'' + '}';
    }
}
