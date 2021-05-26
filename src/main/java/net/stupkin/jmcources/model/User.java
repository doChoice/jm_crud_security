package net.stupkin.jmcources.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    @NotBlank(message = "First name should not be empty")
    @Pattern(regexp = "[a-zA-Z]+", message = "First name should be written in Latin letters")
    @Size(min = 1, max = 20, message = "First name should be between 1 and 20 characters")
    private String firstName;

    @Column(name = "lastname")
    @NotBlank(message = "Last name should not be empty")
    @Pattern(regexp = "[a-zA-Z]+", message = "Last name should be written in Latin letters")
    @Size(min = 1, max = 25, message = "Last name should be between 1 and 25 characters")
    private String lastName;

    @Column(name = "age")
    @Min(value = 1, message = "Age should be grater than 1")
    private int age;

    @Column(name = "email")
    @NotBlank(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
