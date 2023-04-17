package com.example.ca4;

public class User {
    String  email,name, address, payment;
    boolean admin;

    public User() {

    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Boolean isAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public User (String email,String name, String address, String payment,boolean admin) {
        this.email = email;
        this.name= name;
        this.address = address;
        this.payment = payment;
        this.admin = admin;
    }

}
