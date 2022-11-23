package com.example.code;

import java.io.IOException;
import java.util.Scanner;

public class CLI {
    Yum yum;
    Restaurant resturaunt;
    Scanner in;

    CLI(Yum yum){
        this.yum = yum;
    }

    public void run() throws IOException {
        boolean more = true;
        while(more) {
            openPage();
        }
    }

    public void openPage() throws IOException {
        System.out.println("0)Exit system. 1)Use as employee. 2)Use as customer");
        boolean blocked = true;
        while(blocked) {
            String userType = in.nextLine();
            if (userType.equals("0")) {
                throw new IOException("System closed");
            } else if (userType.equals("1")) {
                signInPage();
                blocked = false;
            } else if (userType.equals("2")) {
                //customerBookingPage();
                blocked = false;
            }
            System.out.println("Invalid input");
        }
    }
    public void signInPage() throws IOException {
        Employee signedIn = null;
        boolean blocked = true;
        boolean more = true;
        while(more) {
            while (blocked) {
                System.out.println("Enter the location you work at");
                String locationIn = in.nextLine();
                if (yum.getRestrauntLocations().contains(locationIn)) {
                    resturaunt = yum.getResturaunt(locationIn);
                    blocked = false;
                }else{
                    System.out.println("That location doesn't exist");
                }
            }
            blocked = true;
            while(blocked){
                System.out.println("Enter your employee Id");
                String idIn = in.nextLine();
                    for(Employee e:resturaunt.getEmployees()){
                        if(e.getID().equals(idIn)){
                            signedIn = e;
                            blocked = false;
                        }
                    }
                System.out.println("No employee with that Id at this location");
            }
            blocked = true;
            while(blocked){
                System.out.println("Enter your password");
                String passwordIn = in.nextLine();
                if(signedIn.getPassword().equals(passwordIn)){
                    blocked = false;
                }
                System.out.println("Incorrect password");
            }
        }
        if(signedIn instanceof Cheff){
            //cheffPage();
            blocked = false;
        }else{
            //waterPage();
        }
    }
}

















