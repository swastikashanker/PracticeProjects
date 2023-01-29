package com.stackroute.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @Column(name = "employee_name")
    private String eName;

    @Column(name = "employee_salary")
    private double eSalary;


    private Address address;

    public Employee() {
    }

    public Employee(int empId, String eName, double eSalary, Address address) {
        this.empId = empId;
        this.eName = eName;
        this.eSalary = eSalary;
        this.address = address;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public double geteSalary() {
        return eSalary;
    }

    public void seteSalary(double eSalary) {
        this.eSalary = eSalary;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", eName='" + eName + '\'' +
                ", eSalary=" + eSalary +
                ", address=" + address +
                '}';
    }
}
