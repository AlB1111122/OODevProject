package com.example.oodevproj;

import java.util.ArrayList;

public class Order{
    private int orderId;
    private int tableID;
    private Customer customer;
    private ArrayList<Dish> dishes = new ArrayList<Dish>();
    private boolean ready;
    Order(int tableID, Customer customer){//public for testing reset later
        this.customer = customer;
        this.tableID = tableID;
        ready = false;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public void addDish(Dish dish){
        dishes.add(dish);
        dish.setOrderId(orderId);
    }
    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public boolean getReady() {
        if (!ready) {
            for (Dish d : dishes) {
                if (!d.isReady()) {
                    ready = false;
                    break;
                }
                ready = true;
            }
        }
        return ready;
    }

    @Override
    public String toString() {
        StringBuilder dishStr = new StringBuilder();
        for(Dish d:dishes){
           dishStr.append(d.toString()).append("\n");
        }
        if(ready) {
            return String.format("ORDER\nTable: %d\nReady", tableID, dishStr);
        }else{
            return String.format("ORDER\nTable: %d\nCooking", tableID, dishStr);
        }
    }
}
