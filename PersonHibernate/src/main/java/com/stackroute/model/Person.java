package com.stackroute.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
    @Id
    private int personId;

    private String firstName;
    private String lastName;

    @OneToOne
    private Employee employee;

    @OneToOne
    private Owner owner;

    public Person() {
    }


    public Person(int personId, String firstName, String lastName, Employee employee, Owner owner) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employee = employee;
        this.owner = owner;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employee=" + employee +
                ", owner=" + owner +
                '}';
    }
}
