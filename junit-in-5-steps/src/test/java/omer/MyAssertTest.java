package omer;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyAssertTest {

    List<String> todos = Arrays.asList("AWS","Azure","DevOps");

    @Test
    public void test(){
        boolean test = todos.contains("AWS");
        boolean test2 = todos.contains("GCP");
        assertTrue(test);
        assertFalse(test2);
        assertArrayEquals(new int[]{1,2}, new int[]{1,2});
        assertEquals(3,todos.size());
    }
}
