package com.example.nobsv2.mappings;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;


    @Column(name="street")
    private String street;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;
}
