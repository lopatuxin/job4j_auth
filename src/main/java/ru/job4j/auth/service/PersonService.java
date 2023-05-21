package ru.job4j.auth.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.auth.domain.Person;
import ru.job4j.auth.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Optional<Person> findById(int id) {
        return repository.findById(id);
    }

    public Person save(Person person) {
        return repository.save(person);
    }

    public boolean delete(Person person) {
        boolean result = false;
        if (findById(person.getId()).isPresent()) {
            repository.delete(person);
            result = true;
        }
        return result;
    }

    public boolean update(Person person) {
        boolean result = false;
        if (findById(person.getId()).isPresent()) {
            repository.save(person);
            result = true;
        }
        return result;
    }
}
