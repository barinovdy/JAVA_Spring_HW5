package ru.gb.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.homework.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
