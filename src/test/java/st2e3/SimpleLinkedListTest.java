package st2e3;/*
 * (c) 2022-2022  Marie Clausnitzer, Leonard Herbst, Sarah Rundfeldt
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class SimpleLinkedListTest {

    private SimpleLinkedList<String> testList;

    @BeforeEach
    public void setup(){
        testList = new SimpleLinkedList<>();
    }

    @Test
    public void addElement(){
        String testString = "Hello Test!";
        testList.add(testString);
        assertThat(testList.contains(testString)).isTrue();
    }

    @Test
    public void orderOfElements(){
        String s1 = "Hallo";
        String s2 = " Test!";
        testList.add(s1);
        testList.add(s2);
        assertThat(testList.containsAll(Arrays.asList(s1, s2))).isTrue();
    }

    @Test
    public void duplicates(){
        String s = "Hallo Test!";
        testList.add(s);
        testList.add(s);
        assertThat(testList.size()).isEqualTo(2);
    }

    @Test
    public void nullElements(){
        assertThat(testList.add(null)).isTrue();
    }

    @Test
    public void removeElement(){
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> {
            String s1 = "Hallo Test!";
            testList.add(s1);
            testList.remove(s1);
        });
    }

    @Test
    public void iterHasNext(){
        assertThat(testList.iterator().hasNext()).isFalse();
    }

    @Disabled
    @Test
    public void testNothing(){
        testList.add("Ich ");
        testList.add("mag ");
        testList.add("Softwaretechnologie ");
        testList.add("2!");
    }
}
