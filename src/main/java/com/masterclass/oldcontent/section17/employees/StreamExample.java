package com.masterclass.oldcontent.section17.employees;

import java.util.ArrayList;
import java.util.List;

public class StreamExample {

    public static void main(String[] args) {

        Employee[] employees = {
                new Employee("John Kol", 32),
                new Employee("Carl Sagan", 20),
                new Employee("Mar Jason", 25),
                new Employee("Kilo Arroba", 27),
                new Employee("Juh Juh", 54),
                new Employee("Ana Maria", 41)
        };

        Department hr = new Department("Human Resources");
        Department accounting = new Department("Accounting");

        for (int i = 0; i < employees.length / 2; i++) {
            hr.addEmployee(employees[i]);
        }

        for (int i = employees.length / 2; i < employees.length; i++) {
            accounting.addEmployee(employees[i]);
        }

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                    .flatMap(department -> department.getEmployees().stream())
                    .forEach(System.out::println);

                    

    }

}
