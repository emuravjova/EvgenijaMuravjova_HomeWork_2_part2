package com.playtika.person;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by jane on 10/8/17.
 */
public class Person {

    private static final Logger LOG = LogManager.getLogger(Person.class);
    private String name;
    private double age;
    private String city;

    public Person(String name, double age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(" ");
        sb.append(name).append(" ");
        sb.append(age).append(" years old");
        sb.append(" from ").append(city).append('\'');
        return sb.toString();
    }
    public static double calculateAvgAge(List<Person> people) {
        LOG.debug("Avg age calculating...");
        return people.stream()
                .mapToDouble(Person::getAge)
                .average()
                .orElse(0);
    }

    public static Person oldestPerson(List<Person> people) {
        LOG.debug("Searching for the oldest person...");
        return people.stream()
                .max(comparingDouble(Person::getAge))
                .orElseThrow(() -> new IllegalArgumentException("Unable to find oldest person due to no person found"));
    }

    public static Map<String, Double> averageAdultsAgePerCity(List<Person> people) {
        LOG.debug("Avg adults age per city calculating...");
        return people.stream()
                .filter(p -> p.getAge() >= 18)
                .collect(groupingBy(Person::getCity, averagingDouble(Person::getAge)));
    }

    public static long numberOfPeopleWithNameDave(List<Person> people) {
        LOG.debug("Searching for Dave...");
        return people.stream()
                .filter(p -> p.getName().equals("Dave"))
                .count();
    }

    public static String topCityByPopulation(List<Person> people) {
        LOG.debug("Searching for top city by population...");
        return people.stream()
                .collect(groupingBy(Person::getCity, counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new IllegalArgumentException("Unable to get top city due to no person found"))
                .getKey();
    }

    public static Map<Double, List<Person>> mapAgeToPeopleWithThisAge(List<Person> people) {
        LOG.debug("Mapping people with their age...");
        return people.stream()
                .collect(groupingBy(Person::getAge));

    }
}
