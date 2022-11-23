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


    Bill(int tableID,ArrayList<Dish> order, double price, ReservationDate date) {
        for (Dish dish : order) {
            price += dish.getPrice();
        }
        this.tableID = tableID;
        this.isPaid = false;
        this.date = date;
    }

    private double totalDue() {
        double totalCost;
        totalCost = price + (price * tipPercent);
        return totalCost;
    }

    public void payBill(int tipPercent,boolean isCash){
        this.tipPercent = tipPercent;
        this.isCash = isCash;
        this.isPaid = true;
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

    public int getTableID() {
        return tableID;
    }

    public boolean getIsPaid(){
        return isPaid;
    }
    @Override
    public String toString(){
        String payMth = "";
        String dishes = "";
        for(Dish d:order){
            dishes = dishes + "\n"+ d.toString();
        }
        if(isCash){
            payMth = "Payed with cash";
        }else{
            payMth = "Payed with card";
        }
        if(isPaid) {
            return String.format("Bill:\nPrice: %.2f\tTip: %d%%\n%s\nTotal: %.2f\nDishes:%s",price,tipPercent,payMth,totalDue(),dishes);
        }else{
            return String.format("Bill:\nPrice: %.2f\nDishes:%s",price,dishes);
        }
    }
}
