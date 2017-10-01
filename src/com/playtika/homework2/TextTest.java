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
public class TextTest {

    @Test
    public void shouldGetLengthInCharsForText() {
        int count = new Text("I have 5 dollars")
                .getLengthInChars();
        assertEquals(13,count);
    }

    @Test
    public void getLengthInCharsForTextWithUppercaseLowercaseWords() {
        int count = new Text("II hAvE 5 dolLars")
                .getLengthInChars();
        assertEquals(14,count);
    }

    @Test
    public void getLengthInCharsForTextWithAnyDelimiters() {
        int count = new Text("aa - bb @ cc . d ' d ? e e !)\n ff ( + gg , : \t")
                .getLengthInChars();
        assertEquals(14,count);
    }

    @Test
    public void getLengthInCharsForTextWithWhitespacesOnTheBeginning() {
        int count = new Text("  \n\t\rFirstText")
                .getLengthInChars();
        assertEquals(9,count);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLengthInCharsCouldNotBeProcessedForEmptyText() {
        new Text("").getLengthInChars();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLengthInCharsCouldNotBeProcessedForTextWithWhitespacesOnly() {
        new Text("  \n\t\n").getLengthInChars();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLengthInCharsCouldNotBeProcessedForNullText() {
        new Text(null).getLengthInChars();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLengthInCharsCouldNotBeProcessedForTextWithoutWords() {
        new Text("_+-.,!@#$%^&*();\\/|<>\"'").getLengthInChars();
    }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////


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
        Map<String,Integer> wordFrequencies = new Text("HELLO world hello HeLlO")
                .getWordFrequencies();
        Map<String,Integer> expactedFrequencies = new HashMap<String, Integer>();
        expactedFrequencies.put("hello",3);
        expactedFrequencies.put("world",1);
        assertEquals(wordFrequencies,expactedFrequencies);
    }

    @Test
    public void getFrequenciesForWordsInTextWithPunctuation() {
        Map<String,Integer> wordFrequencies = new Text("aa - aa\" @ bb. bb, aa ?bb !)\n bb ( + aa: \t")
                .getWordFrequencies();
        Map<String,Integer> expactedFrequencies = new HashMap<String, Integer>();
        expactedFrequencies.put("aa",4);
        expactedFrequencies.put("bb",4);
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



///////////////////////////////////////////////////////////////////////////////////////////

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
    public void getTopSortedWordsWithTheSameFirstLetters() {
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
        new Text("").getWordFrequencies();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTopWordsCouldNotBeProcessedForTextWithWhitespacesOnly() {
        new Text("  \n\t\n").getWordFrequencies();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTopWordsCouldNotBeProcessedForNullText() {
        new Text(null).getWordFrequencies();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTopWordsCouldNotBeProcessedForTextWithoutWords() {
        new Text("_+-.,!@#$%^&*();\\/|<>\"'").getWordFrequencies();
    }
}