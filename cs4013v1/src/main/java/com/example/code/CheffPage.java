package com.example.code;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CheffPage extends Application {
    Restaurant restaurant = new Restaurant(0,"test");
    Kitchen kitchen = new Kitchen();

    public static void main(String[] args) {
        launch();
    }

    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
        this.kitchen = restaurant.getKitchen();
    }

    @Override
    public void start(Stage stage) {

        //waitng list pane
        //waitng list: make waiting list label
        Label waitingLabel = new Label("Waiting Orders");
        waitingLabel.setAlignment(Pos.CENTER);
        waitingLabel.setPrefSize(300,25);
        waitingLabel.setBackground(Background.fill(Color.BLACK));
        waitingLabel.setTextFill(Color.WHITE);

        //waitng list: make waiting list
        ListView<String> waitingList = new ListView<>();
        waitingList.setPrefSize(300,648.5);
        waitingList.setStyle("-fx-border-color: black; -fx-border-width: 2");
        waitingList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        ObservableList<String> waitDish = FXCollections.observableArrayList (kitchen.getWatingDishString());
        waitingList.setItems(waitDish);

        //waitng list: make refresh button
        Button refreshWL = new Button("Refresh");
        refreshWL.setAlignment(Pos.CENTER);
        refreshWL.setPrefSize(150,25);
        //waitng list: make refresh button
        Button setWaitngtoCooking = new Button("Start cooking selected");
        setWaitngtoCooking.setAlignment(Pos.CENTER);
        setWaitngtoCooking.setPrefSize(150,25);

        GridPane waitLButonBar = new GridPane();
        waitLButonBar.setPrefSize(300,25);
        waitLButonBar.add(refreshWL,0,0);
        waitLButonBar.add(setWaitngtoCooking,1,0);
        //make button bar

        //waiting list: make pane
        FlowPane waitingListPane = new FlowPane(waitingLabel,waitingList,waitLButonBar);
        waitingListPane.setOrientation(Orientation.VERTICAL);
        waitingListPane.setPrefSize(280,700);

        //Event controll
        //waitlist buttons
        refreshWL.setOnAction(actionEvent -> {
            waitingList.setItems(FXCollections.observableArrayList (kitchen.getWatingDishString()));
        });

        Scene pageBase = new Scene(waitingListPane,1500,700);
        stage.setScene(pageBase);
        stage.show();
    }
}
