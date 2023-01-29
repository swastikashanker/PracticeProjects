package com.stackroute.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Employee {

    @Id
    private int employeeId;

    private String firstName;
    private String lastName;
    private String birthDate;
    private String cellPhone;

    @ManyToOne
    private Department department;

    public Employee() {
    }

    public Employee(int employeeId, String firstName, String lastName, String birthDate, String cellPhone, Department department) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.cellPhone = cellPhone;
        this.department = department;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", department=" + department +
                '}';
    }
}
