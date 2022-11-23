package com.example.code;

public abstract class Employee extends Person{
    private String password;

   //*
    // This extends the Person class.
    // This constructs a new Employee
    // @param name          (extended from Person)
    // @param phoneNumber   (extended from Person)
    // @param ID            (extended from Person)
    //
    // @see Person class
    //
    // @param password  -   password used to check employee register
    // */
    Employee(String name, int phoneNumber,String ID,String password){
        super(name, phoneNumber,ID);
        this.password = password;
    }

    /**
     * returns the Employees password
     * @return String of the password
     */
    public String getPassword() {
        return password;
    }
}
