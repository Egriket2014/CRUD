package mvcapp.dao;

import mvcapp.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_ID;
    private List<Person> people;

    public PersonDAO() {
        this.people = new ArrayList<>();
        people.add(new Person(++PEOPLE_ID, "Elon"));
        people.add(new Person(++PEOPLE_ID, "Tony"));
        people.add(new Person(++PEOPLE_ID, "Steve"));
        people.add(new Person(++PEOPLE_ID, "Natasha"));
    }

    public List<Person> index() {
        return  people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_ID);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person updatePerson = show(id);
        updatePerson.setName(person.getName());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
