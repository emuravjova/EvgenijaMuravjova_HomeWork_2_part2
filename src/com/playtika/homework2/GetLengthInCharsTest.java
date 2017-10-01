package com.playtika.homework2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jane on 10/1/17.
 */
public class GetLengthInCharsTest {

    @Test
    public void shouldGetLengthInCharsForText() {
        int count = new Text("i have 5 dollars")
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
    public void getLengthInCharsForTextWithPunctuation() {
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
        new Text("  \n\t\r").getLengthInChars();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLengthInCharsCouldNotBeProcessedForNullText() {
        new Text(null).getLengthInChars();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLengthInCharsCouldNotBeProcessedForTextWithoutWords() {
        new Text("_+-.,!@#$%^&*();\\/|<>\"'").getLengthInChars();
    }
}