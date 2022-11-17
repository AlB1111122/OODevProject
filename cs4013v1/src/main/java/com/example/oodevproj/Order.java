package com.example.oodevproj;

import java.util.ArrayList;

public class Order{
    private String tableID;
    private Customer customer;
    private ArrayList<Dish> dishes = new ArrayList<Dish>();
    private boolean ready;
    Order(String tableID, Customer customer, ArrayList<Dish> dishes){
        this.customer = customer;
        this.tableID = tableID;
        this.dishes = dishes;
        ready = false;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getTableID() {
        return tableID;
    }

    public void setTableID(String tableID) {
        this.tableID = tableID;
    }

    public void addDish(Dish dish){
        dishes.add(dish);
    }
    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public void setReady() {
        this.ready = true;
    }

    public boolean isReady(){
        return ready;
    }

    @Override
    public String toString() {
        StringBuilder dishStr = new StringBuilder();
        for(Dish d:dishes){
           dishStr.append(d.toString()).append("\n");
        }
        return String.format("ORDER\nTable: %d\n",tableID,dishStr);
    }
}
