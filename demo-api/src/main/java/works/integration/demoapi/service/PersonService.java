package works.integration.demoapi.service;

import java.util.Set;

import works.integration.demoapi.entity.Person;

public interface PersonService {

    public Person getPerson(Long id);

    public Person savePerson(Person person);

    public Set<Person> getPersons();

}
