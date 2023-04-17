package com.example.ca4;

public class Phone implements ElectronicInterface {
    @Override
    public String Type() {
        return "Phone";
    }

    @Override
    public String Version() {
        return "IPhone";
    }
}
