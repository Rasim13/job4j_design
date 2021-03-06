package ru.job4j.collection;

import java.util.Iterator;

public class SimpleStack<T> implements Iterable {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        return linked.deleteLast();
    }

    public void push(T value) {
        linked.add(value);
    }

    @Override
    public Iterator iterator() {
        return linked.iterator();
    }
}
