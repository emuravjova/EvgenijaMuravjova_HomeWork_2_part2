package com.playtika.text;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by jane on 10/1/17.
 */
public class GetTopWordsTest {

    @Test
    public void shouldGetTopUniqueWords() {
        List<String> topWords = new Text("hello world hello")
                .getTopWords(2);
        List<String> expectedWords = new ArrayList<>();
        expectedWords.add("hello");
        expectedWords.add("world");
        assertThat(expectedWords, is(equalTo(topWords)));
    }

    @Test
    public void getTop2WordsOrderedAlphabetically() {
        List<String> topWords = new Text("hhello hhallz")
                .getTopWords(2);
        assertThat(topWords, contains("hhallz","hhello"));
        assertThat(topWords, hasSize(2));
    }

    @Test
    public void wordsInUppercaseLowercaseIsTheSameWordsForGetTopWords() {
        List<String> topWords = new Text("HELLO hello HelLo")
                .getTopWords(3);
        assertThat(topWords, hasItem("hello"));
        assertThat(topWords,hasSize(1));

    }

    @Test
    public void getTopWordsFromTextWithPunctuation() {
        List<String> topWords = new Text("word7+word6. word5 , word4! @#$%^ &word3 *(word2); <word1>")
                .getTopWords(20);
        List<String> expectedWords = new ArrayList<>();
        for (int i = 1; i<8; i++){
            expectedWords.add("word"+i);
        }
        assertThat(expectedWords, is(equalTo(topWords)));
    }

    @Test
    public void getTopWordsReturnsNoWordsForEmptyText() {
        List<String> topWords = new Text("").getTopWords(1);
        assertThat(topWords, empty());
    }

    @Test
    public void getTopWordsReturnsNoWordsForTextWithWhitespacesOnly() {
        List<String> topWords = new Text("  \n\t\n").getTopWords(10);
        assertThat(topWords, empty());
    }

    @Test
    public void getTopWordsReturnsNoWordsForTextWithoutWords() {
        List<String> topWords = new Text("_+-.,!@#$%^&*();\\/|<>\"'").getTopWords(10);
        assertThat(topWords, empty());
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
