package com.example.code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        int currentResturauntId = 0;
        Yum y = new Yum();
        Scanner resturauntScan = null;
        try {
            resturauntScan = new Scanner(new File("CSVfiles/Resturaunts.csv"));
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
            return;
        }
        String[] resturauntLocs = resturauntScan.next().split(",");
        for(String s:resturauntLocs) {
            y.addResturaunt(s);
        }
        for(Restaurant r:y.getRestaurants()) {
            System.out.println(r.getLocation());
        }
        resturauntScan.close();

        y.addResturaunt("Killkey");
        try {
            FileWriter resturauntWrite = new FileWriter("CSVfiles/Resturaunts.csv");
            for(Restaurant r:y.getRestaurants()){
                resturauntWrite.append(r.getLocation()).append(",");
            }
            resturauntWrite.close();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }


    }
}
