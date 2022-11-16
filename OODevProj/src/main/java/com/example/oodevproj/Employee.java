package com.example.oodevproj;

public abstract class Employee extends Person{
    //private int daysOffLeft = 20;
    //private ArrayList<dayBookedOff> daysBooked = new ArrayList<dayBookedOff>();

    Employee(String name, int phoneNumber, String ID){
        super(name, phoneNumber);
        super.setID(ID);
    }
}
