package com.masterclass.newcontent.section12.challenge2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student {

    protected String name;
    protected  int yearStartCourse;
    protected String course;

    protected Random rand = new Random();

    public Student() {

        List<String> names = new ArrayList<>(List.of("John", "Adelaide", "Martha", "Marx", "Julia"));
        int indexName = rand.nextInt(names.size());
        this.name = "%s %s.".formatted(names.get(indexName), (char) rand.nextInt(65,91));

        List<String> courses = new ArrayList<>(List.of("Java", "SQL", "Python"));
        int indexCourse = rand.nextInt(courses.size());
        this.course = courses.get(indexCourse);

        this.yearStartCourse = rand.nextInt(2020, 2023);
    }

    @Override
    public String toString() {
        return "%-15s %-15s %d".formatted(this.name, this.course, this.yearStartCourse);
    }
}
