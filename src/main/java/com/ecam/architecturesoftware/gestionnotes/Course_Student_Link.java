package com.ecam.architecturesoftware.gestionnotes;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course_Student_Link {

    private @Id
    @GeneratedValue
    Long id;
    private Long fk_Student ;
    private String fk_Course ;
    private Float grade ;
    private Integer schoolYear;
    private Integer semester;

    Course_Student_Link(Long fk_Student , String fk_Course, Float grade, Integer schoolYear, Integer semester) {

        this.fk_Student = fk_Student;
        this.fk_Course = fk_Course;
        this.grade = grade;
        this.schoolYear = schoolYear;
        this.semester = semester;
    }
    Course_Student_Link() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFK_Student() {
        return fk_Student;
    }

    public void setFK_Student(Long FK_Student) {
        this.fk_Student = fk_Student;
    }

    public String getFK_Course() {
        return fk_Course;
    }

    public void setFK_Course(String FK_Course) {
        this.fk_Course = fk_Course;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public Integer getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(Integer schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Course_Student_Link))
            return false;
        Course_Student_Link link = (Course_Student_Link) o;
        return Objects.equals(this.id, link.id)
                && Objects.equals(this.fk_Student, link.fk_Student)
                && Objects.equals(this.fk_Course, link.fk_Course)
                && Objects.equals(this.grade, link.grade)
                && Objects.equals(this.schoolYear, link.schoolYear)
                && Objects.equals(this.semester, link.semester);

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.fk_Student, this.fk_Course, this.grade, this.schoolYear, this.semester);
    }

    @Override
    public String toString() {
        return "link{" + "id=" + this.id + ", fk_Student='" + this.fk_Student + ", fk_Course='" + this.fk_Course + ", Grade='" + this.grade + ", schoolYear='" + this.schoolYear + ", semester='" + this.semester + '\'' + '}';
    }
}
