package com.ecam.architecturesoftware.gestionnotes;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Student {
    private @Id Long id;
    private String name;

    public Student() {}

    Student(Long id, String name) {
        this.name = name;
        this.id = id;
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
        if (!(o instanceof Student))
            return false;
        Student student = (Student) o;
        return Objects.equals(this.id, student.id) && Objects.equals(this.name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + this.id + ", name='" + this.name + '\'' +  '}';
    }
}
@Entity
class Course {
    private @Id String id;
    private String name;
    private String fk_Teacher ;

    public Course() {}

    Course(String id, String name, String fk_Teacher) {
        this.name = name;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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
                && Objects.equals(this.fk_Teacher, course.fk_Teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.fk_Teacher);
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + this.id + ", name='" + this.name + ", fk_Teacher='" + this.fk_Teacher + '\'' + '}';
    }
}

@Entity
class Teacher {
    private @Id String id;
    private String name;

    public Teacher() {}

    Teacher(String id,String name) {

        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Teacher))
            return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(this.id, teacher.id) && Objects.equals(this.name, teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString() {
        return "Teacher{" + "id=" + this.id + ", name='" + this.name + '\'' + '}';
    }
}

@Entity
class Result {
    private @Id
    @GeneratedValue
    Long id;
    private Long fk_Student ;
    private String fk_Course ;
    private Float grade ;
    private Integer schoolYear;
    private Integer semester;

    public Result() {}

    Result(Long fk_Student , String fk_Course, Float grade, Integer schoolYear, Integer semester) {
        this.fk_Student = fk_Student;
        this.fk_Course = fk_Course;
        this.grade = grade;
        this.schoolYear = schoolYear;
        this.semester = semester;
    }

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
        if (!(o instanceof Result))
            return false;
        Result link = (Result) o;
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
        return "result{" + "id=" + this.id + ", fk_Student='" + this.fk_Student + ", fk_Course='" + this.fk_Course + ", Grade='" + this.grade + ", schoolYear='" + this.schoolYear + ", semester='" + this.semester + '\'' + '}';
    }
}

@Entity
class Section {
    private @Id String id;
    private String name;

    public Section() {}

    Section(String id,String name) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Section))
            return false;
        Section section = (Section) o;
        return Objects.equals(this.id, section.id) && Objects.equals(this.name, section.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString() {
        return "Section{" + "id=" + this.id + ", section='" + this.name + '\'' +'}';
    }
}

