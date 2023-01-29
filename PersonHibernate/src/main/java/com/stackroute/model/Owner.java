package com.stackroute.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Owner {
    @Id
    private int personId;

    private int stocks;
    private int partnershipStake;

    @OneToOne(targetEntity = Person.class)
    private Person person;

    public Owner(int personId, int stocks, int partnershipStake, Person person) {
        this.personId = personId;
        this.stocks = stocks;
        this.partnershipStake = partnershipStake;
        this.person = person;
    }

    public Owner() {
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public int getPartnershipStake() {
        return partnershipStake;
    }

    public void setPartnershipStake(int partnershipStake) {
        this.partnershipStake = partnershipStake;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "personId=" + personId +
                ", stocks=" + stocks +
                ", partnershipStake=" + partnershipStake +
                ", person=" + person +
                '}';
    }
}
