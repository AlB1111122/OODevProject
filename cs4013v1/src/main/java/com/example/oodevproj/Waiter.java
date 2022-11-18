package com.example.oodevproj;

import java.util.ArrayList;

public class Waiter extends Employee{
    private static int noWaiters = 0;

    Waiter(String name, int phoneNumber,String password){
        super(name, phoneNumber, "W" + noWaiters,password);
        noWaiters++;
    }
}
