package org.example.set;

import org.example.model.Employee;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest
{

    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("NJ");
        set.add("MA");
        set.add("NY");
        System.out.println(set);
        set.add("NJ");
        System.out.println(set);
        Comparator<Employee> employeeComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return 0;
            }
        };
        Set<Employee> empployeeSet = new TreeSet<>(employeeComparator);
        System.out.println(empployeeSet);
        Employee employee = new Employee(10, "Awadhesh", "Kumar");
        empployeeSet.add(employee);
        System.out.println(empployeeSet);
    }
}
