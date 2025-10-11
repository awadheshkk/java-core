package org.example.map;

import java.util.*;

public class HashtableTest {
    public static void main(String[] args) {
        Map<String, String> stateMap = new Hashtable<>();

        stateMap.put("NJ", "New Jersey");
        stateMap.put("NY", "New York");
        stateMap.put("VA", "Virginia");
        stateMap.put("CA", "California");
        System.out.println(stateMap);

        if(stateMap.containsKey("NJ")){
            System.out.println(stateMap.get("NJ"));
        }
        System.out.println(stateMap.get("MA"));

        System.out.println(stateMap.entrySet());
//1)
        Set<Map.Entry<String, String>> set = stateMap.entrySet();
       Iterator<Map.Entry<String, String>> itr = set.iterator();
       //or
        Iterator<Map.Entry<String, String>> itr1 =    stateMap.entrySet().iterator();

        while(itr1.hasNext()){
            Map.Entry<String, String> entry = itr1.next();
            System.out.println(entry.getKey() +", "+entry.getValue());
        }
        System.out.println("----------------");
        //2)
        Set<String> keys =  stateMap.keySet();
        Iterator<String> iterator = keys.iterator();

        while(iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key+", "+stateMap.get(key));
        }

        Map<String, String> stateMap1 = new TreeMap<>();
    }
}
