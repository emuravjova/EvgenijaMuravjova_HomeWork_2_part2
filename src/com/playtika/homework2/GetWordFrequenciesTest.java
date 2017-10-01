package com.playtika.homework2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by jane on 10/1/17.
 */
public class GetWordFrequenciesTest {

    @Test
    public void shouldGetWordFrequencies() {
        Map<String,Integer> wordFrequencies = new Text("hello world hello")
                .getWordFrequencies();
        Map<String,Integer> expactedFrequencies = new HashMap<String, Integer>();
        expactedFrequencies.put("hello",2);
        expactedFrequencies.put("world",1);
        assertEquals(wordFrequencies,expactedFrequencies);
    }

    @Test
    public void getFrequenciesForWordsInUppercaseLowercase() {
        Map<String,Integer> wordFrequencies = new Text("HELLO hello HeLlO")
                .getWordFrequencies();
        Map<String,Integer> expactedFrequencies = new HashMap<String, Integer>();
        expactedFrequencies.put("hello",3);
        assertEquals(wordFrequencies,expactedFrequencies);
    }

    @Test
    public void getFrequenciesForWordsInTextWithPunctuation() {
        Map<String,Integer> wordFrequencies = new Text("aa - aa\" @ aa. aa, aa ?aa !)\n aa ( + aa: \t")
                .getWordFrequencies();
        Map<String,Integer> expactedFrequencies = new HashMap<String, Integer>();
        expactedFrequencies.put("aa",8);
        assertEquals(wordFrequencies,expactedFrequencies);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFrequenciesCouldNotBeProcessedForEmptyText() {
        new Text("").getWordFrequencies();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFrequenciesCouldNotBeProcessedForTextWithWhitespacesOnly() {
        new Text("  \n\t\n").getWordFrequencies();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFrequenciesCouldNotBeProcessedForNullText() {
        new Text(null).getWordFrequencies();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFrequenciesCouldNotBeProcessedForTextWithoutWords() {
        new Text("_+-.,!@#$%^&*();\\/|<>\"'").getWordFrequencies();
    }

}