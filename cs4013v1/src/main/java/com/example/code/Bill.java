package com.example.code;

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


    
    int price;
    int tipPercent;
    boolean isCash;
    boolean isPaid;

    private ArrayList<Dish> order = new ArrayList<>();
    int i;


    Bill(ArrayList<Dish> order, int price, int tipPercent, boolean isCash, boolean isPaid) {
        for(int i = 0; i < order.size(); i++ ) {
                price += order.get(i).getPrice();
        }
        this.tipPercent = tipPercent;
        this.isCash = isCash;
        this.isPaid = isPaid;

    }

    public int totalDue() {
        int totalCost;
        totalCost = price + (price * tipPercent);
        return totalCost;
    }



    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setTipPercent(int tipPercent){
        this.tipPercent = tipPercent;
    }

    public int getTipPercent(){
        return tipPercent;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public boolean getIsPaid(){
        return isPaid;
    }
}
