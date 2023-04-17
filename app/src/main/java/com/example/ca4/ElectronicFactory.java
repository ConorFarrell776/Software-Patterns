package com.example.ca4;

public class ElectronicFactory {
    public static ElectronicInterface getInterface(String unit) {

        if (unit == "Laptop") {
            return new Laptop();

        } else if (unit == "Phone") {
            return new Phone();

        } else if (unit == "Ipad") {
            return new Ipad();
        }

        return null;
    }
}
