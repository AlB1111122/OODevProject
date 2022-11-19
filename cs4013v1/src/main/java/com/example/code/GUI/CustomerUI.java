package com.example.code.GUI;
import com.example.code.Customer;
import com.example.code.Restaurant;
import com.example.code.Test;
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
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerUI extends Application{
    private Yum yum;
    private com.example.code.Restaurant restaurant;//reset later
    private TextField numPeopleIn = new TextField();
    private TextField dayIn = new TextField();
    private TextField timeIn = new TextField();
    private TextField nameIn = new TextField();
    private TextField phoneNumerIn = new TextField();
    private Label dateTakenInfo = new Label("");

    private TextField cancellingNameIn = new TextField();
    private TextField cancellingPhoneNumberIn = new TextField();
    private TextField cancellingMessage = new TextField();
    private ObservableList<String> resItems = FXCollections.observableArrayList();
    @Override
    public void start(Stage stage){

        GridPane grid = new GridPane();
        grid.setVgap(1.5);
        grid.setAlignment(Pos.TOP_CENTER);

        FlowPane base = new FlowPane(grid,dateTakenInfo);
        base.setAlignment(Pos.TOP_CENTER);

        Scene bookPage = new Scene(base);

        Label numPeople = new Label("Enter the number of people you are booking for: ");
        numPeople.setPrefSize(300,20);
        grid.add(numPeople,0,0);

        numPeopleIn.setPrefSize(300,20);
        grid.add(numPeopleIn,1,0);

        Label day = new Label("Select a date");
        day.setPrefSize(300,20);
        grid.add(day,0,1);

        dayIn.setPrefSize(300,20);
        grid.add(dayIn,1,1);

        Label time = new Label("Enter the time you wish to book for:");
        time.setPrefSize(300,20);
        grid.add(time,0,2);

        timeIn.setPrefSize(300,20);
        grid.add(timeIn,1,2);

        Label name = new Label("Enter your name:");
        name.setPrefSize(300,20);
        grid.add(name,0,3);

        nameIn.setPrefSize(300,20);
        grid.add(nameIn,1,3);

        Label phoneNumer = new Label("Enter your phone number:");
        phoneNumer.setPrefSize(300,20);
        grid.add(phoneNumer,0,4);

        phoneNumerIn.setPrefSize(300,20);
        grid.add(phoneNumerIn,1,4);

        Button bookBut = new Button("Book now!");
        bookBut.setPrefSize(300,20);
        grid.add(bookBut,0,5);

        Button cancelBut = new Button("Cancel reservation");
        cancelBut.setPrefSize(300,20);
        grid.add(cancelBut,1,5);

        dateTakenInfo.setTextFill(Color.color(1, 0, 0));
        dateTakenInfo.setAlignment(Pos.BOTTOM_CENTER);

        //CancelPage
        GridPane cancelGrid = new GridPane();
        cancelGrid.setVgap(1.5);
        cancelGrid.setAlignment(Pos.TOP_CENTER);

        Label cancelName = new Label("Enter your name:");
        cancelName.setPrefSize(300,20);
        cancelGrid.add(cancelName,0,0);

        cancellingNameIn.setPrefSize(300,20);
        cancelGrid.add(cancellingNameIn,1,0);

        Label cancellingPhoneNumber = new Label("Enter your phone number:");
        cancellingPhoneNumber.setPrefSize(300,20);
        cancelGrid.add(cancellingPhoneNumber,0,1);

        cancellingPhoneNumberIn.setPrefSize(300,20);
        cancelGrid.add(cancellingPhoneNumberIn,1,1);

        Button backToBookPage = new Button("Return to booking page");
        cancelGrid.add(backToBookPage,0,2);

        Button findReservations = new Button("Find my reservation(s)");
        findReservations.setAlignment(Pos.BASELINE_RIGHT);
        cancelGrid.add(findReservations,1,2);

        ListView<String> reservations = new ListView<>();
        reservations.setItems(resItems);

        cancellingMessage.setPrefSize(300,20);

        FlowPane cancelBox = new FlowPane(cancelGrid,reservations,cancellingMessage);
        reservations.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        Scene cancelPage = new Scene(cancelBox,620,183);

        //buttons
        bookBut.setOnAction(new ReservationController());
        cancelBut.setOnAction(e -> stage.setScene(cancelPage));
        findReservations.setOnAction(new findCancelConroller());
        backToBookPage.setOnAction(e -> stage.setScene(bookPage));

        stage.setScene(bookPage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void setYum(Yum yum){
        //for testing
        Test t = new Test();
        this.yum = t.getY();
    }
    public void setResturaunt(Restaurant restaurant){
        this.restaurant = restaurant;
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
                for(Reservation r: restaurant.getReservations()){
                    if(r.getCustomerId().equals(restaurant.getCustomerId(name,phoneNo))){
                        returningReservations.add(r.toString());
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
                dateTakenInfo.setTextFill(Color.BLACK);
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