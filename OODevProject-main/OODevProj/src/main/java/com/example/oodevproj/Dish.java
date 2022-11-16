package com.example.oodevproj;

public class Dish{
    private String[] dishes = {"BBQ wings","Spring rolls","Nachos","Bruschetta",
            "Peperoni pizza","Margherita pizza","Cheese burger with lettuce and tomato","Vegetable soup","Carbonara","Steak served with roast vegtables",
    "Chips","Mashed potato","Steamed vegetables","Soda bread and butter",
    "Vanilla ice cream","Chocolate cake","Apple pie with whipped cream",
            "Coke","Sprite","Club orange","Rinforzo","Guinness","Hiniken"};
    private double[] dishesPrice = new double[20];
    private String dishName;
    private double price;
    private boolean ready;

    Dish(int selection){
        dishName = dishes[selection];
        price = dishesPrice[selection];
        ready = false;
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

    public String toString(){
        return String.format("Dish: %s, Price: %.2f",dishName,price);
    }
}
