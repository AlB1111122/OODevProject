package com.example.oodevproj;

public class Customer extends Person{
    private static int noCustomers = 0;
    public Customer(String name, int phoneNumber){//public for testing reset later
        super(name, phoneNumber);
        super.setID("C" + noCustomers);
        noCustomers++;
    }
}
