package com.example.code;

import com.example.code.calender.ReservationDate;

import java.util.ArrayList;

public class Bill {

    //*
    // This is the Bill class

    // @param ArrayList<Dish> order - Arraylist of Dishes
    // @param price                 - total price of dishes
    // @param tipPercent            - percentage of tip to be added to price
    // @param isCash                - boolean to determine if transaction is in cash
    // @param isPaid                - boolean to determine if transaction is in paid
    //
    // */


    private int tableID;
    
    private double price;
    private int tipPercent;
    private boolean isCash;
    private boolean isPaid;
    private ReservationDate date;



    private ArrayList<Dish> order = new ArrayList<>();
    int i;


    Bill(int tableID,ArrayList<Dish> order, double price, ReservationDate date) {
        for(int i = 0; i < order.size(); i++ ) {
                price += order.get(i).getPrice();
        }
        this.tableID = tableID;
        this.isPaid = false;
        this.date = date;
    }

    public double totalDue() {
        double totalCost;
        totalCost = price + (price * tipPercent);
        return totalCost;
    }



    public void setPrice(int price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setTipPercent(int tipPercent){
        this.tipPercent = tipPercent;
    }

    public int getTipPercent(){
        return tipPercent;
    }

    public void setCash(boolean cash){
        this.isCash = cash;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public boolean getIsPaid(){
        return isPaid;
    }
}
