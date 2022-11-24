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

    /**
     * creates a new dish
     * @param name the name of the dish
     * @param  price of the dish
     */
    Dish(String name,double price){
        dishName = name;
        this.price = price;
        ready = false;
    }
    /**
     * creates a new dish with nots for the cheffs
     * @param name the name of the dish
     * @param  price of the dish
     * @param notes notes on how the dish should be prepared
     */
    Dish(String name,double price, String notes){
        dishName = name;
        this.price = price;
        ready = false;
        this.notes = notes;
    }

    /**
     * seats the orderID the dish is asociated with
     * @param orderId identifier order
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getDishName(){
        return dishName;
    }

    /**
     * returns the price of the dish
     * @return double representing the dishes price
     */
    public double getPrice() {
        return price;
    }

    /**
     * resturns a boolean representing if the recipie is cooked
     * @return boolean value of ready
     */
    public boolean isReady() {
        return ready;
    }

    /**
     * sets the dish to ready
     */
    public void setReady(){
        ready = true;
    }
    @Override
    public String toString(){
        return String.format("Dish: %s, Price: %.2f",dishName,price);
    }

    /**
     * returns a string with additional information to be used for the staff
     * @return string giving important information for the staff to know
     */
    public String toKitchenString(){
        return String.format("Order: %d, Dish: %s\n%s ",orderId,dishName,notes);
    }
}
