package com.codeforgeyt.jparelationships.model.oneToOne.bidirectional;

import javax.persistence.*;

@Entity
@Table(name = "Car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model;
    @OneToOne(mappedBy = "car")
    private Owner owner;

    public Car() {
    }

    public Car(String model) {
        this.model = model;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public Owner getOwner() {
        return owner;
    }
}
