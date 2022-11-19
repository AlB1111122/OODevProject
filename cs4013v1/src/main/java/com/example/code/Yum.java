package com.example.code;

import java.io.IOException;
import java.util.ArrayList;

public class Yum{
    private static int numberOfRestaurants;
    private static ArrayList<Restaurant> restaurants = new ArrayList<>();

    public Yum(){

    }
    public void addResturaunt(String location){
        Restaurant newRest = new Restaurant(numberOfRestaurants + 1,location);
        numberOfRestaurants++;
        restaurants.add(newRest);
    }

    public static ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public ArrayList<String> getRestrauntLocations(){
        ArrayList<String> locs= new ArrayList<>();
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
}
