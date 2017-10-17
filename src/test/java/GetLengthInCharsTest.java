import com.playtika.homework2.Text;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by jane on 10/1/17.
 */
public class GetLengthInCharsTest {

    @Test
    public void shouldGetLengthInCharsForText() {
        int count = new Text("i have 5 dollars")
                .getLengthInChars();
        assertThat(count, is(13));
    }

    @Test
    public void getLengthInCharsForTextWithUppercaseLowercaseWords() {
        int count = new Text("II hAvE 5 dolLars")
                .getLengthInChars();
        assertThat(count, is(14));
    }

    @Test
    public void getLengthInCharsForTextWithPunctuation() {
        int count = new Text("aa - bb @ cc . d ' d ? e e !)\n ff ( + gg , : \t")
                .getLengthInChars();
        assertThat(count, is(14));
    }

    @Test
    public void getLengthInCharsForTextWithWhitespacesOnTheBeginning() {
        int count = new Text("  \n\t\rFirstText")
                .getLengthInChars();
        assertThat(count, is(9));
    }

    @Test
    public void getLengthInCharsIsZeroForEmptyText() {
        int count = new Text("")
                .getLengthInChars();
        assertThat(count, is(0));
    }

    @Test
    public void getLengthInCharsIsZeroForTextWithWhitespacesOnly() {
        int count = new Text("  \n\t\r")
                .getLengthInChars();
        assertThat(count, is(0));
    }

    @Test
    public void getLengthInCharsIsZeroForTextWithoutWords() {
        int count = new Text("_+-.,!@#$%^&*();\\/|<>\"'")
                .getLengthInChars();
        assertThat(count, is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLengthInCharsCouldNotBeProcessedForNullText() {
        new Text(null).getLengthInChars();
    }
}