package com.exercise.stream.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    @With
    private Double price;

    @ManyToMany(mappedBy = "products")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Order> orders;

}