package lab11.task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMultiMapValue {
    private MultiMapValue<String, String> map;

    @BeforeEach
    public void setup() {
        map = new MultiMapValue<>();
    }

    @AfterEach
    public void clean() {
        map = null;
    }

    @Test
    public void testAddElementWithOneValue() {
        map.add("key", "value");
        Assertions.assertFalse(map.isEmpty());
        Assertions.assertEquals(1, map.size());
        Assertions.assertEquals(1, map.getValues("key").size());
    }

    @Test
    public void testAddElementWithMoreValues() {
        map.add("key", "value1");
        map.add("key", "value2");
        Assertions.assertFalse(map.isEmpty());
        Assertions.assertEquals(1, map.size());
        Assertions.assertEquals(2, map.getValues("key").size());
    }

    @Test
    public void testAddTwoElements() {
        // TODO
        map.add("key1", "value1");
        map.add("key1", "value2");
        map.add("key2", "value3");
        Assertions.assertFalse(map.isEmpty());
        Assertions.assertEquals(2, map.size());
        Assertions.assertEquals(2, map.getValues("key1").size());
        Assertions.assertEquals(1, map.getValues("key2").size());
    }

    @Test
    public void testGetFirst() {
        // TODO
        map.add("key1", "value1");
        map.add("key1", "value2");
        map.add("key1", "value3");
        Assertions.assertFalse(map.isEmpty());
        Assertions.assertEquals(1, map.size());
        Assertions.assertEquals("value1", map.getFirst("key1"));
    }

    @Test
    public void testContainsKey() {
        // TODO
        map.add("key1", "value1");
        map.add("key1", "value2");
        map.add("key1", "value3");
        Assertions.assertTrue(map.containsKey("key1"));
        Assertions.assertFalse(map.containsKey("key2"));
    }

    @Test
    public void testSize() {
        // TODO
        map.add("key1", "value1");
        map.add("key1", "value2");
        map.add("key2", "value3");
        map.add("key3", "value1");
        Assertions.assertFalse(map.isEmpty());
        Assertions.assertEquals(3, map.size());
        map.add("key4", "value2");
        Assertions.assertEquals(4, map.size());
    }

    @Test
    public void testRemoveKey() {
        // TODO
        map.add("key1", "value1");
        map.add("key1", "value2");
        map.add("key2", "value3");
        map.add("key3", "value1");
        Assertions.assertTrue(map.containsKey("key2"));
        map.remove("key2");
        Assertions.assertFalse(map.containsKey("key2"));
    }

    @Test
    public void testAddAllWithList() {
        // TODO
        map.add("key1", "value1");
        map.add("key1", "value2");
        map.add("key2", "value3");
        ArrayList<String> list = new ArrayList<>();
        list.add("value4");
        list.add("value5");
        list.add("value6");

        map.addAll("key1", list);
        Assertions.assertEquals(2, map.size());
        Assertions.assertEquals(5, map.getValues("key1").size());

        map.addAll("key3", list);
        Assertions.assertEquals(3, map.size());
        Assertions.assertEquals(3, map.getValues("key3").size());
    }

    @Test
    public void testAddAllWithMultiMapValue() {
        // TODO
        map.add("key1", "value1");
        map.add("key1", "value2");
        map.add("key2", "value3");
        MultiMapValue<String, String> testMap = new MultiMapValue<>();
        testMap.add("key3", "value1");
        testMap.add("key4", "value2");
        testMap.add("key2", "value3");

        map.addAll(testMap);
        Assertions.assertEquals(4, map.size());
        Assertions.assertEquals(2, map.getValues("key2").size());
    }
}
