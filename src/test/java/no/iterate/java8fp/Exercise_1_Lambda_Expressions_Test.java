package no.iterate.java8fp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import static no.iterate.java8fp.Helpers.undefined;

/**
 * JavaDoc for Java 8 is available at
 *
 * http://docs.oracle.com/javase/8/docs/api/
 */
public class Exercise_1_Lambda_Expressions_Test {

    Person luke = new Person("Luke", "Skywalker", 19);
    Person leia = new Person("Leia", "Organa", 19);
    Person anakin = new Person("Anakin", "Skywalker", 42);
    Person bail = new Person("Bail", "Organa", 55);
    Person han = new Person("Han", "Solo", 29);

    public interface CheckPerson {
        boolean test(Person person);
    }

    @Test
    public void find_skywalkers() {
        List<Person> people = asList(luke, leia, anakin, bail, han);

        // TODO: Implement CheckPerson lambda which returns true for people named Skywalker
        CheckPerson isSkywalker = undefined();
        List<Person> skywalkers = findPeople(people, isSkywalker);

        assertThat(skywalkers, hasItems(luke, anakin));
        assertThat(skywalkers, not(hasItems(leia, bail, han)));
    }

    @Test
    public void find_teens() {
        List<Person> people = asList(luke, leia, anakin, bail, han);

        // TODO: Implement CheckPerson lambda which returns true for teens
        CheckPerson isTeen = undefined();
        List<Person> skywalkers = findPeople(people, isTeen);

        assertThat(skywalkers, hasItems(luke, leia));
        assertThat(skywalkers, not(hasItems(anakin, bail, han)));
    }

    public interface Extractor<F, T> {
        T extractFrom(F f);
    }

    @Test
    public void first_names() {
        List<Person> people = asList(luke, leia, anakin, bail, han);

        // TODO: Implement Extractor which returns first name of people
        Extractor<Person, String> first_name = undefined();
        List<String> first_names = extract(people, first_name);

        assertThat(first_names, hasItems("Luke", "Leia", "Anakin", "Bail", "Han"));
    }

    @Test
    public void sort_people_by_last_name_then_first_name() {
        List<Person> people = asList(luke, leia, anakin, bail, han);

        // TODO: Sort the list first by peoples last name, then by first name
        // HINT: Check out the new methods on java.util.Comparator
        people.sort(undefined());

        assertThat(people.get(0).getFirstName(), is("Bail"));
    }

    private final List<Person> findPeople(List<Person> people, CheckPerson tester) {
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (tester.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

    private <F, T> List<T> extract(List<F> list, Extractor<F, T> extractor) {
        List<T> result = new ArrayList<>();
        for (F f : list) {
            result.add(extractor.extractFrom(f));
        }
        return result;
    }
}
