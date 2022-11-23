package com.example.code;

import java.util.ArrayList;

public class Kitchen {

 /*
 * Constructs a new kitchen
    * @param watingDishes   - arrayList of dishes waiting to be prepared
    * @param cookingDishes  - arrayList of dishes currently being prepared
    * @param readyDishes    - arrayList of dishes currently ready
    * @param orders         - arrayList of orders
     * */

    private ArrayList<Dish> watingDishes = new ArrayList<>();
    private ArrayList<Dish> cookingDishes = new ArrayList<>();
    private ArrayList<Dish> readyDishes = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Order> deliverdOrders = new ArrayList<>();

    /**
     * returns strings of all the deliverd orders
     * @return ArrayList string of the deliverd orders
     */
    public ArrayList<String> getDeliverdOrdersString() {
        ArrayList<String> ords = new ArrayList<>();
        for(Order o:deliverdOrders){
            ords.add(o.toKitchenString());
        }
        return ords;
    }

    public ArrayList<Order> getDeliverdOrders() {
        return deliverdOrders;
    }

    /**
     * remove a dish from the waiting list and adds it to the cooking list
     * @param selection the index of the selected dish
     */
    public void setCooking(int selection){
        cookingDishes.add(watingDishes.get(selection));
        watingDishes.remove(selection);
    }

    /**
     * remove a dish from the cooking list and set it to ready
     * @param selection the index of the selected dish
     */
    public void setDishReady(int selection){
        Dish d = cookingDishes.get(selection);
        readyDishes.add(d);
        cookingDishes.remove(selection);
        d.setReady();
    }

    /**
     * returnes an arraylist of all the orders
     * @return the orders arrayList
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * adds a new order to the orders list and adds the dishes to the waiting dishes
     * @param order the order to be added
     */
    public void addOrder(Order order){
        watingDishes.addAll(order.getDishes());
        orders.add(order);
    }

    /**
     * returns an  arraylist of the orders that are ready
     * @return arraylist of ready orders
     */
    public ArrayList<Order> getReadyOrders() {
        ArrayList<Order> temp = new ArrayList<>();
        for(Order o:orders){
            if(o.getReady()){
                temp.add(o);
            }
        }
        return temp;
    }

    /**
     * returns the waiting dishes
     * @return an arraylist of the waiting dishes
     */
    public ArrayList<Dish> getWatingDishes() {
        return watingDishes;
    }

    /**
     * returns a list of the strings of the waiting dishes
     * @return arraylist of the waiting dishes
     */
    public ArrayList<String> getWatingDishString() {
        ArrayList<String> displayArr = new ArrayList<>();
        for(Dish d:watingDishes){
            displayArr.add(d.toKitchenString());
        }
        return displayArr;
    }

    /**
     * removes the selected dish from the orders list and adds it to deliverd orders
     * @param selection the index of the selected order
     */
    public void takeReadyOrder(int selection){
        Order order = getReadyOrders().get(selection);
        deliverdOrders.add(order);
        orders.remove(order);
    }

    /**
     * returns the dishes that are currently cooking
     * @return arraylist of cooking dishes
     */
    public ArrayList<Dish> getCookingDishes() {
        return cookingDishes;
    }

    /**
     * returns the list of the strings of the dishes that are currently cooking
     * @return string arraylist of cooking dishes
     */
    public ArrayList<String> getCookingDishString() {
        ArrayList<String> displayArr = new ArrayList<>();
        for(Dish d:cookingDishes){
            displayArr.add(d.toKitchenString());
        }
        return displayArr;
    }

}
