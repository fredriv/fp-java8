package no.iterate.java8fp;

import java.util.Objects;
import java.util.Optional;

public class Person {

    private final String firstName;

    private final String lastName;

    private final Optional<String> sithName;

    private final int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sithName = Optional.empty();
        this.age = age;
    }

    public Person(String firstName, String lastName, String sithName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sithName = Optional.of(sithName);
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Optional<String> getSithName() {
        return sithName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + age + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person other = (Person) o;
        return Objects.equals(firstName, other.firstName)
                && Objects.equals(lastName, other.lastName)
                && age == other.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }
}
