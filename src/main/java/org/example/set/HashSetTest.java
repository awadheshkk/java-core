package org.example.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("NJ");
        set.add("MA");
        set.add("NY");
        System.out.println(set);
        set.add("NJ");
        System.out.println(set);
    }
}
