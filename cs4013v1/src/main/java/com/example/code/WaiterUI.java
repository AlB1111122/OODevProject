package com.example.code;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class WaiterUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Waiter home");



        FlowPane waiterButtons = new FlowPane();
        Scene buttons = new Scene(waiterButtons);
        primaryStage.setScene(buttons);
        primaryStage.show();
    }
}
