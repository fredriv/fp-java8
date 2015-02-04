package no.iterate.java8fp;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import static no.iterate.java8fp.Helpers.undefined;

/**
 * JavaDoc for the Stream API is available at
 *
 * http://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
 */
public class Exercise_2_Streams_Test {

    /*
     * ==============
     *     FILTER
     * ==============
     */

    @Test
    public void numbers_below_100() {
        List<Integer> numbers = asList(17, 314, 123, 42, 100);

        // TODO: Filter the list of numbers, returning the numbers less than 100
        List<Integer> below_100 = undefined();

        assertThat(below_100, hasItems(17, 42));
        assertThat(below_100, not(hasItems(314, 123, 100)));
    }

    Person luke = new Person("Luke", "Skywalker", 19);
    Person leia = new Person("Leia", "Organa", 19);
    Person anakin = new Person("Anakin", "Skywalker", 42);
    Person bail = new Person("Bail", "Organa", 54);
    Person han = new Person("Han", "Solo", 29);

    @Test
    public void find_teens() {
        List<Person> people = asList(luke, leia, anakin, bail, han);

        // TODO: Filter the list of people, returning the people who are teens
        List<Person> teens = undefined();

        assertThat(teens, hasItems(luke, leia));
        assertThat(teens, not(hasItems(anakin, bail, han)));
    }

    @Test
    public void people_with_lastnames_starting_with_S() {
        List<Person> people = asList(luke, leia, anakin, bail, han);

        // TODO: Filter the list of people, returning the people whose last
        // name starts with the letter S
        List<Person> people_S = undefined();

        assertThat(people_S, hasItems(luke, anakin, han));
        assertThat(people_S, not(hasItems(leia, bail)));
    }

    /*
     * =======================
     *     TRANSFORM (MAP)
     * =======================
     */

    @Test
    public void first_names() {
        List<Person> people = asList(luke, leia, anakin, bail, han);

        // TODO: Find the first names of the people in the list
        List<String> first_names = undefined();

        assertThat(first_names, hasItems("Luke", "Leia", "Anakin", "Bail", "Han"));
    }

    @Test
    public void first_names_of_teens() {
        List<Person> people = asList(luke, leia, anakin, bail, han);

        // TODO: Find the first names of the teens in the list
        List<String> first_names_of_teens = undefined();

        assertThat(first_names_of_teens, hasItems("Luke", "Leia"));
        assertThat(first_names_of_teens, not(hasItems("Anakin", "Bail", "Han")));
    }

    /*
     * =================
     *     AGGREGATE
     * =================
     */

    @Test
    public void max_age() {
        List<Person> people = asList(luke, leia, anakin, bail, han);

        // TODO: Find the max age of the people in the list
        // HINT: Check out the Stream::mapToInt method and IntStream subclass
        int max_age = undefined();

        assertThat(max_age, is(54));
    }

    @Test
    public void average_age() {
        List<Person> people = asList(luke, leia, anakin, bail, han);

        // TODO: Find the average age of the people in the list
        double average_age = undefined();

        assertThat(average_age, is((19 + 19 + 42 + 29 + 54) / 5.0));
    }

    @Test
    public void number_of_teens() {
        List<Person> people = asList(luke, leia, anakin, bail, han);

        // TODO: Find the number of teens in the list of people
        long number_of_teens = undefined();

        assertThat(number_of_teens, is(2L));
    }

}
