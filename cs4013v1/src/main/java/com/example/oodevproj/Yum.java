package com.example.oodevproj;

import java.io.IOException;
import java.util.ArrayList;

public class Yum{
    private static int numberOfRestaurants;
    private static ArrayList<Restaurant> Restaurants;

    Yum(){

    }
    public void addResturaunt(String location){
        Restaurant newRest = new Restaurant(numberOfRestaurants + 1,location);
        numberOfRestaurants++;
    }

    public static ArrayList<Restaurant> getRestaurants() {
        return Restaurants;
    }

    public static int getNumberOfRestaurants() {
        return numberOfRestaurants;
    }
    public Restaurant getResturaunt(String location)throws IOException{
        for(Restaurant r:Restaurants){
            if(r.getLocation().equals(location)){
                return r;
            }
        }
        throw new IOException("resturaunt does not exist");
    }
}
