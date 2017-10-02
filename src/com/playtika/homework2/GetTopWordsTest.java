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
        List<String> expectedWords = new ArrayList<String>();
        expectedWords.add("hello");
        expectedWords.add("world");
        assertEquals(expectedWords,topWords);
    }

    @Test
    public void getTopWordsOrderedAlphabetically() {
        List<String> topWords = new Text("hhello hhallz")
                .getTopWords(2);
        List<String> expectedWords = new ArrayList<String>();
        expectedWords.add("hhallz");
        expectedWords.add("hhello");
        assertEquals(expectedWords,topWords);
    }

    @Test
    public void getTopWordsInUppercaseLowercase() {
        List<String> topWords = new Text("HELLO hello HelLo")
                .getTopWords(3);
        List<String> expectedWords = new ArrayList<String>();
        expectedWords.add("hello");
        assertEquals(expectedWords,topWords);
    }

    @Test
    public void getTopWordsFromTextWithPunctuation() {
        List<String> topWords = new Text("word7+word6. word5 , word4! @#$%^ &word3 *(word2); <word1>")
                .getTopWords(20);
        List<String> expectedWords = new ArrayList<String>();
        for (int i = 1; i<8; i++){
            expectedWords.add("word"+i);
        }
        assertEquals(expectedWords,topWords);
    }

    @Test
    public void getTopWordsReturnsNoWordsForEmptyText() {
        List<String> topWords = new Text("").getTopWords(1);
        List<String> expectedWords = new ArrayList<String>();
        assertEquals(expectedWords,topWords);
    }

    @Test
    public void getTopWordsReturnsNoWordsForTextWithWhitespacesOnly() {
        List<String> topWords = new Text("  \n\t\n").getTopWords(10);
        List<String> expectedWords = new ArrayList<String>();
        assertEquals(expectedWords,topWords);
    }

    @Test
    public void getTopWordsReturnsNoWordsForTextWithoutWords() {
        List<String> topWords = new Text("_+-.,!@#$%^&*();\\/|<>\"'").getTopWords(10);
        List<String> expectedWords = new ArrayList<String>();
        assertEquals(expectedWords,topWords);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTopWordsCouldNotBeProcessedForNullText() {
        new Text(null);
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
