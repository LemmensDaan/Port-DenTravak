package com.ucll.da.dentravak.model;

import java.math.BigDecimal;

public class Order {
    private BreadType breadType;
    private String sandwichName;
    private BigDecimal sandwichPrice;
    private String telephoneNumber;

    public Order(BreadType breadType, String sandwichName, BigDecimal sandwichPrice, String telephoneNumber) {
        this.breadType = breadType;
        this.sandwichName = sandwichName;
        this.sandwichPrice = sandwichPrice;
        this.telephoneNumber = telephoneNumber;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public String getSandwichName() {
        return sandwichName;
    }

    public void setSandwichName(String sandwichName) {
        if (sandwichName == null || sandwichName.trim().isEmpty()) throw new IllegalArgumentException("Name cant be empty");
        this.sandwichName = sandwichName;
    }

    public BigDecimal getSandwichPrice() {
        return sandwichPrice;
    }

    public void setSandwichPrice(BigDecimal sandwichPrice) {
        this.sandwichPrice = sandwichPrice;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        if(telephoneNumber == null ||telephoneNumber.trim().isEmpty()) throw new IllegalArgumentException("Telephone number cant be empty");
        this.telephoneNumber = telephoneNumber;
    }
}
