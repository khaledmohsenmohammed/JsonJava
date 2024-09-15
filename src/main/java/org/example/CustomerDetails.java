package org.example;

public class CustomerDetails {
    private String customerName;
    private String purchasedData;
    private int Amount;
    private String Location;

    //get set

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPurchasedData() {
        return purchasedData;
    }

    public void setPurchasedData(String purchasedData) {
        this.purchasedData = purchasedData;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

}
