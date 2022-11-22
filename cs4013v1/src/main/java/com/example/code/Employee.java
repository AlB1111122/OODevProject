package com.example.code;

public abstract class Employee extends Person{
    private String password;

    /**
     * construct new employee
     * @param name String of the employees name
     * @param phoneNumber the int employees phone number
     * @param ID the emplyees id String
     * @param password String off the employees password
     */
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
