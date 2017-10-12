package com.playtika.homework2;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertThat;

/**
 * Created by jane on 10/1/17.
 */
public class GetWordFrequenciesTest {

    @Test
    public void shouldGetWordFrequencies() {
        Map<String,Integer> wordFrequencies = new Text("hello world hello")
                .getWordFrequencies();
        Map<String,Integer> expectedFrequencies = new HashMap<>();
        expectedFrequencies.put("hello",2);
        expectedFrequencies.put("world",1);
        assertThat(expectedFrequencies, is(equalTo(wordFrequencies)));
    }

    @Test
    public void getWordsFrequenciesInUppercaseLowercase() {
        Map<String,Integer> wordFrequencies = new Text("HELLO hello HeLlO")
                .getWordFrequencies();
        Map<String, Integer> expectedFrequencies = Collections.singletonMap("hello",3);
        assertThat(expectedFrequencies, is(equalTo(wordFrequencies)));
    }

    @Test
    public void getWordsFrequenciesInTextWithPunctuation() {
        Map<String,Integer> wordFrequencies = new Text("aa - aa\" @ aa. aa, aa ?aa !)\n aa ( + aa: \t")
                .getWordFrequencies();
        assertThat(wordFrequencies, hasEntry("aa",8));
        assertThat(wordFrequencies.size(), is(1));
    }

    @Test
    public void getFrequenciesReturnsNoFrequenciesForEmptyText() {
        Map<String,Integer> wordFrequencies = new Text("")
                .getWordFrequencies();
        assertThat(wordFrequencies.size(),is(0));
    }

    @Test
    public void getFrequenciesReturnsNoFrequenciesForTextWithWhitespacesOnly() {
        Map<String,Integer> wordFrequencies = new Text("  \n\t\n")
                .getWordFrequencies();
        assertThat(wordFrequencies.size(),is(0));
    }

    @Test
    public void getFrequenciesReturnsNoFrequenciesForTextWithoutWords() {
        Map<String,Integer> wordFrequencies = new Text("_+-.,!@#$%^&*();\\/|<>\"'")
                .getWordFrequencies();
        assertThat(wordFrequencies.size(),is(0));
    }

    @Test
    public void getFrequenciesForTextThatStartsWithNotWord() {
        Map<String,Integer> wordFrequencies = new Text("@aaa")
                .getWordFrequencies();
        Map<String, Integer> expectedFrequencies = Collections.singletonMap("aaa",1);
        assertThat(expectedFrequencies, is(equalTo(wordFrequencies)));
    }
}