package org.example.list;

import java.util.ArrayList;
import java.util.List;

public class ListExam {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Jersey City");
        System.out.println(list);
        List<String> cities = new ArrayList<>();
        cities.add("sasa");
        cities.add("sasa");
        cities.add("sasa");
        cities.add("sasa");
        cities.add("sasa");
        cities.add("sasa");
        cities.add("sasa");
        cities.add("sasa");
        cities.add("sasa");
        cities.add("sasa");
        System.out.println(cities);

        list.addAll(cities);

        System.out.println(list);
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list.contains("Jersey City"));
    }
}
