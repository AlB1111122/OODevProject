package com.example.cs4013v1;

import com.example.oodevproj.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CheffPage extends Application {
    Restaurant restaurant;
    Kitchen kitchen;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Cheff page");
        restaurant = new Restaurant(1,"test");
        Dish d1 = new Dish(3);
        Customer c = new Customer("ban",78296653);
        Order o = new Order("2",c);
        o.addDish(d1);
        kitchen.addOrder(o);


        ListView<String> waitingList = new ListView<>();
        ObservableList<String> waitDish = FXCollections.observableArrayList (kitchen.getWatingDishString());
        waitingList.setItems(waitDish);
        waitingList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        Pane waitingListPane = new Pane(waitingList);
        waitingListPane.setPrefSize(400,350);
        Scene pageBase = new Scene(waitingListPane,1000,500);
        stage.setScene(pageBase);
        stage.show();
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        kitchen = restaurant.getKitchen();
    }
}
