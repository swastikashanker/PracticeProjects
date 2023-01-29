package com.stackroute.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Employee {
    @Id
    private int personId;

    private Date joiningDate;
    private String departmentName;

    @OneToOne(targetEntity = Person.class)
    private Person person;

    public Employee(int personId, Date joiningDate, String departmentName, Person person) {
        this.personId = personId;
        this.joiningDate = joiningDate;
        this.departmentName = departmentName;
        this.person = person;
    }

    public Employee() {

    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "personId=" + personId +
                ", joiningDate=" + joiningDate +
                ", departmentName='" + departmentName + '\'' +
                ", person=" + person +
                '}';
    }
}
