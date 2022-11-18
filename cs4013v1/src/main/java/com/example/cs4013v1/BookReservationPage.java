package com.example.cs4013v1;

import com.example.oodevproj.Restaurant;
import com.example.oodevproj.calender.ReservationDate;
import com.example.oodevproj.calender.ReservationTime;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class BookReservationPage extends Application {
    com.example.oodevproj.Restaurant restaurant;
    TextField numPeopleIn = new TextField();
    TextField dayIn = new TextField();
    TextField timeIn = new TextField();
    TextField nameIn = new TextField();
    TextField phoneNumerIn = new TextField();
    Label dateTakenInfo = new Label("");
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Booking page");
        GridPane grid = new GridPane();
        grid.setVgap(1.5);
        grid.setAlignment(Pos.TOP_CENTER);

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

        Button book = new Button("Book now!");
        book.setPrefSize(300,20);
        grid.add(book,0,5);


        dateTakenInfo.setTextFill(Color.color(1, 0, 0));
        dateTakenInfo.setAlignment(Pos.BOTTOM_CENTER);
        FlowPane base = new FlowPane(grid,dateTakenInfo);
        base.setAlignment(Pos.TOP_CENTER);

        book.setOnAction(new ReservationController());

        Scene pageBase = new Scene(base,620,183);
        stage.setScene(pageBase);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
    public void setResturaunt(Restaurant restaurant){
        this.restaurant = restaurant;
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
                dateTakenInfo.setText(restaurant.addReservations(noP,date,time,phNo,name));
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
