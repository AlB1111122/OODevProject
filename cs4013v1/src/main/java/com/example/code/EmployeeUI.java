package com.example.code;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeUI extends Application {

    private Yum yum = new Yum();
    private Restaurant restaurant;
    private Employee signedIn;
    public static void main(String[] args) {
        launch(args);
    }

    public void setYum(Yum yum){
        this.yum = yum;
    }
    @Override
    public void start(Stage primaryStage) {
    
    /*Start page
        * Employee sign in
        *
        * */
        primaryStage.setTitle("Employee sign in");

        Label signInLabel = new Label("Sign in");
        signInLabel.setAlignment(Pos.CENTER);
        signInLabel.setPrefSize(350,25);
        Pane p = new Pane(signInLabel);
        
        /*Sign in ID + Input*/
        Label nameLabel = new Label("Employee ID:");
        nameLabel.setPrefSize(150,25);
        nameLabel.setAlignment(Pos.CENTER_LEFT);
     
        /*Password + Input*/
        Label passwordLabel = new Label("Employee password");
        passwordLabel.setPrefSize(150,25);
        passwordLabel.setAlignment(Pos.CENTER_LEFT);

        /*Location + Input*/
        Label locationLabel = new Label("Enter location");
        locationLabel.setPrefSize(150,25);
        locationLabel.setAlignment(Pos.CENTER_LEFT);

        ComboBox<String> location = new ComboBox<>();
        location.getItems().addAll(yum.getRestrauntLocations());
        location.setVisibleRowCount(5);
        location.setVisible(true);
        location.setPrefSize(200,20);

        GridPane inputGrid = new GridPane();
        inputGrid.setVgap(5);
        inputGrid.setAlignment(Pos.CENTER);

        inputGrid.add(nameLabel,0,0);
        inputGrid.add(passwordLabel,0,1);

        TextField IdIn = new TextField();
        TextField passwordIn = new TextField();
        inputGrid.add(IdIn,1,0);
        IdIn.setPrefSize(200,25);
        inputGrid.add(passwordIn,1,1);
        passwordIn.setPrefSize(200,25);

        inputGrid.add(locationLabel,0,2);
        inputGrid.add(location,1,2);

        Button signInBut = new Button("Sign In");
        signInBut.setPrefSize(200,25);
        signInBut.setAlignment(Pos.CENTER);
        inputGrid.add(signInBut,1,3);

        VBox signInPane = new VBox(p,inputGrid);
        signInPane.setPrefSize(385,155);
        signInPane.setLayoutY(10);
        signInPane.setBackground(Background.fill(Color.WHITE));

        
        //Button actions
        signInBut.setOnAction(actionEvent -> {
         /*Checks if input is empty*/
            if(!IdIn.getText().isEmpty() && !passwordIn.getText().isEmpty()){
                try {
                    restaurant = yum.getResturaunt(location.getValue());
                } catch (IOException e) {
                    signInLabel.setText("No location selected");
                }
              /*Checks if sign-in is valid*/
                for(Employee emp:restaurant.getEmployees()){
                    if(emp.getID().equals(IdIn.getText())){
                        if(emp.getPassword().equals(passwordIn.getText())){
                            signedIn = emp;
                            break;
                        }else{
                            signInLabel.setText("Password incorrect");
                            return;
                        }
                    }
                }
                signInLabel.setText("No employees with this ID at this location");
            }
            else{
                signInLabel.setText("Please enter your ID and password");
                return;
            }
            /*Checks the type of employee and runs the UI accordingly
            * @see CheffPage
            * @see WaiterUI
            * */
            if(signedIn != null) {
                if (signedIn instanceof Cheff) {
                    CheffPage cheffPage = new CheffPage();
                    cheffPage.setRestaurant(restaurant);
                    cheffPage.start(primaryStage);
                } else {
                    WaiterUI waiterUI = new WaiterUI();
                    waiterUI.setRestaurant(restaurant);
                    waiterUI.start(primaryStage);
                }
            }
        });

        Scene pageBase = new Scene(signInPane);

        primaryStage.setScene(pageBase);
        primaryStage.show();
    }
}
