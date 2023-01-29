package com.stackroute.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Department {

    @Id
    private int departmentId;
    private String departmentName;


    @OneToMany
    private List<Employee> employee;

    public Department(int departmentId, String departmentName, List<Employee> employee) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.employee = employee;
    }

    public Department() {
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", employee=" + employee +
                '}';
    }
}
