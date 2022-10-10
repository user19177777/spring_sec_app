package com.example.spring_sec_app.services;

import com.example.spring_sec_app.models.Person;
import com.example.spring_sec_app.repo.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final PeopleRepo peopleRepo;
    @Autowired
    public RegistrationService(PeopleRepo peopleRepo) {
        this.peopleRepo = peopleRepo;
    }


    public void register(Person person){
        peopleRepo.save(person);
    }
}
