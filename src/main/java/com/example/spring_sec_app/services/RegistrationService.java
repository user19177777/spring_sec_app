package com.example.spring_sec_app.services;

import com.example.spring_sec_app.models.Person;
import com.example.spring_sec_app.repo.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final PeopleRepo peopleRepo;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public RegistrationService(PeopleRepo peopleRepo, PasswordEncoder passwordEncoder) {
        this.peopleRepo = peopleRepo;
        this.passwordEncoder = passwordEncoder;
    }


    public void register(Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        peopleRepo.save(person);
    }
}
