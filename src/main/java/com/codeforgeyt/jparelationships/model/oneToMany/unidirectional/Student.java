package com.codeforgeyt.jparelationships.model.oneToMany.unidirectional;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String indexNumber;

    public Student() {
    }

    public Student(String indexNumber) {
        this.indexNumber = indexNumber;
    }

}
