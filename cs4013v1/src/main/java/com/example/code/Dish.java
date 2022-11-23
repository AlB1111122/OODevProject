package com.example.code;

public class Dish{

 /*
    * This is the Dish class
    * @param orderId        - ID to represent the dish in the menu
    * @param dishes         - list of Dishes available to eat
    * @param dishesPrice    - list of prices for respective dishes
    * @param dishName       - name of specific dish
    * @param price          -  price of specific dish
    * @param ready          - boolean of dish being ready (true/false)
    * @param notes          - notes for input (allergies, etc.)
    * */

    private int orderId;
    private String dishName;
    private double price;
    private boolean ready;

    private String notes;


    Dish(String name,double price){
        dishName = name;
        this.price = price;
        ready = false;
    }

    Dish(String name,double price, String notes){
        dishName = name;
        this.price = price;
        ready = false;
        this.notes = notes;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getDishName(){
        return dishName;
    }

    public double getPrice() {
        return price;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(){
        ready = true;
    }
    @Override
    public String toString(){
        return String.format("Dish: %s, Price: %.2f",dishName,price);
    }

    public String toKitchenString(){
        return String.format("Order: %d, Dish: %s\n%s ",orderId,dishName,notes);
    }
}
