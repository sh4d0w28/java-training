package com.lazada.assets;


public class Employee implements Comparable<Employee> {   // make it sortable

    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    @Override
    // -1 mean object before, 1 - mean object after
    public int compareTo(Employee o) {
        if (this.id > o.id) {
            return -1;
        } else if (this.id < o.id) {
            return 1;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
