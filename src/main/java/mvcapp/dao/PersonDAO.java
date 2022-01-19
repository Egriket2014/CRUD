package mvcapp.dao;

import mvcapp.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_ID;

    private static final String URL = "jdbc:postgresql://localhost:5432/people_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection;

    static {
        try {
            // С помощью рефлексии загружаем в операивку драйвер для работы с БД
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> index() {
        List<Person> people = new ArrayList<>();

        try {
            // Объект-запрос к БД
            Statement statement = connection.createStatement();
            // executeQuery получает данные, не изменяет
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Person");

            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id")); // Получаем из текущей строки поле id
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                person.setProfession(resultSet.getString("profession"));

                people.add(person);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return people;
    }

    public Person show(int id) {
        //return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
        return null;
    }

    public void save(Person person) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES(" + 1 + ",'" + person.getName() +
                    "'," + person.getAge() + ",'" + person.getEmail() + "')";
            // executeUpdate изменяет данные, не получает
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Person person) {
//        Person updatePerson = show(id);
//        updatePerson.setName(person.getName());
//        updatePerson.setAge(person.getAge());
//        updatePerson.setEmail(person.getEmail());
//        updatePerson.setProfession(person.getProfession());
    }

    public void delete(int id) {
        //people.removeIf(p -> p.getId() == id);
    }
}
