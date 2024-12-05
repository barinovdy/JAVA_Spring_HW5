package ru.gb.homework.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework.model.Person;
import ru.gb.homework.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
//@AllArgsConstructor
public class PersonController {

    //@Autowired
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    /**
     *
     * @param
     * 'В json поле id - которое нужно изменить,
     *   остальные поля - на что изменить
     * @return
     */
    @PutMapping()
    public List<Person> updatePerson(@RequestBody Person person){
        personService.updatePerson(person.getId(), person);
        return personService.getAllPersons();
    }

    @DeleteMapping()
    public List<Person> deletePerson(@RequestBody Long id){
        personService.deletePerson(id);
        return personService.getAllPersons();
    }

    @PostMapping()
    public List<Person> createPerson(@RequestBody Person person){
        personService.createPerson(person);
        return personService.getAllPersons();
    }

}
