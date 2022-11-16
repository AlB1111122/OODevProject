package com.example.oodevproj;

public class Dish{
    private String[] dishes = {"BBQ wings","Spring rolls","Nachos","Bruschetta",
            "Peperoni pizza","Margherita pizza","Cheese burger with lettuce and tomato","Vegetable soup","Carbonara","Steak served with roast vegtables",
    "Chips","Mashed potato","Steamed vegetables","Soda bread and butter",
    "Vanilla ice cream","Chocolate cake","Apple pie with whipped cream",
            "Coke","Sprite","Club orange","Rinforzo","Guinness","Hiniken"};
    private double[] dishesPrice = {5.50,4.00,6,4.25,
                                12.20,10.50,8.80,7.50,13.05,
                                3.60,3.00,2.50,4.20,
                                5.50,5.40,5.40,
                                1.80,1.60,1.70,3.10,2.90,1.50};
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
