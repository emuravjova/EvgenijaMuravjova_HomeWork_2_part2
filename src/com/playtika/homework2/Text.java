package com.playtika.homework2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Math.min;
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
        return Arrays.asList(text.toLowerCase().split("[^A-Za-z0-9]+")).stream()
                .filter(s -> !s.isEmpty())
                .collect(toList());
    }

    public int getLengthInChars() {
        return splitByWords().stream()
                .mapToInt(String::length)
                .sum();
    }

    public Map<String, Integer> getWordFrequencies() {
        return  splitByWords().stream()
                .collect(groupingBy(w -> w, summingInt(w -> 1)));
    }

    public List<String> getTopWords(int n) {
        if (n <= 0){throw new IllegalArgumentException("Parameter should be grater then zero");}
        return splitByWords().stream()
                .distinct()
                .sorted()
                .limit(min(n,splitByWords().size()))
                .collect(Collectors.toList());
    }

}
