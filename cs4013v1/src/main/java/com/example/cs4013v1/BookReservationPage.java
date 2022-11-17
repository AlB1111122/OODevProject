package com.example.cs4013v1;
import com.example.oodevproj.*;

import com.example.oodevproj.calender.ReservationDate;
import com.example.oodevproj.calender.ReservationTime;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class BookReservationPage extends Application {

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

        book.setOnAction(new ReservationController());

        Scene pageBase = new Scene(base,620,200);
        stage.setScene(pageBase);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

    Restaurant r = new Restaurant(1);
    public class ReservationController implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            int noP = 0;
            try {
                noP = Integer.parseInt(numPeopleIn.getText());
                numPeopleIn.setBackground(null);
            }catch(NumberFormatException ex){
                dateTakenInfo.setText("Please double check the 'number of people' field");
                numPeopleIn.setBackground(Background.fill(Color.color(1, 0, 0)));
            }
            int pNo = 0;
            try {
                pNo = Integer.parseInt(phoneNumerIn.getText());
                numPeopleIn.setBackground(Background.fill(null));
            }catch(NumberFormatException ex){
                dateTakenInfo.setText("Please double check the phone number is correct");
                phoneNumerIn.setBackground(Background.fill(Color.color(1, 0, 0)));
            }
            ReservationDate date = null;
            try{
                date = new ReservationDate(dayIn.getText());
                numPeopleIn.setBackground(Background.fill(null));
            }catch(RuntimeException ex){
                dateTakenInfo.setText(ex.getMessage());
                dayIn.setBackground(Background.fill(Color.color(1, 0, 0)));
            }
            ReservationTime time = null;
            try{
                time = new ReservationTime(timeIn.getText());
                numPeopleIn.setBackground(Background.fill(null));
            }catch(RuntimeException ex){
                dateTakenInfo.setText(ex.getMessage());
                timeIn.setBackground(Background.fill(Color.color(1, 0, 0)));
            }
            if(nameIn.getText().isEmpty()){
                nameIn.setBackground(Background.fill(Color.color(1, 0, 0)));
            }
            numPeopleIn.setBackground(Background.fill(null));
            r.addReservations(noP,date,time,pNo,nameIn.getText());
        }
    }
}
