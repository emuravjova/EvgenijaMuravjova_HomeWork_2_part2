package com.playtika.text;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Created by jane on 9/30/17.
 */
public class Text {
    private final String text;

    public Text(String text) {
        if (text == null ) {
            throw new IllegalArgumentException("Text should not be null");
        }
        this.text = text;
    }

    private List<String> splitByWords() {
        return Stream.of(text.toLowerCase().split("[^A-Za-z0-9]+"))
                .filter(s -> !s.isEmpty())
                .collect(toList());
    }

    public int getLengthInChars() {
        return splitByWords().stream()
                .mapToInt(String::length)
                .sum();
    }

    public Map<String, Long> getWordFrequencies() {
        return  splitByWords().stream()
                .collect(groupingBy(w -> w, counting()));
    }

    public List<String> getTopWords(int n) {
        if (n <= 0){throw new IllegalArgumentException("Parameter should be grater then zero");}
        return splitByWords().stream()
                .distinct()
                .sorted()
                .limit(n)
                .collect(Collectors.toList());
    }

}
