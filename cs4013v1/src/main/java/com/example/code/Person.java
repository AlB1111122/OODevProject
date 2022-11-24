package com.example.code;

import java.util.ArrayList;

public abstract class Person{
    private String ID;
    private String name;
    private int phoneNumber;

    /**
     * constructs a new person
     * @param name the  persons name
     * @param phoneNumber the persons phone number
     * @param ID the persons unique
     */
    Person(String name, int phoneNumber,String ID){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    /**
     * returns the persons in
     * @return String ID for the person
     */
    public String getID(){
        return ID;
    }

    void setID(String ID){
        this.ID = ID;
    }

    /**
     * returns the persons phone number
     * @return int of the persons phone number
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}












