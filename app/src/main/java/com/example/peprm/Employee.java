package com.example.peprm;

// Employee.java
public class Employee {
    private int id;
    private String fullName;
    private String date;
    private double salary;

    public Employee(int id, String fullName, String date, double salary) {
        this.id = id;
        this.fullName = fullName;
        this.date = date;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDate() {
        return date;
    }

    public double getSalary() {
        return salary;
    }
}
