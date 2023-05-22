package ru.job4j.auth.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.auth.domain.Person;
import ru.job4j.auth.repository.UserStore;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserStore userStore;

    public void save(Person person) {
        userStore.save(person);
    }

    public Person findByUsername(String username) {
        return userStore.findByUsername(username);
    }

    public List<Person> findAll() {
        return userStore.findAll();
    }
}
