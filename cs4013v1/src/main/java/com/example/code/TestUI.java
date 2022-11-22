package com.example.code;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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
        Waiter w = new Waiter("alex",123345,"password");
        Cheff c = new Cheff("bee",1233455,"password");
        rL.addEmployee(c);
        rL.addEmployee(w);

        ArrayList<Dish> orderDishes = new ArrayList<>();
        Dish d1 = new Dish(1,"1");
        orderDishes.add(d1);
        Dish d2 = new Dish(3,"2");
        orderDishes.add(d2);

        ArrayList<Dish> orderDishes2 = new ArrayList<>();
        Dish d3 = new Dish(6,"3");
        orderDishes2.add(d3);
        Dish d4 = new Dish(9,"4");
        orderDishes2.add(d4);

        ArrayList<Dish> orderDishes3 = new ArrayList<>();
        Dish d5 = new Dish(15,"5");
        orderDishes3.add(d5);
        Dish d6 = new Dish(11,"6");
        orderDishes3.add(d6);

        Kitchen k = rL.getKitchen();

        rL.getKitchen().addOrder(rL.makeOrder(1,orderDishes));
        rL.getKitchen().addOrder(rL.makeOrder(2,orderDishes2));
        rL.getKitchen().addOrder(rL.makeOrder(2,orderDishes3));
        k.setCooking(0);
        k.setCooking(0);
        k.setCooking(0);
        k.setCooking(0);
        k.setCooking(0);
        k.setCooking(0);
        k.setDishReady(0);
        k.setDishReady(0);
        k.setDishReady(0);
        k.setDishReady(0);
        EmployeeUI e = new EmployeeUI();
        e.setYum(y);
        e.start(primaryStage);
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



        y.addResturaunt("Limerick");
        Restaurant rL = y.getResturaunt("Limerick");
        rL.addTable(4);
        rL.addTable(4);
        ArrayList<Dish> orderDishes = new ArrayList<>();
        Dish d1 = new Dish(1,"1");
        orderDishes.add(d1);
        Dish d2 = new Dish(3,"2");
        orderDishes.add(d2);

        ArrayList<Dish> orderDishes2 = new ArrayList<>();
        Dish d3 = new Dish(6,"3");
        orderDishes2.add(d3);
        Dish d4 = new Dish(9,"4");
        orderDishes2.add(d4);

        ArrayList<Dish> orderDishes3 = new ArrayList<>();
        Dish d5 = new Dish(15,"5");
        orderDishes3.add(d5);
        Dish d6 = new Dish(11,"6");
        orderDishes3.add(d6);


        CheffPage cheff = new CheffPage();
        cheff.setRestaurant(rL);
        rL.getKitchen().addOrder(rL.makeOrder(1,orderDishes));
        rL.getKitchen().addOrder(rL.makeOrder(2,orderDishes2));
        cheff.start(primaryStage);
        rL.getKitchen().addOrder(rL.makeOrder(2,orderDishes3));
         */
}
