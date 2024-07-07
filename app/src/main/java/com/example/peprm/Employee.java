package com.example.peprm;

import java.io.Serializable;

public class Employee implements Serializable {
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

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
