package ru.job4j.map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Rasim", 2, new GregorianCalendar(1992, 05, 24));
        User user2 = new User("Rasim", 2, new GregorianCalendar(1992, 05, 24));

        Map<User, Object> newMap = new HashMap<>();
        newMap.put(user1, new Object());
        newMap.put(user2, new Object());

        System.out.println(newMap);
    }
}
