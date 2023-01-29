package com.stackroute.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Owner extends Person{


    private int stocks;
    private int partnershipStake;

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

    public Owner(int stocks, int partnershipStake) {
        this.stocks = stocks;
        this.partnershipStake = partnershipStake;
    }


    public Owner() {
    }


}
