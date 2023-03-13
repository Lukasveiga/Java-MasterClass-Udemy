package com.masterclass.newcontent.section07.challenges;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Employee extends Worker{

    private static int employeeId = 0;
    private LocalDate hireDate;

    public Employee(){
        super();
        employeeId += 1;
    }

    public Employee(String name, String birthDate, String hireDate) {
        super(name, birthDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.hireDate = LocalDate.parse(hireDate, formatter);

        employeeId += 1;
    }

    public static int getEmployeeId() {
        return employeeId;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.hireDate = LocalDate.parse(hireDate, formatter);
    }

    @Override
    public String toString() {
        return "Employee{" + "Id=" + employeeId +
                ", hireDate=" + hireDate +
                "} " + super.toString();
    }
}
