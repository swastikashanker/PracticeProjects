package com.stackroute.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Employee extends Person{


    private Date joiningDate;
    private String departmentName;



    public Employee() {

    }



    public Employee(Date joiningDate, String departmentName) {
        this.joiningDate = joiningDate;
        this.departmentName = departmentName;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "joiningDate=" + joiningDate +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
