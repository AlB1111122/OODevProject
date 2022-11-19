package com.example.code;

import javafx.application.Application;
import javafx.stage.Stage;

public class WaiterPage extends Application {

    Restaurant restaurant;

    WaiterPage(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
