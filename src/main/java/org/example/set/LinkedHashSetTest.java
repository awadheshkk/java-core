package org.example.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest {

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("NJ");
        set.add("MA");
        set.add("NY");
        System.out.println(set);
        set.add("NJ");
        System.out.println(set);
    }
}
