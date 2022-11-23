package com.example.code;

import java.util.ArrayList;

public abstract class Person{
 //*
    // This creates a new Person
    // @param name         - returns the name of a person
    // @param phoneNumber  - returns the number of a person
    // @param ID           - returns the ID of a person
    // @param complaints   - returns an arraylist for complaints
    //
    // */
    
    private String ID;
    private String name;
    private int phoneNumber;
    private ArrayList<Complaint> complaints = new ArrayList<Complaint>();

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

    public ArrayList<Complaint> getComplaints() {
        return complaints;
    }

    public void addComplaint(Complaint complaint){
        complaints.add(complaint);
    }

    public boolean checkComplaints(){
        if(complaints.size() > 3){
            return true;
        }else{
            return false;
        }
    }
    
    /*
     * This method creates a complaint
     * @param complainer     - inputs the name of the complainer
     * @param complainAbout  - inputs the subject line of the complaint
     * @param description    - inputs the information about the complaint
     *
     * */

    public void makeComplaint(Person complainer, Person complaintAbout, String description){
        Complaint comp = new Complaint(complainer, complaintAbout, description);
        complaints.add(comp);
    }
}












