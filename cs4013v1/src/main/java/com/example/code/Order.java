package com.example.code;

import com.example.code.calender.ReservationDate;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order{

/*
    * @param orderId    - ID number to represent the order
    * @param tableID    - ID to represent the table the order is assigned to
    * @param dishes     - list of dishes included in the order
    * @param ready      - boolean to determine if dish is ready
    *
    * */

    private final int orderId;
    private int tableID;
    private ArrayList<Dish> dishes = new ArrayList<Dish>();
    private boolean ready;
    private Bill bill;

    /**
     * constructs a new order
     * @param orderId the identifying number for the order
     * @param tableID the identifying number for the table who made the order
     * @param dishes the dishes being ordered
     */
    Order(int orderId, int tableID,ArrayList<Dish> dishes){
        this.orderId = orderId;
        this.tableID = tableID;
        this.dishes = dishes;
        ready = false;
    }

    public int getOrderId() {
        return orderId;
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

    /**
     * returd the dishes in the order
     * @return ArrayList of the dishes in the order
     */
    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    /**
     * checks if each of the dishes in the order are ready and if so sets order to ready and makes a new bill associated wiith the order
     * @return
     */
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
        double price = 0;
        for(Dish d: dishes){
            price = price + d.getPrice();
        }
        bill = new Bill(tableID,dishes,price,new ReservationDate(LocalDate.now().toString()));
        return ready;
    }

    /**
     * returns the bill associates with the order
     * @return bill asociated for this order
     */
    public Bill getBill() {
        return bill;
    }

    /**
     * returns a string to be used internaly by staff
     * @return String representing the order
     */
    public String toKitchenString() {
        if(ready) {
            return String.format("ORDER%d\nTable: %d\nReady",orderId,tableID);
        }else{
            return String.format("ORDER\nTable: %d\nCooking", tableID);
        }
    }
    @Override
    public String toString(){
        StringBuilder dishStr = new StringBuilder();
        for(Dish d:dishes){
            dishStr.append(d.toString()).append("\n");
        }
        return String.format("ORDER\nTable: %d\n%s",tableID,dishStr);
    }
}
