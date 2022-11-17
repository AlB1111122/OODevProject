package com.example.cs4013v1;

import com.example.oodevproj.Restaurant;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class CheffPage extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Restaurant restaurant;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Cheff page");

        //ListView<String> list = new ListView<String>();
       // ObservableList<String> items =FXCollections.observableArrayList (restaurant.);
        //list.setItems(items);

        FlowPane base = new FlowPane();
        Scene pageBase = new Scene(base,1000,500);
        stage.setScene(pageBase);
        stage.show();
    }

    public void setR(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
