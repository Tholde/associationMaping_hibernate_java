package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int studentId;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_cours", joinColumns = @JoinColumn(name = "students_id"),
        inverseJoinColumns = @JoinColumn(name = "courses_id"))
    private List<Cours> courses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cours> getCours() {
        return courses;
    }

    public void setCours(List<Cours> cours) {
        this.courses = cours;
    }
}
