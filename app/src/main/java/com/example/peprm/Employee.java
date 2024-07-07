package com.example.peprm;

// Employee.java
public class Employee {
    private int id;
    private String fullName;
    private String hiredate;
    private String salary;

    public Employee(int id, String fullName, String date, String salary) {
        this.id = id;
        this.fullName = fullName;
        this.hiredate = date;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "          " + fullName + "      " + hiredate + "       " + salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
