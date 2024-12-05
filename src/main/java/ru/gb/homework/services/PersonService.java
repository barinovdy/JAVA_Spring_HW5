package ru.gb.homework.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.homework.model.Person;
import ru.gb.homework.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
//@AllArgsConstructor
public class PersonService {

    //@Autowired
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    public Person getById(Long id){
        return personRepository.findById(id).get();
    }

    public Person createPerson(Person person){
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person personUpdate){
        Optional<Person> personOpt = personRepository.findById(id);
        if (personOpt.isPresent()){
            Person person = personOpt.get();
            person.setName(personUpdate.getName());
            person.setAge(personUpdate.getAge());
            person.setEmail(personUpdate.getEmail());
            return personRepository.save(person);
        } else {
            throw new IllegalArgumentException("Person not found");
        }
    }

    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }
}
