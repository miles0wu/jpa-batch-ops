package com.example.demo.repo;

import com.example.demo.jpa.Person;
import com.example.demo.jpa.PersonId;

import java.util.List;

public interface PersonRepositoryCustom {
    void batchInsert(List<Person> people);
    List<Person> findByIdsBatch(List<PersonId> ids);
}
