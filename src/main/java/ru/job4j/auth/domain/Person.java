package ru.job4j.auth.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;
}
