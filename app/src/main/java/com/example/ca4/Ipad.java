package com.example.ca4;

public class Ipad implements ElectronicInterface {
    @Override
    public String Type() {
        return "Ipad";
    }

    @Override
    public String Version() {
        return "Apple";
    }
}
