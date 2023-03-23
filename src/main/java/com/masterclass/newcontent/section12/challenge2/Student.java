package com.masterclass.newcontent.section12.challenge2;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student implements Comparable<Student>, QueryItem {

    protected static int CountId = 1;
    protected int id;

    protected String name;
    protected int yearStart;
    protected String course;

    protected Random rand = new Random();

    public Student() {

        this.id = CountId;
        CountId++;

        List<String> names = new ArrayList<>(List.of("John", "Adelaide", "Martha", "Marx", "Julia"));
        int indexName = rand.nextInt(names.size());
        this.name = "%s %s.".formatted(names.get(indexName), (char) rand.nextInt(65, 91));

        List<String> courses = new ArrayList<>(List.of("Java", "SQL", "Python"));
        int indexCourse = rand.nextInt(courses.size());
        this.course = courses.get(indexCourse);

        this.yearStart = rand.nextInt(2020, 2023);
    }

    @Override
    public String toString() {
        return "%-10d %-15s %-15s %d".formatted(this.id, this.name, this.course, this.yearStart);
    }

    public int getId() {
        return id;
    }

    public int getYearStart() {
        return yearStart;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public int compareTo(@NotNull Student o) {
        return Integer.compare(this.id, o.getId());
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String fName = fieldName.toUpperCase();
        return switch (fName) {
            case "NAME" -> this.name.equalsIgnoreCase(value);
            case "COURSE" -> this.course.equalsIgnoreCase(value);
            case "YEARSTART" -> String.valueOf(this.yearStart).equals(value);
            default -> false;
        };
    }
}

