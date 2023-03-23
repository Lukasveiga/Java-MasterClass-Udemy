package com.masterclass.newcontent.section12.challenge2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        var students = new ArrayList<Student>();

        for (int i = 0; i < 10; i++){
            students.add(new LPAStudent());
        }

        printStudents(students);

    }

    private static void printStudents(List<Student> students){
        System.out.printf("%-15s %-15s %s %8s %n", "Name:", "Course:", "Start Year:", "Score:");
        for (var student : students){
            System.out.println(student);
        }
    }
}
