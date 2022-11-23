package com.example.code;

public class Cheff extends Employee{
    private static int noCheffs = 0;

    //*
    // This extends the Employee class and constructs a Cheff.
    // @param name          (extended from Employee > Person)
    // @param phoneNumber   (extended from Employee > Person)
    // @param password      (extended from Employee > Person)
    // @param ID            (extended from Employee > Person)
    //
    // @see Employee class
    // */
    Cheff(String name, int phoneNumber,String password){
        super(name, phoneNumber, "Ch" + noCheffs,password);
        noCheffs++;
    }
}
