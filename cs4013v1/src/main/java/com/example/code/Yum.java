package com.example.code;

import java.io.IOException;
import java.util.ArrayList;

public class Yum{
    private static int numberOfRestaurants;
    private static ArrayList<Restaurant> restaurants = new ArrayList<>();

    public void addResturaunt(String location){
        Restaurant newRest = new Restaurant(numberOfRestaurants + 1,location);
        numberOfRestaurants++;
        restaurants.add(newRest);
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public ArrayList<String> getRestrauntLocations(){
        ArrayList<String> locs = new ArrayList<>();
        for(Restaurant r:restaurants){
            locs.add(r.getLocation());
        }
        return locs;
    }

    public static int getNumberOfRestaurants() {
        return numberOfRestaurants;
    }
    public Restaurant getResturaunt(String location)throws IOException{
        for(Restaurant r:restaurants){
            if(r.getLocation().compareTo(location) == 0){
                return r;
            }
        }
        throw new IOException("resturaunt does not exist");
    }

    public Restaurant getResturaunt(int selection){
        return restaurants.get(selection);
    }
}

            /*
                    y.addResturaunt("Limerick");
        Restaurant rL = y.getResturaunt("Limerick");
        rL.addTable(4);
        rL.addTable(4);
        ArrayList<Dish> orderDishes = new ArrayList<>();
        Dish d1 = new Dish(1,"no sauce");
        orderDishes.add(d1);
        Dish d2 = new Dish(3);
        orderDishes.add(d2);

        ArrayList<Dish> orderDishes2 = new ArrayList<>();
        Dish d3 = new Dish(6,"no sauce");
        orderDishes2.add(d3);
        Dish d4 = new Dish(9);
        orderDishes2.add(d4);

        CheffPage cheff = new CheffPage();
        cheff.setRestaurant(rL);
        rL.getKitchen().addOrder(rL.makeOrder(1,orderDishes));
        rL.getKitchen().addOrder(rL.makeOrder(2,orderDishes2));
        for(Dish d:rL.getKitchen().getWatingDishes()) {
            System.out.println(d.toKitchenString());
        }
        System.out.println(rL.getKitchen().getWatingDishString());





        y.addResturaunt("Limerick");
        rL.addTable(3);
        rL.addTable(2);


        Restaurant rD = y.getResturaunt("Dublin");
        y.addResturaunt("Dublin");
        rL.addTable(6);
        rL.addTable(2);
        CustomerUI ui = new CustomerUI(y);

        ui.start(s);
         */
