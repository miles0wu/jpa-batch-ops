package com.example.demo;

import com.example.demo.jpa.Person;
import com.example.demo.jpa.PersonId;
import com.example.demo.repo.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void testSaveAllPersons() {
        // Arrange
        List<Person> people = List.of(
                new Person("John", "Doe", 30),
                new Person("Jane", "Smith", 25),
                new Person("Alice", "Brown", 40)
        );

        // Act
        personRepository.batchInsert(people);

        List<PersonId> ids = people.stream()
                .map(p -> new PersonId(p.getFirstName(), p.getLastName()))
                .toList();

        List<Person> found = personRepository.findByIdsBatch(ids);
        // Assert
        assertThat(found).hasSize(3);
    }
}
