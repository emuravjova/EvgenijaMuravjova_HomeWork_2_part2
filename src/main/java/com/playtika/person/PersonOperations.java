package com.playtika.person;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jane on 10/8/17.
 */
public class PersonOperations {
    private static final Logger LOG = LogManager.getLogger(PersonOperations.class);
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        people.add(new Person("Ali",42,"Odessa"));
        people.add(new Person("Dave",15,"New York"));
        people.add(new Person("Kate",18,"New York"));
        people.add(new Person("Sam",8,"Odessa"));
        people.add(new Person("Frank",8,"Kiev"));

        LOG.info("Following people are present:");
        for (Person person : people) {
            LOG.info(person.toString());
        }

        LOG.info("Avg age of people is: {}", Person.calculateAvgAge(people));
        LOG.info("The oldest person is {}", Person.oldestPerson(people).toString());
        LOG.info("Avg adults age per city is {}", Person.averageAdultsAgePerCity(people));
        LOG.info("Number of people with name Dave is {}", Person.numberOfPeopleWithNameDave(people));
        LOG.info("Top city by population is {}", Person.topCityByPopulation(people));
        LOG.info("Map of age to number of people with this age: {}", Person.mapAgeToPeopleWithThisAge(people));
//
//        System.out.println(Person.averageAdultsAgePerCity(people));
//        System.out.println(Person.numberOfPeopleWithNameDave(people));
//        System.out.println(Person.topCityByPopulation(people));
//        System.out.println(Person.mapAgeToPeopleWithThisAge(people));

    }

}
