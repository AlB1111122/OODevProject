package com.example.code;

import java.util.ArrayList;

public class Kitchen {
    private ArrayList<Dish> watingDishes = new ArrayList<>();
    private ArrayList<Dish> cookingDishes = new ArrayList<>();
    private ArrayList<Dish> readyDishes = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    public void setCooking(int selection) throws RuntimeException{
        cookingDishes.add(watingDishes.get(selection));
        watingDishes.remove(selection);
    }

    public void setDishReady(int selection){
        Dish d = cookingDishes.get(selection);
        readyDishes.add(d);
        cookingDishes.remove(selection);
        d.setReady();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order){
        watingDishes.addAll(order.getDishes());
        orders.add(order);
    }

    public ArrayList<Order> getReadyOrders() {
        ArrayList<Order> temp = new ArrayList<>();
        for(Order o:orders){
            if(o.getReady()){
                temp.add(o);
            }
        }
        return temp;
    }

    public ArrayList<Dish> getWatingDishes() {
        return watingDishes;
    }

    public ArrayList<String> getWatingDishString() {
        ArrayList<String> displayArr = new ArrayList<>();
        for(Dish d:watingDishes){
            displayArr.add(d.toKitchenString());
        }
        return displayArr;
    }

    public void takeReadyOrder(int selection){
        Order order = getReadyOrders().get(selection);
        orders.remove(order);
    }

    public ArrayList<Dish> getCookingDishes() {
        return cookingDishes;
    }

    public ArrayList<String> getCookingDishString() {
        ArrayList<String> displayArr = new ArrayList<>();
        for(Dish d:cookingDishes){
            displayArr.add(d.toKitchenString());
        }
        return displayArr;
    }

}
