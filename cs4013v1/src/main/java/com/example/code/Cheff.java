package com.example.code;

public class Cheff extends Employee{
    private static int noCheffs = 0;

    /**
     * constructs a new cheff
     * @param name the name of the cheff
     * @param phoneNumber the cheffs phone number
     * @param password the cheffs password(needed to sign in)
     */
    Cheff(String name, int phoneNumber,String password){
        super(name, phoneNumber, "Ch" + noCheffs,password);
        noCheffs++;
    }
}
