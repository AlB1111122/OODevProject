package com.example.code;

import java.util.ArrayList;

public class MenuCatagory {
    private String catagoryName;
    private ArrayList<String> dishNames = new ArrayList<>();
    private ArrayList<Double> dishPrices = new ArrayList<>();
    private ArrayList<String> dishesString = new ArrayList<>();

    /**
     * construcs a new menu catagory with only a specified name
     * @param catagoryName the name of the menu catagory
     */
    MenuCatagory(String catagoryName){
        this.catagoryName = catagoryName;
    }

    /**
     * constructs a menu catagory with a specified name and list of dishes+prices
     * @param catagoryName the name of the menu catagory
     * @param dishes the list of dishes and prices
     */
    MenuCatagory(String catagoryName, String[][] dishes){
        this.catagoryName = catagoryName;
        for (String[] dish : dishes) {
            dishNames.add(dish[0]);
            dishPrices.add(Double.parseDouble(dish[1]));
            dishesString.add(dish[0] + " " +dish[1]);
        }
    }

    /**
     * returns the name of the catagory
     * @return String of the catagory name
     */
    public String getCatagoryName() {
        return catagoryName;
    }

    /**
     * returns a list of the prices of the dishes
     * @return returns arraylist of integers of the dishes price
     */
    public ArrayList<Double> getDishPrices() {
        return dishPrices;
    }

    /**
     * returns a list of the dishes names
     * @return the arrayList string of dish names
     */
    public ArrayList<String> getDishNames() {
        return dishNames;
    }

    /**
     * returns the name of the dish at the selected index
     * @param selection the index of the selected dish
     * @return the name of the dish at the selected index
     */
    public String getDishName(int selection){
        return dishNames.get(selection);
    }

    /**
     * returns the price of the dish at the selected index
     * @param selection the index of the selected dish
     * @return the price of the dish at the selected index
     */
    public Double getDishPrice(int selection){
        return dishPrices.get(selection);
    }

    /**
     * returns a string arraylist of the catagory
     * @return a list of strings of the items in the catagory
     */
    public ArrayList<String> getCatagoryString(){
        return dishesString;
    }
}
