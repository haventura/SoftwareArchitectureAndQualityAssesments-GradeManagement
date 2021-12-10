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
    private Long FK_Student ;
    private String FK_Course ;
    private Float grade ;
    private Integer schoolYear;
    private Integer semester;

    Course_Student_Link(Long FK_Student , String FK_Course, Float grade, Integer schoolYear, Integer semester) {

        this.FK_Student = FK_Student;
        this.FK_Course = FK_Course;
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
        return FK_Student;
    }

    public void setFK_Student(Long FK_Student) {
        this.FK_Student = FK_Student;
    }

    public String getFK_Course() {
        return FK_Course;
    }

    public void setFK_Course(String FK_Course) {
        this.FK_Course = FK_Course;
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
                && Objects.equals(this.FK_Student, link.FK_Student)
                && Objects.equals(this.FK_Course, link.FK_Course)
                && Objects.equals(this.grade, link.grade)
                && Objects.equals(this.schoolYear, link.schoolYear)
                && Objects.equals(this.semester, link.semester);

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.FK_Student, this.FK_Course, this.grade, this.schoolYear, this.semester);
    }

    @Override
    public String toString() {
        return "link{" + "id=" + this.id + ", FK_Student='" + this.FK_Student + ", FK_Course='" + this.FK_Course + ", FK_Grade='" + this.grade + ", schoolYear='" + this.schoolYear + ", semester='" + this.semester + '\'' + '}';
    }
}
