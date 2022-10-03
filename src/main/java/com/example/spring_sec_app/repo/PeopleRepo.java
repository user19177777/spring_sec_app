package com.example.spring_sec_app.repo;

import com.example.spring_sec_app.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepo extends JpaRepository<Person,Integer> {
    Optional<Person> findByName(String name);
}
