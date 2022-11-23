package com.example.code;
import com.example.code.Restaurant;
import com.example.code.Yum;
import com.example.code.calender.Reservation;
import com.example.code.calender.ReservationDate;
import com.example.code.calender.ReservationTime;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerUI extends Application{
    private Yum yum =new Yum();
    private com.example.code.Restaurant restaurant;//reset later
    private TextField numPeopleIn = new TextField();
    private TextField dayIn = new TextField();
    private TextField timeIn = new TextField();
    private TextField nameIn = new TextField();
    private TextField phoneNumerIn = new TextField();
    private Label dateTakenInfo = new Label("");

    private TextField cancellingNameIn = new TextField();
    private TextField cancellingPhoneNumberIn = new TextField();
    private Label cancellingMessage = new Label("");
    private ComboBox<String> location = new ComboBox<>();
    private ObservableList<String> resItems = FXCollections.observableArrayList();
    private  int[] resIds = new int[10];

    public void setRestaurant(Yum yum){
        this.yum = yum;
    }
    @Override
    public void start(Stage stage){
    
     /*
        * This is the start page.
        *
        * */
        
        GridPane grid = new GridPane();
        grid.setVgap(1.5);
        grid.setAlignment(Pos.TOP_CENTER);

        FlowPane base = new FlowPane(grid,dateTakenInfo);
        base.setAlignment(Pos.TOP_CENTER);

        Scene bookPage = new Scene(base,660,210);

        /* Number of customers + Input */
        Label numPeople = new Label("Enter the number of people you are booking for: ");
        numPeople.setPrefSize(300,20);
        grid.add(numPeople,0,0);

        numPeopleIn.setPrefSize(300,20);
        grid.add(numPeopleIn,1,0);
        
        /*Date + Input */
        Label day = new Label("Select a date");
        day.setPrefSize(300,20);
        grid.add(day,0,1);

        dayIn.setPrefSize(300,20);
        grid.add(dayIn,1,1);

        /*Time + Input */
        Label time = new Label("Enter the time you wish to book for:");
        time.setPrefSize(300,20);
        grid.add(time,0,2);

        timeIn.setPrefSize(300,20);
        grid.add(timeIn,1,2);
        
         /*Name + Input*/
        Label name = new Label("Enter your name:");
        name.setPrefSize(300,20);
        grid.add(name,0,3);

        nameIn.setPrefSize(300,20);
        grid.add(nameIn,1,3);

        /*Phone Number + Input */
        Label phoneNumer = new Label("Enter your phone number:");
        phoneNumer.setPrefSize(300,20);
        grid.add(phoneNumer,0,4);

        phoneNumerIn.setPrefSize(300,20);
        grid.add(phoneNumerIn,1,4);

        /*Location + Selection*/
        Label locationLabel = new Label("Select the location:");
        grid.add(locationLabel,0,5);


        location.getItems().addAll(yum.getRestrauntLocations());
        location.setVisibleRowCount(5);
        location.setVisible(true);
        location.setPrefSize(300,20);
        grid.add(location,1,5);
        
        
        /*Book button*/
        Button bookBut = new Button("Book now!");
        bookBut.setPrefSize(300,20);
        grid.add(bookBut,0,6);

        /*Button to cancel page*/
        Button cancelBut = new Button("Cancel reservation");
        cancelBut.setPrefSize(300,20);
        grid.add(cancelBut,1,6);

        dateTakenInfo.setAlignment(Pos.BOTTOM_CENTER);

        //CancelPage
        GridPane cancelGrid = new GridPane();
        cancelGrid.setVgap(1.5);
        cancelGrid.setAlignment(Pos.TOP_CENTER);
        
         /*Name + Input*/
        Label cancelName = new Label("Enter your name:");
        cancelName.setPrefSize(200,20);
        cancelName.setAlignment(Pos.BASELINE_LEFT);
        cancelGrid.add(cancelName,0,0);

        cancellingNameIn.setPrefSize(200,20);
        cancellingNameIn.setAlignment(Pos.BASELINE_LEFT);
        cancelGrid.add(cancellingNameIn,1,0);

         /*Phone Number + Input */
        Label cancellingPhoneNumber = new Label("Enter your phone number:");
        cancellingPhoneNumber.setAlignment(Pos.BASELINE_RIGHT);
        cancellingPhoneNumber.setPrefSize(200,20);
        cancelGrid.add(cancellingPhoneNumber,0,1);

        cancellingPhoneNumberIn.setPrefSize(200,20);
        cancellingPhoneNumber.setAlignment(Pos.BASELINE_LEFT);
        cancelGrid.add(cancellingPhoneNumberIn,1,1);
        
        /*Returns to original booking page*/
        Button backToBookPage = new Button("Return to booking page");
        backToBookPage.setPrefSize(200,20);
        cancelGrid.add(backToBookPage,0,2);

        Button findReservations = new Button("Find my reservation(s)");
        findReservations.setPrefSize(200,20);
        findReservations.setAlignment(Pos.BASELINE_RIGHT);
        cancelGrid.add(findReservations,1,2);

        ListView<String> reservations = new ListView<>();
        reservations.setItems(resItems);
        reservations.setPrefHeight(40);
        cancelGrid.add(reservations,0,3);

        cancellingMessage.setPrefSize(200,20);
        cancellingMessage.setAlignment(Pos.BASELINE_CENTER);

        Button cancelResButton = new Button("Cancel");
        cancelResButton.setPrefSize(200,20);

        FlowPane buttonMessageBox = new FlowPane(cancellingMessage,cancelResButton);
        buttonMessageBox.setVgap(3);
        cancelGrid.add(buttonMessageBox,1,3);
        buttonMessageBox.setAlignment(Pos.CENTER_RIGHT);
        buttonMessageBox.setOrientation(Orientation.VERTICAL);

        reservations.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        Scene cancelPage = new Scene(cancelGrid,490,200);

        //events
        bookBut.setOnAction(new ReservationController());
        cancelBut.setOnAction(e -> stage.setScene(cancelPage));
        findReservations.setOnAction(new findCancelConroller());
        backToBookPage.setOnAction(e -> stage.setScene(bookPage));
        cancelResButton.setOnAction(actionEvent -> {
            if(!(reservations.getFocusModel().getFocusedIndex() < 0)) {
                restaurant.cancelReservation(resIds[reservations.getFocusModel().getFocusedIndex()]);
                cancellingMessage.setText("Appointment canceled");
            }else{
                cancellingMessage.setText("No appointment selected");
            }
        });

        stage.setScene(bookPage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public class findCancelConroller implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent) {
            ArrayList<String> returningReservations = new ArrayList<>();
            String name = "";
            int phoneNo = 0;
            try{
                name = getName();
                phoneNo = getPhoneNo();
                int i = 0;
                for(Reservation r: restaurant.getReservations()){
                    if(r.getCustomerId().equals(restaurant.getCustomerId(name,phoneNo))){
                        returningReservations.add(r.toString());
                        resIds[i] = r.getReservationId();
                        i++;
                    }
                }
            }catch(IOException ex){
                cancellingMessage.setText(ex.getMessage());
            }
            resItems.setAll(returningReservations);
        }

        private String getName()throws IOException{
            String in = cancellingNameIn.getText();
            if(!in.isEmpty() && !(in.matches("[a-zA-Z]"))){
                return in;
            }else{
                cancellingNameIn.setBackground(Background.fill(Color.color(1, 0, 0)));
                throw new IOException("Invalid name");
            }
        }
        private int getPhoneNo()throws IOException{
            String no = cancellingPhoneNumberIn.getText();
            if (!no.isEmpty()) {
                try {
                    return Integer.parseInt(no);
                }catch(NumberFormatException ex){
                    cancellingPhoneNumberIn.setBackground(Background.fill(Color.color(1, 0, 0)));
                    throw new IOException("Invalid phone number");
                }
            }else{
                cancellingPhoneNumberIn.setBackground(Background.fill(Color.color(1, 0, 0)));
                throw new IOException("Invalid number of people");
            }
        }

    }

    public class ReservationController implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            int noP = 0;
            ReservationDate date = null;
            ReservationTime time = null;
            String name = null;
            int phNo = 0;
            try {
                restaurant = yum.getResturaunt(location.getValue());
                noP = numPeople();
                numPeopleIn.setBackground(Background.fill(Color.WHITE));
                date = getDate();
                dayIn.setBackground(Background.fill(Color.WHITE));
                time = getTime();
                timeIn.setBackground(Background.fill(Color.WHITE));
                name = getName();
                nameIn.setBackground(Background.fill(Color.WHITE));
                phNo = getPhoneNo();
                phoneNumerIn.setBackground(Background.fill(Color.WHITE));
                dateTakenInfo.setText(restaurant.addReservation(noP,date,time,phNo,name));
            }catch(IOException ex){
                dateTakenInfo.setText(ex.getMessage());
            }
        }

        private int numPeople()throws IOException{
            String no = numPeopleIn.getText();
            if (!no.isEmpty()) {
                try {
                    return Integer.parseInt(no);
                }catch(NumberFormatException ex){
                    numPeopleIn.setBackground(Background.fill(Color.color(1, 0, 0)));
                    throw new IOException("Invalid number of people");
                }
            }else{
                numPeopleIn.setBackground(Background.fill(Color.color(1, 0, 0)));
                throw new IOException("Invalid number of people");
            }
        }

        private ReservationDate getDate()throws IOException{
            if (!dayIn.getText().isEmpty()) {
                try {
                    return new ReservationDate(dayIn.getText());
                } catch (RuntimeException ex) {
                    dayIn.setBackground(Background.fill(Color.color(1, 0, 0)));
                    throw new IOException("Invalid date");
                }
            }else{
                dayIn.setBackground(Background.fill(Color.color(1, 0, 0)));
                throw new IOException("Invalid date");
            }
        }

        private ReservationTime getTime()throws IOException{
            if (!timeIn.getText().isEmpty()) {
                try {
                    return new ReservationTime(timeIn.getText());
                } catch (RuntimeException ex) {
                    timeIn.setBackground(Background.fill(Color.color(1, 0, 0)));
                    throw new IOException("Invalid time");
                }
            }else{
                timeIn.setBackground(Background.fill(Color.color(1, 0, 0)));
                throw new IOException("Invalid time");
            }
        }

        private String getName()throws IOException{
            String in = nameIn.getText();
            if(!in.isEmpty() && !(in.matches("[a-zA-Z]"))){
                return in;
            }else{
                nameIn.setBackground(Background.fill(Color.color(1, 0, 0)));
                throw new IOException("Invalid name");
            }
        }

        private int getPhoneNo()throws IOException{
            String no = phoneNumerIn.getText();
            if (!no.isEmpty()) {
                try {
                    return Integer.parseInt(no);
                }catch(NumberFormatException ex){
                    phoneNumerIn.setBackground(Background.fill(Color.color(1, 0, 0)));
                    throw new IOException("Invalid phone number");
                }
            }else{
                phoneNumerIn.setBackground(Background.fill(Color.color(1, 0, 0)));
                throw new IOException("Invalid number of people");
            }
        }
    }
}
