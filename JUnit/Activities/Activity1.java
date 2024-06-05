package activities;

import org.junit.BeforeClass;

//import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Activity1 {
    // Test fixtures
    static ArrayList<String> list;

    @BeforeAll
    public static void setUp() {
        // Initialize a new ArrayList
        list = new ArrayList<String>();
        // Add values to the list
        list.add("alpha"); // at index 0
        list.add("beta"); // at index 1
    }

    @Test
    public void insertTest() {
// Assert size of list
        Assertions.assertEquals(list.size(), "Wrong size", String.valueOf(2));
// Add new element
        list.add(2, "charlie");
        // Assert with new elements
        assertEquals(3, list.size(), "Wrong size");
// Assert individual elements
        assertEquals("alpha",
                list.get(0));
        assertEquals("beta",
                list.get(1));
        assertEquals("charlie",
                list.get(2));
    }

    @Test
    public void replaceTest() {
// Replace new element
        list.set(1, "charlie");

        // Assert size of list
        assertEquals(2, list.size());
        // Assert individual elements
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("charlie", list.get(1), "Wrong element");
    }
}

