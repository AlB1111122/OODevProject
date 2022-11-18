package com.example.oodevproj;

import com.example.oodevproj.*;

public class TestKitchen {

    static Kitchen k = new Kitchen();
    static Customer c = new Customer("aa",2342);
    static Dish d1 = new Dish(3);
    static Dish d2 = new Dish(5,"extra scauce");
    static Dish d3 = new Dish(6);
    static Order o = new Order(1,c);

    public static void main(String[] args){
        o.addDish(d1);
        o.addDish(d2);
        o.addDish(d3);
        k.addOrder(o);

        System.out.println("waiting");
        for(Dish d:k.getWatingDish()) {
            System.out.println(d.toKitchenString());
        }

        k.setCooking(1);
        k.setCooking(1);
        k.setCooking(1);

        System.out.println("waiting");
        for(Dish d:k.getWatingDish()) {
            System.out.println(d.toKitchenString());
        }

        System.out.println("cooking");
        for(Dish d:k.getCookingDishes()) {
            System.out.println(d.toKitchenString());
        }

        k.setDishReady(3);

        k.getReadyOrders();

        k.setDishReady(1);
        k.setDishReady(1);
        System.out.println("ready");
        for(Dish d:k.getReadyDishes()) {
            System.out.println(d.toKitchenString());
        }

        System.out.println("order");
        for(Order o:k.getReadyOrders()) {
            System.out.println(o.toString());
        }
    }
}
