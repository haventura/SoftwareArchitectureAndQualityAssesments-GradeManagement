package com.ecam.architecturesoftware.gestionnotes;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Section {
    private @Id @GeneratedValue Long id;
    private String name;
    private Long FK_course;
    Section() {}

    Section(String name,Long FK_course) {

        this.name = name;
        this.FK_course = FK_course;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    public Long getFK_course() {
        return this.FK_course;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setFK_course(Long FK_course) {
        this.FK_course = FK_course;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Section))
            return false;
        Section section = (Section) o;
        return Objects.equals(this.id, section.id) && Objects.equals(this.name, section.name) && Objects.equals(this.FK_course, section.FK_course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.FK_course);
    }

    @Override
    public String toString() {
        return "Section{" + "id=" + this.id + ", section='" + this.name + '\'' + ", FK_course ='" + this.FK_course + '\'' +'}';
    }

}
