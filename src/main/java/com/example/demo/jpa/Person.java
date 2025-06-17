package com.example.demo.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(PersonId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    private String firstName;

    @Id
    private String lastName;

    private int age;
}