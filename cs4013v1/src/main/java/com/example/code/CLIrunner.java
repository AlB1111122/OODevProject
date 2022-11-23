package com.example.code;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CLIrunner {
    public static void main(String[] args) throws IOException {
        Yum yum = new Yum();
        yum.addResturaunt("limerick");
        Restaurant r = yum.getResturaunt("limerick");
        r.addEmployee(new Waiter("alex",12332,"password"));
        Kitchen k = r.getKitchen();
        r.addTable(3);
        ArrayList<Dish> o = new ArrayList<>();
        o.add(new Dish("chips",2.50));
        k.addOrder(r.makeOrder(1,o));
        k.setCooking(0);
        k.setDishReady(0);
        k.takeReadyOrder(0);
        //csv files read in
        CLI cli = new CLI(yum);
        try {
            cli.run();
        }catch(IOException ex){
            //write back to CSV files
            System.out.println(ex.getMessage());
        }
    }

}
