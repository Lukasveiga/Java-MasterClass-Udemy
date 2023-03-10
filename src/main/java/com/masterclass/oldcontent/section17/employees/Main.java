package com.masterclass.oldcontent.section17.employees;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Employee[] employees = {
                new Employee("John Kol", 32),
                new Employee("Carl Sagan", 20),
                new Employee("Mar Jason", 25),
                new Employee("Kilo Arroba", 27),
                new Employee("Juh Juh",54),
                new Employee("Ana Maria", 41)
        };

        List<Employee> list = Arrays.asList(employees);

        list.forEach(employee -> System.out.println(employee.getName() + " : " + employee.getAge()));

        System.out.println("**********************");

        Predicate<Employee> ageMoreThanThird = employee -> employee.getAge() > 30;
        Predicate<Employee> ageLessThanThird = employee -> employee.getAge() < 30;

        System.out.println("Employees with age more than third");
        list.stream()
        .filter(ageMoreThanThird)
        .forEach(employee -> System.out.println(employee.getName() + " : " + employee.getAge()));

        System.out.println("Employees with age less than third");

        list.stream()
        .filter(ageLessThanThird)
        .forEach(employee -> System.out.println(employee.getName() + " : " + employee.getAge()));                                                                                                   

        Function<Employee, String> getLastName = (employee) -> {
            return employee.getName().substring(employee.getName().indexOf(" ") + 1);
        };

        Function<Employee, String> getFirstName = (employee) -> employee.getName()
                                                                        .substring(0, employee.getName().indexOf(" "));

        String firstName = getFirstName.apply(list.get(1));
        System.out.println(firstName);
        String lastName = getLastName.apply(list.get(1));
        System.out.println(lastName);

        Function<Employee, String> upperCase = (employee) -> employee.getName().toUpperCase();
        Function<String, String> getFristName = name -> name.substring(0, name.indexOf(" "));
        Function<Employee, String> chainedFunction = upperCase.andThen(getFristName);

        System.out.println(chainedFunction.apply(list.get(0)));

        BiFunction<String, Employee, String> concatAge = (name, employee) -> name.concat(" " + employee.getAge());

        String upperCaseName = chainedFunction.apply(list.get(0));
        System.out.println(concatAge.apply(upperCaseName, list.get(0)));


    }

}