package no.iterate.java8fp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.junit.Assert.assertThat;

public class Exercise_3_Parallelism_Test {

    Person luke = new Person("Luke", "Skywalker", 19);
    Person leia = new Person("Leia", "Organa", 19);
    Person anakin = new Person("Anakin", "Skywalker", 42);
    Person bail = new Person("Bail", "Organa", 55);
    Person han = new Person("Han", "Solo", 29);

    @Test
    public void first_names_of_teens_in_parallel() {
        List<Person> people = asList(luke, leia, anakin, bail, han);

        long startTime = System.currentTimeMillis();

        // TODO: Rewrite the conversion to run in parallel, still using the
        // longRunningAgeCheck method to filter the teens
        List<String> names = new ArrayList<>();
        for (Person person : people) {
            if (longRunningAgeCheck(person)) {
                names.add(person.getFirstName());
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println(duration);

        assertThat(names, hasItems("Luke", "Leia"));
        assertThat(duration, lessThan(300L));
    }

    private boolean longRunningAgeCheck(Person person) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 13 <= person.getAge() && person.getAge() <= 19;
    }

}
