package com.example.ca4;

public class User {
    String  email, address, payment;

    public User() {

    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public User (String email, String address, String payment) {
        this.email = email;
        this.address = address;
        this.payment = payment;
    }

}
