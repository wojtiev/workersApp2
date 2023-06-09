package com.company;

public class Employee {

    private String firstName;

    public String getLastName() {
        return lastName;
    }

    private String lastName;

    public void setPosition(String position) {
        this.position = position;
    }

    private String position;
    private int employeeID;

    public int getSalary() {
        return salary;
    }

    private int salary;

    public Employee(String firstName, String lastName, String position, int employeeID, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.employeeID = employeeID;
        this.salary = salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", employeeID=" + employeeID +
                ", salary=" + salary +
                '}';
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
