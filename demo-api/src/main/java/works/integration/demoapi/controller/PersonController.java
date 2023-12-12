package works.integration.demoapi.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import works.integration.demoapi.entity.Person;
import works.integration.demoapi.service.PersonService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {

    PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {

        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody @Valid Person person) {
        return new ResponseEntity<>(personService.savePerson(person), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getPersons() {
        return new ResponseEntity<>(personService.getPersons(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return new ResponseEntity<>(personService.updatePerson(id, person), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
