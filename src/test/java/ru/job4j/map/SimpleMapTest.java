package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleMapTest {
    private SimpleMap<Integer, Integer> map;

    @Before
    public void beforeTest() {
        map = new SimpleMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.remove(2);
    }

    @Test
    public void whenInsertTreeElementAndGetTwo() {
        assertThat(map.get(1), is(1));
        assertThat(map.get(3), is(3));
    }

    @Test
    public void whenTestIterator() {
        Iterator iterator = map.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(3));
    }

}