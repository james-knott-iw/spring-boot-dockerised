package works.integration.demoapi.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import works.integration.demoapi.entity.Person;
import works.integration.demoapi.repository.PersonRepository;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository;

    @Override
    public Person getPerson(Long id) {
        return personRepository.findById(id).get();
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Set<Person> getPersons() {

        return (Set<Person>) personRepository.findAll();
    }

}
