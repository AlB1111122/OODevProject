package com.example.code;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class TestUI extends Application {
    static Yum y = new Yum();

    public static void main(String[] args) throws IOException {
        y.addResturaunt("Limerick");
        Restaurant rL = y.getResturaunt("Limerick");
        rL.addTable(3);
        rL.addTable(2);

        y.addResturaunt("Dublin");
        Restaurant rD = y.getResturaunt("Dublin");
        rL.addTable(6);
        rL.addTable(2);

        CustomerUI ui = new CustomerUI();
        ui.setYum(y);
        CustomerUI.main(args);
    }

    public static void test() throws IOException {
        y.addResturaunt("Limerick");
        Restaurant rL = y.getResturaunt("Limerick");
        rL.addTable(3);
        rL.addTable(2);

        y.addResturaunt("Dublin");
        Restaurant rD = y.getResturaunt("Dublin");
        rL.addTable(6);
        rL.addTable(2);
        CustomerUI ui = new CustomerUI();
    }

    @Override
    public void start(Stage primaryStage) {
        CustomerUI ui = new CustomerUI();
        String[] s = new String[2];
        CustomerUI.main(s);
    }
}
