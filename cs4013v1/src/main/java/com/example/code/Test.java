package com.example.code;

import com.example.code.calender.ReservationDate;
import com.example.code.calender.ReservationTime;
import javafx.stage.Stage;

import java.io.IOException;

public class Test {
    Yum y = new Yum();
    public void test() throws IOException {
        y.addResturaunt("Limerick");
        Restaurant rL = y.getResturaunt("Limerick");
        rL.addTable(3);
        rL.addTable(2);

        y.addResturaunt("Dublin");
        Restaurant rD = y.getResturaunt("Dublin");
        rL.addTable(6);
        rL.addTable(2);
        CustomerUI ui = new CustomerUI();
        Stage s = new Stage();
        ui.start(s);
    }

}
