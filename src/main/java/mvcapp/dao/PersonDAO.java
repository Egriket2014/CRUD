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
        people.add(new Person(++PEOPLE_ID, "Elon", 31, "elon@musk.com", "88005553535"));
        people.add(new Person(++PEOPLE_ID, "Tony", 35, "tony@stark.com", "8234567890"));
        people.add(new Person(++PEOPLE_ID, "Steve", 29, "steave@gmail.com", "88104567521"));
        people.add(new Person(++PEOPLE_ID, "Natasha", 23, "natali@yande.ru", "89158902121"));
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
        updatePerson.setAge(person.getAge());
        updatePerson.setEmail(person.getEmail());
        updatePerson.setPhoneNumber(person.getPhoneNumber());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
