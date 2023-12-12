package works.integration.demoapi.service;

import java.util.List;
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
    public List<Person> getPersons() {

        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person updatePerson(Long id, Person person) {
        Person originalPerson = personRepository.findById(id).get();

        originalPerson.setAddress(person.getAddress());
        originalPerson.setName(person.getName());
        return personRepository.save(originalPerson);

    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

}
