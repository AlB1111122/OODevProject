package com.example.code;

public class Customer extends Person{

//*
    // This extends the Person class.
    // @param name          returns name of customer   (extended from Person)
    // @param phoneNumber   returns number of customer (extended from Person)
    // @param ID            returns ID of customer     (extended from Person)
    //
    // @see Person class
    // */
    
    
    private static int noCustomers = 0;
    Customer(String name, int phoneNumber){//public for testing reset later
        super(name, phoneNumber,"C" + noCustomers);
        noCustomers++;
    }
}
