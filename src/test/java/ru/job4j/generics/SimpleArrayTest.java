package ru.job4j.generics;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayTest {

    @Test
    public void whenAddElement() {
        SimpleArray<String> simple = new SimpleArray(1);
        assertThat(simple.add("Один"), is(true));
        assertThat(simple.add("Два"), is(false));
    }

    @Test
    public void whenAddAndGetElement() {
        SimpleArray<String> simple = new SimpleArray(2);
        simple.add("Один");
        simple.add("Два");
        assertThat(simple.get(1), is("Два"));
    }

    @Test
    public void whenSetAndGetElement() {
        SimpleArray<Integer> simple = new SimpleArray(2);
        simple.add(10);
        simple.add(20);
        simple.set(0, 30);
        assertThat(simple.get(0), is(30));
    }

    @Test
    public void whenIteratorHasNotNext() {
        SimpleArray<Integer> simple = new SimpleArray(3);
        Iterator it = simple.iterator();
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenIteratorNext() {
        SimpleArray<Integer> simple = new SimpleArray(3);
        simple.add(10);
        Iterator it = simple.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(10));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextThrowException() {
        SimpleArray<Integer> simple = new SimpleArray(3);
        Iterator it = simple.iterator();
        it.next();
    }
}