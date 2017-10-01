package com.playtika.homework2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by jane on 10/1/17.
 */
public class GetTopWordsTest {
    @Test
    public void shouldGetTopUniqueWords() {
        List<String> topWords = new Text("hello world hello")
                .getTopWords(2);
        List<String> expactedWords = new ArrayList<String>();
        expactedWords.add("hello");
        expactedWords.add("world");
        assertEquals(topWords,expactedWords);
    }

    @Test
    public void getTopWordsOrderedAlphabetically() {
        List<String> topWords = new Text("hhello hhallz")
                .getTopWords(2);
        List<String> expactedWords = new ArrayList<String>();
        expactedWords.add("hhallz");
        expactedWords.add("hhello");
        assertEquals(topWords,expactedWords);
    }

    @Test
    public void getTopWordsInUppercaseLowercase() {
        List<String> topWords = new Text("HELLO hello HelLo")
                .getTopWords(3);
        List<String> expactedWords = new ArrayList<String>();
        expactedWords.add("hello");
        assertEquals(topWords,expactedWords);
    }

    @Test
    public void getTopWordsFromTextWithPunctuation() {
        List<String> topWords = new Text("word7+word6. word5 , word4! @#$%^ &word3 *(word2); <word1>")
                .getTopWords(3);
        List<String> expactedWords = new ArrayList<String>();
        expactedWords.add("word1");
        expactedWords.add("word2");
        expactedWords.add("word3");
        assertEquals(topWords,expactedWords);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTopWordsCouldNotBeProcessedForEmptyText() {
        new Text("").getTopWords(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTopWordsCouldNotBeProcessedForTextWithWhitespacesOnly() {
        new Text("  \n\t\n").getTopWords(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTopWordsCouldNotBeProcessedForNullText() {
        new Text(null).getTopWords(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTopWordsCouldNotBeProcessedForTextWithoutWords() {
        new Text("_+-.,!@#$%^&*();\\/|<>\"'").getTopWords(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTopWordsCouldNotBeProcessedForZeroN() {
        new Text("some test text").getTopWords(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTopWordsCouldNotBeProcessedForNegativeN() {
        new Text("some test text").getTopWords(-1);
    }
}
