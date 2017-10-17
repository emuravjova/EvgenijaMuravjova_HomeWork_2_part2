package com.playtika.homework4;

import java.util.*;

import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.*;

/**
 * Created by jane on 10/8/17.
 */
public class PersonOperations {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        people.add(new Person("Ali",42,"Odessa"));
        people.add(new Person("Dave",15,"New York"));
        people.add(new Person("Kate",18,"New York"));
        people.add(new Person("Sam",8,"Odessa"));
        people.add(new Person("Frank",8,"Kiev"));

        System.out.println(calculateAvgAge(people));
        System.out.println(oldestPerson(people).toString());
        System.out.println(averageAdultsAgePerCity(people));
        System.out.println(numberOfPeopleWithNameDave(people));
        System.out.println(topCityByPopulation(people));
        System.out.println(mapAgeToPeopleWithThisAge(people));

    }

    public static double calculateAvgAge(List<Person> people) {
        return people.stream()
                .mapToDouble(Person::getAge)
                .average()
                .orElse(0);
    }

    public static Person oldestPerson(List<Person> people) {
        return people.stream()
                .max(comparingDouble(Person::getAge))
                .orElseThrow(() -> new IllegalArgumentException("Unable to find oldest person due to no person found"));
    }

    public static Map<String, Double> averageAdultsAgePerCity(List<Person> people) {
        return people.stream()
                .filter(p -> p.getAge() >= 18)
                .collect(groupingBy(Person::getCity, averagingDouble(Person::getAge)));
    }

    private static long numberOfPeopleWithNameDave(List<Person> people) {
        return people.stream()
                .filter(p -> p.getName().equals("Dave"))
                .count();
    }

    public static String topCityByPopulation(List<Person> people) {
            return people.stream()
                    .collect(groupingBy(Person::getCity, counting()))
                    .entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .orElseThrow(() -> new IllegalArgumentException("Unable to get top city due to no person found"))
                    .getKey();
        }

    public static Map<Double, List<Person>> mapAgeToPeopleWithThisAge(List<Person> people) {
            return people.stream()
                    .collect(groupingBy(Person::getAge));

    }
}
