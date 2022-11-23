package com.example.code;

import java.util.ArrayList;

public abstract class Person{
    private String ID;
    private String name;
    private int phoneNumber;

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

    public String getID(){
        return ID;
    }

    void setID(String ID){
        this.ID = ID;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}












