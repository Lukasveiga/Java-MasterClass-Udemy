package com.masterclass.newcontent.section13;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private int yearStart;

    public Employee() {
    }

    public Employee(int id, String name, int yearStart) {
        this.id = id;
        this.name = name;
        this.yearStart = yearStart;
    }

    @Override
    public int compareTo(@NotNull Employee o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return "%5d %-5s %d".formatted(id, name, yearStart);
    }

    public static class EmployeeComparator <T extends Employee> implements Comparator<Employee> {

        private final String fieldComparator;

        public EmployeeComparator(String fieldComparator) {
            this.fieldComparator = fieldComparator;
        }

        @Override
        public int compare(Employee o1, Employee o2) {
            return switch (fieldComparator.toLowerCase()) {
                case "yearstart" -> o1.yearStart - o2.yearStart;
                case "name" -> o1.name.compareTo(o2.name);
                default -> o1.id - o2.id;
            };
        }
    }
}
