package com.playtika.homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.*;

/**
 * Created by jane on 10/8/17.
 */
public class PersonOperations {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

//        people.add(new Person("Ali",42,"Odessa"));
//        people.add(new Person("Dave",15,"Tumba"));
//        people.add(new Person("Kate",18,"Tumba"));
//        people.add(new Person("Sam",71,"Odessa"));
//        people.add(new Person("Frank",8,"Kiev"));

        System.out.println(numberOfPeopleWithNameDave(people));
        System.out.println(averageAdultsAgePerCity(people));
        System.out.println(colculateAvgAge(people));
        System.out.println(mapAgeToPeopleWithThisAge(people));
        System.out.println(topCity(people));
        System.out.println(oldestPerson(people).toString());




    }

    public static double colculateAvgAge(List<Person> persons) {
            return persons.stream()
                    .mapToDouble(Person::getAge)
                    .average()
                    .orElse(0);
    }

    public static Person oldestPerson (List<Person> persons) {
        return persons.stream()
                .max(comparingDouble(Person::getAge))
                .orElse(null);
    }

    public static Map <String, Double> averageAdultsAgePerCity(List<Person> persons){
        return persons.stream()
                .filter(p -> p.getAge() >= 18)
                .collect(groupingBy(Person::getCity, averagingDouble(Person::getAge)));
    }

    private static long numberOfPeopleWithNameDave (List<Person> persons) {
        return persons.stream()
                .filter(p -> p.getName().equals("Dave"))
                .count();
    }

    public static String topCity (List<Person> persons){
        return persons.stream()
                .collect(groupingBy(Person::getCity, counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

    public static Map<Double, Long> mapAgeToPeopleWithThisAge(List<Person> persons) {
        return persons.stream()
                .collect(groupingBy(Person::getAge, counting()));
    }
}
