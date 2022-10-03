package com.example.spring_sec_app.services;

import com.example.spring_sec_app.models.Person;
import com.example.spring_sec_app.repo.PeopleRepo;
import com.example.spring_sec_app.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepo peopleRepo;
    @Autowired
    public PersonDetailsService(PeopleRepo peopleRepo) {
        this.peopleRepo = peopleRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepo.findByName(username);

        if (person.isEmpty())
            throw new UsernameNotFoundException("User name not found!");
        return new PersonDetails(person.get());
    }
}
