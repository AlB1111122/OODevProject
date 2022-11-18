package com.example.oodevproj;
import java.util.ArrayList;

public class Cheff extends Employee{
    private static int noCheffs = 0;

    Cheff(String name, int phoneNumber,String password){
        super(name, phoneNumber, "Ch" + noCheffs,password);
        noCheffs++;
    }
}
