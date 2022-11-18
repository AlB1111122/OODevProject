package com.example.oodevproj;

import com.example.oodevproj.Restaurant;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Linker{
    Restaurant r;

    Linker(Restaurant r){
        this.r = r;
    }

    public void bookPage(){
        BookReservationPage bookPage = new BookReservationPage();
        bookPage.setResturaunt(r);
    }

    public void cheffPage(){

    }


}
