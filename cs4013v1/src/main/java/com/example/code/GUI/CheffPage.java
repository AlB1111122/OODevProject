package com.example.code.GUI;

import com.example.code.*;
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