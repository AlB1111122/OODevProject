package com.example.code;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

 /*
    * This page represents the Cheff's activities.
    * (Waiting orders, orders in progress, finished orders)
    *
    *
    * */


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

    Label waitLMessage = new Label("");

    @Override
    public void start(Stage stage) {
        stage.setTitle("Cheff screen");
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

        //make button bar
        GridPane waitLButonBar = new GridPane();
        waitLButonBar.setPrefSize(300,25);
        waitLButonBar.add(refreshWL,0,0);
        waitLButonBar.add(setWaitngtoCooking,1,0);

        //waiting list: make pane
        GridPane waitingListPane = new GridPane();
        waitingListPane.add(waitingLabel,0,0);
        waitingListPane.add(waitingList,0,1);
        waitingListPane.add(waitLButonBar,0,3);
        waitingListPane.setAlignment(Pos.TOP_LEFT);

        //cooking list
        //cooking list: make list label
        Label cookingLabel = new Label("Cooking Orders");
        cookingLabel.setAlignment(Pos.CENTER);
        cookingLabel.setPrefSize(300,25);
        cookingLabel.setBackground(Background.fill(Color.BLACK));
        cookingLabel.setTextFill(Color.WHITE);

        //cooking list:make list
        ListView<String> cookingList = new ListView<>();
        cookingList.setPrefSize(300,648.5);
        cookingList.setStyle("-fx-border-color: black; -fx-border-width: 2");
        cookingList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        ObservableList<String> cookingDish = FXCollections.observableArrayList (kitchen.getCookingDishString());
        cookingList.setItems(cookingDish);

        //cooking list: set button
        Button setDishReadyButton = new Button("Set selected ready");
        setDishReadyButton.setAlignment(Pos.CENTER);
        setDishReadyButton.setPrefSize(300,25);

        //cooking list: make listPane
        FlowPane cookingPane = new FlowPane(cookingLabel,cookingList,setDishReadyButton);
        cookingPane.setAlignment(Pos.TOP_RIGHT);
        cookingPane.setPrefSize(300,700);

        //center pane
        //center pane: make pane
        Pane p = new Pane(waitLMessage);
        Pane centrePane = new Pane(p);
        centrePane.setPrefSize(900,700);

        //Event controll
        refreshWL.setOnAction(actionEvent -> {
            waitingList.setItems(FXCollections.observableArrayList (kitchen.getWatingDishString()));
        });
        setWaitngtoCooking.setOnAction(actionEvent -> {
            try {
                kitchen.setCooking(waitingList.getFocusModel().getFocusedIndex());
                waitingList.setItems(FXCollections.observableArrayList (kitchen.getWatingDishString()));
                cookingList.setItems(FXCollections.observableArrayList (kitchen.getCookingDishString()));
                waitLMessage.setText("Moved");
            }catch(RuntimeException ex){
                waitLMessage.setText(ex.getMessage());
            }
        });
        setDishReadyButton.setOnAction(actionEvent -> {
            kitchen.setDishReady(cookingList.getFocusModel().getFocusedIndex());
            cookingList.setItems(FXCollections.observableArrayList (kitchen.getCookingDishString()));
        });

        GridPane panes = new GridPane();
        panes.setGridLinesVisible(true);
        panes.add(waitingListPane,0,0);
        panes.add(centrePane,1,0);
        panes.add(cookingPane,2,0);

        Scene pageBase = new Scene(panes,1500,700);
        stage.setScene(pageBase);
        stage.show();
    }
}
