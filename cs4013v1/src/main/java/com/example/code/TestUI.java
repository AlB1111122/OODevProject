package com.example.code;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class TestUI extends Application {
    Yum y = new Yum();

    public static void main(String[] args) throws IOException {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException{
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

        ArrayList<Dish> orderDishes3 = new ArrayList<>();
        Dish d5 = new Dish(15,"note");
        orderDishes3.add(d5);
        Dish d6 = new Dish(11,"note");
        orderDishes3.add(d6);


        CheffPage cheff = new CheffPage();
        cheff.setRestaurant(rL);
        rL.getKitchen().addOrder(rL.makeOrder(1,orderDishes));
        rL.getKitchen().addOrder(rL.makeOrder(2,orderDishes2));
        cheff.start(primaryStage);
        rL.getKitchen().addOrder(rL.makeOrder(2,orderDishes3));


    }




            /*
        y.addResturaunt("Limerick");
        Restaurant rL = y.getResturaunt("Limerick");
        rL.addTable(3);
        rL.addTable(2);

        y.addResturaunt("Dublin");
        Restaurant rD = y.getResturaunt("Dublin");
        rL.addTable(6);
        rL.addTable(2);

         */
}
