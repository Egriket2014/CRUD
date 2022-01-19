package mvcapp.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;

    @NotEmpty(message = "Should not be empty")
    @Size(min = 2, max = 30, message = "Should be between 2 and 30 characters")
    private String name;

    @Min(value = 0, message = "Should be > 0")
    private int age;

    @NotEmpty(message = "Should not be empty")
    @Email(message = "Should be valid")
    private String email;

    @NotEmpty(message = "Should not be empty")
    private String profession;

    public Person() {}

    public Person(int id, String name, int age, String email, String profession) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.profession = profession;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
