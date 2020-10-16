package com.codeforgeyt.jparelationships.model.oneToOne.unidirectional;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street;

    public Address(String street) {
        this.street = street;
    }
}
