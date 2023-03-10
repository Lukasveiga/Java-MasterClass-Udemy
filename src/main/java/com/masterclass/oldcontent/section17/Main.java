package com.masterclass.oldcontent.section17;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println("Printing for the Runnable");
            System.out.println("This is line 2");
            System.out.println("This is line 3");
        }).start();

        Employee[] employees = {
            new Employee("John", 18),
            new Employee("Calr", 20),
            new Employee("Mar", 25),
            new Employee("Kilo", 27)
        };

        List<Employee> list = Arrays.asList(employees);

        list.sort((Employee o1, Employee o2) -> o1.getName().compareTo(o2.getName()));
        list.forEach(employee -> System.out.println(employee.getName() + " : " + employee.getAge()));

        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();

        String sillyString = uc.upperAndConcat(employees[0].getName(), employees[1].getName());

        System.out.println(sillyString);


    }

}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    
    
}

@FunctionalInterface
interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}
