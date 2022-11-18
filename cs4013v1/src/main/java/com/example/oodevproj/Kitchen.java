package com.example.oodevproj;

import java.util.ArrayList;

public class Kitchen {
    private Cheff cheff;
    private ArrayList<Dish> watingDish = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    public void setCooking(int selection) throws RuntimeException{
        if(cheff.getCookingDish() == null) {
            cheff.setCookingDish(watingDish.get(selection - 1));
            watingDish.remove(watingDish.get(selection - 1));
        }
        throw new RuntimeException("You must finnish cooking the last order to start a new one");
    }

    public void setDishReady(){
        cheff.setCookingDishReady();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order){
        watingDish.addAll(order.getDishes());
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

    public ArrayList<Dish> getWatingDish() {
        return watingDish;
    }

    public ArrayList<String> getWatingDishString() {
        ArrayList<String> displayArr = new ArrayList<>();
        for(Dish d:watingDish){
            displayArr.add(d.toKitchenString());
        }
        return displayArr;
    }

    public Order takeReadyOrder(int selection){
        Order order = orders.get(selection - 1);
        orders.remove(order);
        return order;
    }

}
