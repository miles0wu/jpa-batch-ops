package com.example.demo.repo;

import com.example.demo.jpa.Person;
import com.example.demo.jpa.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, PersonId>, PersonRepositoryCustom {
}
