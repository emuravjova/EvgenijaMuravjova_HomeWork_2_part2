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
        Map<String,Integer> expectedFrequencies = new HashMap<String, Integer>();
        expectedFrequencies.put("hello",2);
        expectedFrequencies.put("world",1);
        assertEquals(expectedFrequencies,wordFrequencies);
    }

    @Test
    public void getFrequenciesForWordsInUppercaseLowercase() {
        Map<String,Integer> wordFrequencies = new Text("HELLO hello HeLlO")
                .getWordFrequencies();
        Map<String,Integer> expectedFrequencies = new HashMap<String, Integer>();
        expectedFrequencies.put("hello",3);
        assertEquals(expectedFrequencies,wordFrequencies);
    }

    @Test
    public void getFrequenciesForWordsInTextWithPunctuation() {
        Map<String,Integer> wordFrequencies = new Text("aa - aa\" @ aa. aa, aa ?aa !)\n aa ( + aa: \t")
                .getWordFrequencies();
        Map<String,Integer> expectedFrequencies = new HashMap<String, Integer>();
        expectedFrequencies.put("aa",8);
        assertEquals(expectedFrequencies,wordFrequencies);
    }

    @Test
    public void getFrequenciesReturnsNoFrequenciesForEmptyText() {
        Map<String,Integer> wordFrequencies = new Text("")
                .getWordFrequencies();
        Map<String,Integer> expectedWords = new HashMap<String, Integer>();
        assertEquals(expectedWords,wordFrequencies);
    }

    @Test
    public void getFrequenciesReturnsNoFrequenciesForTextWithWhitespacesOnly() {
        Map<String,Integer> wordFrequencies = new Text("  \n\t\n")
                .getWordFrequencies();
        Map<String,Integer> expectedWords = new HashMap<String, Integer>();
        assertEquals(expectedWords,wordFrequencies);
    }

    @Test
    public void getFrequenciesReturnsNoFrequenciesForTextWithoutWords() {
        Map<String,Integer> wordFrequencies = new Text("_+-.,!@#$%^&*();\\/|<>\"'")
                .getWordFrequencies();
        Map<String,Integer> expectedWords = new HashMap<String, Integer>();
        assertEquals(expectedWords,wordFrequencies);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFrequenciesCouldNotBeProcessedForNullText() {
        new Text(null).getWordFrequencies();
    }

}