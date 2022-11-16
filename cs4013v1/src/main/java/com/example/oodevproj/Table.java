package com.example.oodevproj;

public class Table{
    private int tableID;
    private int seats;
    //private boolean movable;

    Table(int seats, int tableID){
        this.tableID = tableID;
        this.seats = seats;
        //this.movable = movable;
    }

    public int getTableID(){
        return tableID;
    }

    public int getSeats(){
        return seats;
    }

    public String toString(){
        return String.format("Table number: %d, Number of seats %d",tableID,seats);
    }
}
