package com.example.code;

import com.example.code.calender.ReservationDate;
import com.example.code.calender.ReservationTime;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class WaiterUI extends Application {
    Restaurant restaurant;
    Kitchen kitchen;

    private TextField numPeopleIn = new TextField();
    private TextField dayIn = new TextField();
    private TextField timeIn = new TextField();
    private TextField nameIn = new TextField();
    private TextField phoneNumerIn = new TextField();
    private TextField tipIn = new TextField();
    private Label dateTakenInfo = new Label("");
    public static void main(String[] args) {
        launch(args);
    }

    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
        this.kitchen = restaurant.getKitchen();
    }
    @Override
    public void start(Stage primaryStage) {
        //waiter home scene
        primaryStage.setTitle("Waiter home");
        //buttons
        Button takeWalkInBut = new Button("Take walk in");
        takeWalkInBut.setPrefSize(300,25);
        takeWalkInBut.setAlignment(Pos.TOP_CENTER);

        Button takeOrderBut = new Button("Take order");
        takeOrderBut.setAlignment(Pos.CENTER);
        takeOrderBut.setPrefSize(300,25);

        Button takePaymentBut = new Button("Take payment");
        takePaymentBut.setAlignment(Pos.BOTTOM_CENTER);
        takePaymentBut.setPrefSize(300,25);

        ArrayList<String> redO = new ArrayList<>();
        for(Order o: kitchen.getReadyOrders()){
            redO.add(o.toKitchenString());
        }
        ObservableList<String> ready = FXCollections.observableArrayList(redO);

        ListView<String> readyOrders = new ListView<>(ready);
        readyOrders.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        readyOrders.setItems(ready);
        readyOrders.setPrefSize(300,400);

        Label reayOrdersLabel = new Label("Orders to be deliverd");
        reayOrdersLabel.setAlignment(Pos.CENTER);
        reayOrdersLabel.setPrefSize(300,25);
        reayOrdersLabel.setBackground(Background.fill(Color.BLACK));
        reayOrdersLabel.setTextFill(Color.WHITE);

        Button deliverOrderBut = new Button("Set order deliverd");
        deliverOrderBut.setAlignment(Pos.CENTER);
        deliverOrderBut.setPrefSize(150,25);

        Button refeshOrderBut = new Button("Refresh orders");
        refeshOrderBut.setAlignment(Pos.CENTER);
        refeshOrderBut.setPrefSize(150,25);

        GridPane butGrid = new GridPane();
        butGrid.add(deliverOrderBut,0,0);
        butGrid.add(refeshOrderBut,1,0);

        //ready order list: make listPane
        FlowPane readyOrderPane = new FlowPane(reayOrdersLabel,readyOrders,butGrid);
        readyOrderPane.setAlignment(Pos.BOTTOM_CENTER);
        readyOrderPane.setPrefSize(300,470);

        VBox waiterButtons = new VBox(takeWalkInBut,takeOrderBut,takePaymentBut,readyOrderPane);
        //waiterButtons.setOrientation(Orientation.VERTICAL);
        waiterButtons.setSpacing(10);
        waiterButtons.setPrefSize(300,560);
        Pane p = new Pane(waiterButtons);
        Scene home = new Scene(p);

        //teake walk in scene
        GridPane grid = new GridPane();
        grid.setVgap(1.5);
        grid.setAlignment(Pos.TOP_CENTER);

        dateTakenInfo.setAlignment(Pos.CENTER);

        FlowPane base = new FlowPane(grid,dateTakenInfo);
        base.setOrientation(Orientation.VERTICAL);
        base.setAlignment(Pos.TOP_CENTER);

        Scene takeWalkInScene = new Scene(base,675,130);

        Label numPeople = new Label("Enter the number of people you are booking for: ");
        numPeople.setPrefSize(300,20);
        grid.add(numPeople,0,0);

        numPeopleIn.setPrefSize(300,20);
        grid.add(numPeopleIn,1,0);

        Label name = new Label("Enter your name:");
        name.setPrefSize(300,20);
        grid.add(name,0,1);

        nameIn.setPrefSize(300,20);
        grid.add(nameIn,1,1);

        Label phoneNumer = new Label("Enter your phone number:");
        phoneNumer.setPrefSize(300,20);
        grid.add(phoneNumer,0,2);

        phoneNumerIn.setPrefSize(300,20);
        grid.add(phoneNumerIn,1,2);

        Button returnFromBook = new Button("Return home");
        returnFromBook.setPrefSize(300,20);
        grid.add(returnFromBook,0,3);

        Button bookBut = new Button("Book table");
        bookBut.setPrefSize(300,20);
        grid.add(bookBut,1,3);

        //take order page
        GridPane menuCat = new GridPane();
        menuCat.setPrefSize(1500,700);
        Scene takeOrderScene = new Scene(menuCat);

        //finish when oreder is made

        //take bill page
        GridPane billGrid = new GridPane();

        Label tablePayingLabel = new Label("Table paying");
        billGrid.add(tablePayingLabel,0,0);
        //finnish once bill is made

        //table comboBox
        Integer[] tables = new Integer[restaurant.getTables().size()];
        for(int i = 1; i <= tables.length; i++){
            tables[i - 1] = i;
        }
        ComboBox<Integer> selectTable = new ComboBox<>(FXCollections.observableArrayList(tables));
        selectTable.setVisible(true);
        selectTable.setPrefSize(300,20);
        billGrid.add(selectTable,1,0);

        Label cashOrCard = new Label("Cash or Card");
        billGrid.add(cashOrCard,0,1);

        ComboBox<String> cashOrCardBox = new ComboBox<>(FXCollections.observableArrayList(
                        "Cash",
                        "Card"
                ));

        billGrid.add(cashOrCardBox,1,1);

        Label tip = new Label("Tip (percentage):");
        tip.setPrefSize(300,20);
        billGrid.add(tip,0,2);

        tipIn.setPrefSize(300,20);
        billGrid.add(tipIn,1,2);

        Pane billPay = new Pane(billGrid);
        billPay.setPrefSize(400,400);
        Scene takeBillScene = new Scene(billPay);

        Button calculateBill =  new Button ("Calculate bill");
        calculateBill.setPrefSize(300,25);
        billGrid.add(calculateBill, 0,3);


        //actions
        //home
        takeWalkInBut.setOnAction(e -> primaryStage.setScene(takeWalkInScene));
        returnFromBook.setOnAction(e -> primaryStage.setScene(home));
        takeOrderBut.setOnAction(e -> primaryStage.setScene(takeOrderScene));
        takePaymentBut.setOnAction(e -> primaryStage.setScene(takeBillScene));
        refeshOrderBut.setOnAction(actionEvent -> {
            ArrayList<String> ord = new ArrayList<>();
            for(Order o: kitchen.getReadyOrders()){
                ord.add(o.toKitchenString());
            }
            ready.setAll(ord);
        });
        deliverOrderBut.setOnAction(actionEvent -> {
            kitchen.takeReadyOrder(readyOrders.getFocusModel().getFocusedIndex());
            ArrayList<String> ord = new ArrayList<>();
            for(Order o: kitchen.getReadyOrders()){
                ord.add(o.toKitchenString());
            }
            ready.setAll(ord);
        });
        bookBut.setOnAction(new BookingController());
        calculateBill.setOnAction(actionEvent -> {
            ArrayList<String> ord = new ArrayList<>();
            for(Order o: kitchen.getReadyOrders()){
                o.getBill();

            }


        });

        primaryStage.setScene(home);
        primaryStage.show();
    }
    public class BookingController implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            int noP = 0;
            String name = null;
            int phNo = 0;
            try {
                noP = numPeople();
                numPeopleIn.setBackground(Background.fill(Color.WHITE));
                name = getName();
                nameIn.setBackground(Background.fill(Color.WHITE));
                phNo = getPhoneNo();
                phoneNumerIn.setBackground(Background.fill(Color.WHITE));
                String tableNo = restaurant.addReservation(noP,new ReservationDate(LocalDate.now().toString()),new ReservationTime(LocalTime.now().toString().substring(0,5)),phNo,name);
                if(!tableNo.contains("Reservation")){
                    dateTakenInfo.setText(tableNo);
                }else {
                    dateTakenInfo.setText(String.format("table %s", tableNo.substring(22, 24)));
                }
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
