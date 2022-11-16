package com.example.oodevproj;

import java.util.ArrayList;

public class Yum{
    private static int numberOfRestaurants;
    private static ArrayList<Restaurant> Restaurants;

    Yum(){
        Restaurant newRest = new Restaurant(numberOfRestaurants + 1);
        numberOfRestaurants++;
    }
}
