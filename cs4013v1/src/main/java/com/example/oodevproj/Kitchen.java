package com.example.oodevproj;

import java.util.ArrayList;

public class Kitchen {
    private Cheff cheff;
    private Order cooking;
    private ArrayList<Order> watingOrder = new ArrayList<>();
    private ArrayList<Order> readyOrders = new ArrayList<>();

    Kitchen(Cheff cheff){
        this.cheff = cheff;
    }

    public Cheff getCheff() {
        return cheff;
    }

    public Order getCooking() {
        return cooking;
    }

    public void setCooking(int selection) throws RuntimeException{
        if(cooking == null) {
            cooking = watingOrder.get(selection - 1);
            watingOrder.remove(watingOrder.get(selection - 1));
        }
        throw new RuntimeException("You must finnish cooking the last order to start a new one");
    }

    public void setCookingReady(){
        readyOrders.add(cooking);
        cooking = null;
    }

    public ArrayList<Order> getReadyOrders() {
        return readyOrders;
    }

    public ArrayList<Order> getWatingOrder() {
        return watingOrder;
    }

    public Order takeReadyOrder(int selection){
        Order order = readyOrders.get(selection - 1);
        readyOrders.remove(order);
        return order;
    }

}
