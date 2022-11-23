package com.example.code;

import java.io.IOException;

public class CLIrunner {
    public static void main(String[] args){
        Yum yum = new Yum();
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
