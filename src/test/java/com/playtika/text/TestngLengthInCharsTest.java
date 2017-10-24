package com.playtika.text;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestngLengthInCharsTest {

    @Test(groups = {"getLengthInChars"})
    public void shouldGetLengthInCharsForText() {
        int count = new Text("i have 5 dollars")
                .getLengthInChars();
        assertEquals(count, 13);
    }

    @Test(groups = {"getLengthInChars"}, dependsOnMethods ={"shouldGetLengthInCharsForText"})
    public void getLengthInCharsForTextWithUppercaseLowercaseWords() {
        int count = new Text("II hAvE 5 dolLars")
                .getLengthInChars();
        assertEquals(count, 14);
    }

    @Test(groups = {"getLengthInChars"}, dependsOnMethods ={"shouldGetLengthInCharsForText"})
    public void getLengthInCharsForTextWithPunctuation() {
        int count = new Text("aa - bb @ cc . d ' d ? e e !)\n ff ( + gg , : \t")
                .getLengthInChars();
        assertEquals(count, 14);
    }

    @Test(groups = {"getLengthInChars"}, dependsOnMethods ={"shouldGetLengthInCharsForText"})
    public void getLengthInCharsForTextWithWhitespacesOnTheBeginning() {
        int count = new Text("  \n\t\rFirstText")
                .getLengthInChars();
        assertEquals(count, 9);
    }

    @Test(groups = {"getLengthInChars"}, dependsOnMethods ={"shouldGetLengthInCharsForText"}, priority = 1)
    public void getLengthInCharsIsZeroForEmptyText() {
        int count = new Text("")
                .getLengthInChars();
        assertEquals(count, 0);
    }

    @Test(groups = {"getLengthInChars"}, dependsOnMethods ={"shouldGetLengthInCharsForText"}, priority = 1)
    public void getLengthInCharsIsZeroForTextWithWhitespacesOnly() {
        int count = new Text("  \n\t\r")
                .getLengthInChars();
        assertEquals(count, 0);
    }

    @Test(groups = {"getLengthInChars"}, dependsOnMethods ={"shouldGetLengthInCharsForText"}, priority = 1)
    public void getLengthInCharsIsZeroForTextWithoutWords() {
        int count = new Text("_+-.,!@#$%^&*();\\/|<>\"'")
                .getLengthInChars();
        assertEquals(count, 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"getLengthInChars"}, dependsOnMethods ={"shouldGetLengthInCharsForText"}, priority = 2)
    public void getLengthInCharsCouldNotBeProcessedForNullText() {
        new Text(null).getLengthInChars();
    }
}
