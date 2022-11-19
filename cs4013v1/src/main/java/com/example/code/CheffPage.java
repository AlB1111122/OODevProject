package com.example.code;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CheffPage extends Application {
    Restaurant restaurant;
    Kitchen kitchen;
    CheffPage(Restaurant restaurant){
        this.restaurant = restaurant;
        this.kitchen = restaurant.getKitchen();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Label WaitingLabel = new Label("Waiting Orders");
        WaitingLabel.setAlignment(Pos.CENTER);
        ListView<String> waitingList = new ListView<>();
        ObservableList<String> waitDish = FXCollections.observableArrayList (kitchen.getWatingDishString());
        waitingList.setItems(waitDish);
        waitingList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        Pane waitingListPane = new Pane(waitingList);
        waitingListPane.setPrefSize(720,400);
        Scene pageBase = new Scene(waitingListPane,1500,700);
        stage.setScene(pageBase);
        stage.show();
    }
}
