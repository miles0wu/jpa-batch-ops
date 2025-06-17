package com.example.demo.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(PersonId.class)
@Data                   // 產生 getter, setter, toString, equals, hashCode
@NoArgsConstructor      // 無參構造器
@AllArgsConstructor     // 全參構造器
public class Person {

    @Id
    private String firstName;

    @Id
    private String lastName;

    private int age;
}