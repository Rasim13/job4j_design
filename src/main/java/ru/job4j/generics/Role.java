package ru.job4j.generics;

public class Role extends User {
    public Role(String id) {
        super(id);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Role{}";
    }
}
