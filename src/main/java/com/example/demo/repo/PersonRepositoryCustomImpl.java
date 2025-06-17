package com.example.demo.repo;

import com.example.demo.jpa.Person;
import com.example.demo.jpa.PersonId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void batchInsert(List<Person> people) {
        if (people == null || people.isEmpty()) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO person (first_name, last_name, age) VALUES ");

        for (int i = 0; i < people.size(); i++) {
            sb.append("(?, ?, ?)");
            if (i != people.size() - 1) {
                sb.append(", ");
            }
        }

        Query query = em.createNativeQuery(sb.toString());

        int idx = 1;
        for (Person p : people) {
            query.setParameter(idx++, p.getFirstName());
            query.setParameter(idx++, p.getLastName());
            query.setParameter(idx++, p.getAge());
        }

        query.executeUpdate();
    }

    @Override
    public List<Person> findByIdsBatch(List<PersonId> ids) {
        if (ids == null || ids.isEmpty()) {
            return List.of();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM person WHERE ");

        for (int i = 0; i < ids.size(); i++) {
            sb.append("(first_name = :firstName").append(i)
                    .append(" AND last_name = :lastName").append(i).append(")");
            if (i != ids.size() - 1) {
                sb.append(" OR ");
            }
        }

        Query query = em.createNativeQuery(sb.toString(), Person.class);

        for (int i = 0; i < ids.size(); i++) {
            query.setParameter("firstName" + i, ids.get(i).getFirstName());
            query.setParameter("lastName" + i, ids.get(i).getLastName());
        }

        return query.getResultList();
    }
}
