package com.example.cs4013v1;

import com.example.oodevproj.Restaurant;
import com.example.oodevproj.calender.ReservationDate;
import com.example.oodevproj.calender.ReservationTime;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Menu extends Application {
    public void start(Stage stage) throws IOException {
        stage.setTitle("Menu");

        FlowPane base = new FlowPane();
        Scene pageBase = new Scene(base,1000,500);
        stage.setScene(pageBase);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}