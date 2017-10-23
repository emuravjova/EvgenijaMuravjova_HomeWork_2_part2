package com.playtika.text;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertThat;

public class TestngWordFrequenciesTest {

    @Test(groups = {"getWordsFrequencies"})
    public void shouldGetWordFrequencies() {
        Map<String,Long> wordFrequencies = new Text("hello world hello")
                .getWordFrequencies();
        Map<String,Long> expectedFrequencies = new HashMap<>();
        expectedFrequencies.put("hello",2L);
        expectedFrequencies.put("world",1L);
        assertThat(expectedFrequencies, is(equalTo(wordFrequencies)));
    }

    @Test(groups = {"getWordsFrequencies"}, dependsOnMethods = {"shouldGetWordFrequencies"}, priority = 1)
    public void getWordsFrequenciesInUppercaseLowercase() {
        Map<String,Long> wordFrequencies = new Text("HELLO hello HeLlO")
                .getWordFrequencies();
        Map<String, Long> expectedFrequencies = Collections.singletonMap("hello",3L);
        assertThat(expectedFrequencies, is(equalTo(wordFrequencies)));
    }

    @Test(groups = {"getWordsFrequencies"}, dependsOnMethods = {"shouldGetWordFrequencies"}, priority = 1)
    public void getWordsFrequenciesInTextWithPunctuation() {
        Map<String,Long> wordFrequencies = new Text("aa - aa\" @ aa. aa, aa ?aa !)\n aa ( + aa: \t")
                .getWordFrequencies();
        assertThat(wordFrequencies, hasEntry("aa",8L));
        assertThat(wordFrequencies.size(), is(1));
    }

    @Test(groups = {"getWordsFrequencies"}, dependsOnMethods = {"shouldGetWordFrequencies"}, priority = 2)
    public void getFrequenciesReturnsNoFrequenciesForEmptyText() {
        Map<String,Long> wordFrequencies = new Text("")
                .getWordFrequencies();
        assertThat(wordFrequencies.size(),is(0));
    }

    @Test(groups = {"getWordsFrequencies"}, dependsOnMethods = {"shouldGetWordFrequencies"}, priority = 2)
    public void getFrequenciesReturnsNoFrequenciesForTextWithWhitespacesOnly() {
        Map<String,Long> wordFrequencies = new Text("  \n\t\n")
                .getWordFrequencies();
        assertThat(wordFrequencies.size(),is(0));
    }

    @Test(groups = {"getWordsFrequencies"}, dependsOnMethods = {"shouldGetWordFrequencies"}, priority = 2)
    public void getFrequenciesReturnsNoFrequenciesForTextWithoutWords() {
        Map<String,Long> wordFrequencies = new Text("_+-.,!@#$%^&*();\\/|<>\"'")
                .getWordFrequencies();
        assertThat(wordFrequencies.size(),is(0));
    }

    @Test(groups = {"getWordsFrequencies"}, dependsOnMethods = {"shouldGetWordFrequencies"}, priority = 1)
    public void getFrequenciesForTextThatStartsWithNotWord() {
        Map<String,Long> wordFrequencies = new Text("@aaa")
                .getWordFrequencies();
        Map<String, Long> expectedFrequencies = Collections.singletonMap("aaa",1L);
        assertThat(expectedFrequencies, is(equalTo(wordFrequencies)));
    }

}
