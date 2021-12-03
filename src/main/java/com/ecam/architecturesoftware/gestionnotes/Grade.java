package com.ecam.architecturesoftware.gestionnotes;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Grade {
    private @Id @GeneratedValue Long id;
    private Float grade;

    Grade() {}

    Grade(Float grade) {

        this.grade = grade;
    }

    public Long getId() {
        return this.id;
    }

    public Float getGrade() {
        return this.grade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Grade))
            return false;
        Grade grade = (Grade) o;
        return Objects.equals(this.id, grade.id) && Objects.equals(this.grade, grade.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.grade);
    }

    @Override
    public String toString() {
        return "Grade{" + "id=" + this.id + ", grade='" + this.grade + '\'' + '}';
    }

}
