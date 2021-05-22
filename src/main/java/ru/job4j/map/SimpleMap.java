package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private Node<K, V>[] table = new Node[capacity];

    @Override
    public boolean put(K key, V value) {
        int index = hash(key);
        if (contains(index)) {
            return false;
        }
        if (count >= LOAD_FACTOR ) {
            capacity *= 2;
            table = resize(capacity);
        }
        table[index] = new Node<>(key, value);
        count++;
        modCount++;
        return true;
    }

    private Node<K,V>[] resize(int capacity) {
        Node<K, V>[] oldTable = table;
        Node<K, V>[] newTable = new Node[capacity];
        table = newTable;
        for (Node<K, V> kvNode : oldTable) {
            Node<K, V> e;
            if (kvNode != null) {
                e = kvNode;
                newTable[hash(e.key)] = e;
            }

        }
        return newTable;
    }

    private boolean contains(int index) {
        return table[index] != null;
    }

    private int hash(K key) {
        return (key.hashCode() % 100 + key.hashCode() % 10) % capacity;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        if(contains(index) && table[index].key.equals(key)) {
            return table[index].value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int index = hash(key);
        if (contains(index) && table[index].key.equals(key)) {
            table[index] = null;
            count--;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int point = 0;
            private int temp = 0;
            private final int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                return point < count;
            }
            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int i = temp; i < capacity; i++) {
                    if (table[i] != null) {
                        temp = i;
                        temp++;
                        point++;
                        return table[i].key;
                    }
                }
                return null;
            }
        };
    }

    private static class Node<K, V> {
        K key;
        V value;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }
}
