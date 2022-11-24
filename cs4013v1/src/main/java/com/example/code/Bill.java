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

    /**
     * construcs a new bill
     * @param tableID adds the table the id is for
     * @param order adds the dishes being orderd
     * @param price the price of the dish
     * @param date the date the bill was paid on
     */
    Bill(int tableID,ArrayList<Dish> order, double price, ReservationDate date) {
        for (Dish dish : order) {
            price += dish.getPrice();
        }
        this.tableID = tableID;
        this.isPaid = false;
        this.date = date;
    }

    /**
     * adds the price and the tip to and returns the total
     * @return double of the total amount to be paid
     */
    private double totalDue() {
        double totalCost;
        totalCost = price + (price * tipPercent);
        return totalCost;
    }

    /**
     * allows a customer to pay the bill
     * @param tipPercent the amount the customer wants to tip
     * @param isCash boolean that determes if the bill was paid by cash or card
     */
    public void payBill(int tipPercent,boolean isCash){
        this.tipPercent = tipPercent;
        this.isCash = isCash;
        this.isPaid = true;
    }

    /**
     * sets the price of the bill
     * @param price the price you want to change the price too
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * returns the price of the dishes in the bill
     * @return the price of the dishes in the bill
     */
    public double getPrice() {
        return price;
    }

    /**
     * sets the % of the tip
     * @param tipPercent sets the % of the tip that it is being set to
     */
    public void setTipPercent(int tipPercent){
        this.tipPercent = tipPercent;
    }

    /**
     * returns the % of the tip
     * @return the % of the tip
     */
    public int getTipPercent(){
        return tipPercent;
    }

    /**
     * sets wether the bill was paid in cash or card
     * @param cash boolean value representing if the bill was paid in cash
     */
    public void setCash(boolean cash){
        this.isCash = cash;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    /**
     * returns the table the bill is for
     * @return the tables ID
     */
    public int getTableID() {
        return tableID;
    }

    /**
     * returns weather or not the bill has been paid
     * @return boolean value representing weather or not the bill has been paid
     */
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
