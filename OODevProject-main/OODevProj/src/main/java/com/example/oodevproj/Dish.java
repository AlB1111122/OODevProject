package com.example.oodevproj;

public class Dish{
    private String[] dishes = new String[20];
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
