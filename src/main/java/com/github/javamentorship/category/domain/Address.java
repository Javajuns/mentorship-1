package com.github.javamentorship.category.domain;

import javax.persistence.*;

@Entity
public class Address {
    @Id @GeneratedValue
    int id;
    @Column(nullable = false)
    String country;
    @Column(nullable = false)
    String city;
    @Column(nullable = false)
    String street;
    @Column(nullable = false)
    String building;
    @OneToOne(mappedBy = "address") //TODO owner_id
    User owner;
    // select u.* from address a where a.city = "Kyiv" join users u on a.owner_id = u.id
}
