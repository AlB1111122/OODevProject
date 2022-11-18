package com.example.oodevproj;

public class Customer extends Person{
    private static int noCustomers = 0;
    Customer(String name, int phoneNumber){//public for testing reset later
        super(name, phoneNumber,"C" + noCustomers);
        noCustomers++;
    }
}
