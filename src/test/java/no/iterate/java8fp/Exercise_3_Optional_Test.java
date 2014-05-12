package no.iterate.java8fp;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static no.iterate.java8fp.Helpers.toStream;
import static no.iterate.java8fp.Helpers.undefined;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * JavaDoc for the Stream API is available at
 *
 * http://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
 */
public class Exercise_3_Optional_Test {

    Person luke = new Person("Luke", "Skywalker", 19);
    Person leia = new Person("Leia", "Organa", 19);
    Person anakin = new Person("Anakin", "Skywalker", "Darth Vader", 42);
    Person bail = new Person("Bail", "Organa", 54);
    Person han = new Person("Han", "Solo", 29);

    /*
     * ===========
     *     MAP
     * ===========
     */

    @Test
    public void length_of_sith_name() throws Exception {
        // TODO: Find length of sith name of person
        Function<Person, Optional<Integer>> length_of_sith_name =
                person -> person.getSithName().map(String::length);

        assertThat(length_of_sith_name.apply(luke), is(Optional.empty()));
        assertThat(length_of_sith_name.apply(anakin), is(Optional.of(11)));
    }

    @Test
    public void is_not_darth_vader() throws Exception {
        // TODO: Check if person is the sith lord Darth Vader
        // Hint: use Optional.orElse
        Function<Person, Boolean> isDarthVader =
                person -> person.getSithName().map("Darth Vader"::equals).orElse(false);

        assertThat(isDarthVader.apply(luke), is(false));
        assertThat(isDarthVader.apply(anakin), is(true));
    }

/*
     * ==========================
     *     STREAMS + OPTIONAL
     * ==========================
     */

    @Test
    public void sith_names() throws Exception {
        List<Person> people = asList(luke, leia, anakin, bail, han);

        // TODO: Find the sith names of the people in the list
        // Hint: Use either filter + map or flatMap + toStream (see imports)
        List<String> sith_names = people.stream()
                .map(Person::getSithName)
                .flatMap(Helpers::toStream)
                .collect(Collectors.toList());

        assertThat(sith_names, contains("Darth Vader"));
    }

    @Test
    public void name_of_oldest_person() {
        List<Person> people = asList(luke, leia, anakin, bail, han);

        // TODO: Find the full name of the oldest person in the list
        String full_name = people.stream()
                .max(Comparator.comparing(Person::getAge))
                .map(p -> p.getFirstName() + " " + p.getLastName())
                .get();

        assertThat(full_name, is("Bail Organa"));
    }


}
