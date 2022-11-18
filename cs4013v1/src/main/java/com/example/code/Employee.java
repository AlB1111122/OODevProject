package com.example.code;

public abstract class Employee extends Person{
    private String password;

    Employee(String name, int phoneNumber,String ID,String password){
        super(name, phoneNumber,ID);
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
}
