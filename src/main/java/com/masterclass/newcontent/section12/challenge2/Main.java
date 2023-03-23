package com.masterclass.newcontent.section12.challenge2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        var students = new ArrayList<LPAStudent>();

        for (int i = 0; i < 10; i++){
            students.add(new LPAStudent());
        }

        Collections.sort(students);

        printStudents(students);

        var matchesByCourse = QueryList.getMatches(students,"course", "java");
        var matchesByStartYear = QueryList.getMatches(students, "yearstart", "2020");
        var matchesByScore = QueryList.getMatches(students,"score", "50");

        printStudents(matchesByCourse);
        printStudents(matchesByStartYear);

        matchesByScore.sort(new LPAStudentComparator());
        printStudents(matchesByScore);

    }

    private static void printStudents(List<? extends  Student> students){
        System.out.printf("%-10s %-15s %-15s %s %8s %n", "Id:" ,"Name:", "Course:", "Start Year:", "Score:");
        for (var student : students){
            System.out.println(student);
        }
    }
}
