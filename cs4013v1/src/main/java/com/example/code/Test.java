package com.example.code;

import com.example.code.calender.ReservationDate;
import com.example.code.calender.ReservationTime;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
    static Yum y = new Yum();
    public static void main(String[] args) throws IOException {
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
    }

    public static void test() throws IOException {


    }

            /*
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

}
