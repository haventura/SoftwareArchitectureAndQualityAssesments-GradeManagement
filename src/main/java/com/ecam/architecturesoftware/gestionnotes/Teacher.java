package com.ecam.architecturesoftware.gestionnotes;

        import java.util.Objects;

        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.Id;

@Entity
public class Teacher {

    private @Id String id;
    private String name;

    Teacher() {}

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
