package works.integration.demoapi.service;

import java.util.List;

import works.integration.demoapi.entity.Person;

public interface PersonService {

    public Person getPerson(Long id);

    public Person savePerson(Person person);

    public List<Person> getPersons();

    public Person updatePerson(Long id, Person person);

    public void deletePerson(Long id);

}
