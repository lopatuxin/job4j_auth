package ru.job4j.auth.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.auth.domain.Person;
import ru.job4j.auth.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {
    private final PersonService persons;

    @GetMapping("/")
    public List<Person> findAll() {
        return persons.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable int id) {
        return persons.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Person is not found"
        ));
    }

    @PostMapping("/")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        if (person == null) {
            throw new NullPointerException("Person is empty");
        }
        return new ResponseEntity<Person>(
                persons.save(person),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Person person) {
        if (person == null) {
            throw new NullPointerException("Person is empty");
        }
        if (persons.update(person)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Объект не обновлен");
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Person person = new Person();
        person.setId(id);
        if (!persons.delete(person)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Объект не удален");
        }
        return ResponseEntity.ok().build();
    }
}
