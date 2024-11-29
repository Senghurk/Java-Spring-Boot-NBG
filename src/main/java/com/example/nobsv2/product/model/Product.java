package com.example.nobsv2.product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity //maps java class to mysql
@Data
@Table(name="product")
public class Product {


    @Id // all tables in mySQL need a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto generates id
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "Name is required")
    @Column(name = "name")
    private String name;

    @Size(min = 20, message = "Description must be 20 character long")
    @Column(name = "description")
    private String description;

    @PositiveOrZero(message = "Price must not be negative")
    @Column(name = "price")
    private Double price;

}
