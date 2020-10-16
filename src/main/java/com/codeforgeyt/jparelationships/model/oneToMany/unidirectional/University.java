package com.codeforgeyt.jparelationships.model.oneToMany.unidirectional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "University")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
//            (
//            mappedBy = "university",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    Without join it creates 3th table like in many to many
//    @JoinColumn can't be used together with the mappedBy
//    When there is no mappedBy CascadeType.ALL is causing error about detached entity
    @JoinColumn(name = "university_id")
    private List<Student> students = new ArrayList<>();

    public University() {
    }

    public University(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
