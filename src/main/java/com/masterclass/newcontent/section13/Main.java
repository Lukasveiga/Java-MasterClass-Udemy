package com.masterclass.newcontent.section13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(15, "John", 2020),
                new Employee(23, "Sarah", 2020),
                new Employee(33, "Julia", 2021),
                new Employee(8, "Math", 2019)
        ));

        Collections.sort(employees);

        employees.forEach(System.out::println);

        employees.sort(new Employee.EmployeeComparator<>("YearStart"));

        System.out.println("---------------------------");

        employees.forEach(System.out::println);

        System.out.println("---------------------------");

        employees.sort(new Employee.EmployeeComparator<>("name"));

        employees.forEach(System.out::println);

        System.out.println("---------------------------");

        System.out.println("Store");

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(15, "John", 2021, "Americanas"),
                new StoreEmployee(23, "Sarah", 2020, "Americanas"),
                new StoreEmployee(33, "Julia", 2021, "Americanas"),
                new StoreEmployee(8, "Math", 2019, "Wallmart")
        ));

        storeEmployees.sort(new StoreEmployee().new StoreComparator());
        storeEmployees.forEach(System.out::println);


    }
}
