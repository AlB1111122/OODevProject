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
    private String[] dishes = {"BBQ wings","Spring rolls","Nachos","Bruschetta",
            "Peperoni pizza","Margherita pizza","Cheese burger with lettuce and tomato","Vegetable soup","Carbonara","Steak served with roast vegtables",
    "Chips","Mashed potato","Steamed vegetables","Soda bread and butter",
    "Vanilla ice cream","Chocolate cake","Apple pie with whipped cream",
            "Coke","Sprite","Club orange","Rinforzo","Guinness","Hiniken"};
    private double[] dishesPrice = {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3};
    private String dishName;
    private double price;
    private boolean ready;

    private String notes;


    Dish(int selection){//reset to not be public later for testing purposes
        dishName = dishes[selection];
        price = dishesPrice[selection];
        ready = false;
    }

    Dish(int selection, String notes){
        dishName = dishes[selection];
        price = dishesPrice[selection];
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
