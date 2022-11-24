package com.example.code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){


        // Restaurants
        //Set up
        int currentResturauntId = 0;
        Yum y = new Yum();
        Scanner resturauntScan = null;

        // Try to find directory
        try {
            resturauntScan = new Scanner(new File("C:\\Program Files\\Yum\\CSVfiles\\Restaurant.csv"));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return;
        }
        // Make an array of strings split by ","s
        String[] resturauntLocs = resturauntScan.next().split(",");
        for (String s : resturauntLocs) {
            y.addResturaunt(s);
        }
        // For every restaurant, in y, print location
        for (Restaurant r : y.getRestaurants()) {
            System.out.println(r.getLocation());
        }
        resturauntScan.close();

        // Add Restaurant
        y.addResturaunt("Killkey");
        try {
            FileWriter resturauntWrite = new FileWriter("C:\\Program Files\\Yum\\CSVfiles\\Restaurant.csv");
            for (Restaurant r : y.getRestaurants()) {
                resturauntWrite.append(r.getLocation()).append(",");
            }
            resturauntWrite.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


        // Tables
        // Set up
        int currentTables = 0;
        Restaurant r = new Restaurant(1, "LuckyLimerick");
        Scanner tableScan = null;

        // Try to find directory
        try {
            tableScan = new Scanner(new File("C:\\Program Files\\Yum\\CSVfiles\\Tables.csv"));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return;
        }
        // Make an array of strings split by ","s
        String[] tableIds = tableScan.next().split(",");
        for (String t : tableIds) {
            r.addTableId(Integer.parseInt(t));
            //r.addTableId(s);
        }
        // For every table in r, print tableID
        for (Table t : r.getTables()) {
            System.out.println(t.getTableID());
        }
        tableScan.close();

        // Add Table
        r.addTableId(4);
        r.addTableId(5);
        try {
            FileWriter tableWrite = new FileWriter(new File("C:\\Program Files\\Yum\\CSVfiles\\Tables.csv"));

            for (Table t : r.getTables()) {
                String tID = "" + t.getTableID();
                tableWrite.append(tID).append(",");
            }
            tableWrite.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            File tableWrite = new File("C\\ProgramFiles\\Yum\\Duplicates\\DupTab.csv");
            tableWrite.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }







    /*
        // Menu
                // Set up
        int currentMenus = 0;
        Scanner menuScan = null;
        MenuCatagory m = new MenuCatagory("Fish", );

                // Try to find directory
        try {
            menuScan = new Scanner(new File("C:\\Program Files\\Yum\\CSVfiles\\Menus.csv"));
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
            return;
        }
                // Make an array of strings split by ","
        String[] categoryName = menuScan.next().split(",");
        for(String m:categoryName) {
            r.addMenuCategory(m);
        }
                // For every menu in r, printMenuCategory
        for(MenuCategory m:r.getMenu()) {
            System.out.println(m.getMenu());
        }
        menuScan.close();

                // Add Menu
        r.addMenuCatagory(4, String[][] food = new String[2][2]);
        try {
            FileWriter menuWrite = new FileWriter(new File("C:\\Program Files\\Yum\\CSVfiles\\Menus.csv"));
            for(MenuCatagory m:r.getMenu()){
                menuWrite.append(m.getMenu()).append(",");
            }
            menuWrite.close();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        } */


        // Set up
        int currentBills = 0;
        Scanner billScan = null;

        Restaurant r = new Restaurant(1, "LuckyLimerick");


        // Try to find directory
        try {
            billScan = new Scanner(new File("C:\\Program Files\\Yum\\CSVfiles\\Bills.csv"));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        // Make an array of strings split by ","
        String[] bills = billScan.next().split(",");
        for (String b : bills) {
            r.addBill(Integer.parseInt(b));
        }
        // For every bill in r, printBill
        for (Bill b : r.getBills()) {
            System.out.println(b.getBillPrice());
        }
        billScan.close();

        // Add Bill
        r.addBill(6.20);
        r.addBill(5.50);
        r.addBill(4.20);
        try {
            FileWriter billWrite = new FileWriter(new File("C:\\Program Files\\Yum\\CSVfiles\\Bills.csv"));

            for (Bill b : r.getBills()) {
                String bID = "" + b.getTableID();
                billWrite.append(bID).append(",");
            }
            billWrite.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }





    /*    int currentEmployees = 0;
        Scanner employeeScan = null;
                // Try to find directory
        try {
            employeeScan = new Scanner(new File("C:\\Program Files\\Yum\\CSVfiles\\Employees.csv"));
         }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        return;
        }
                // Make an array of strings split by ","
        String[] employees = employeeScan.next().split(",");
            for(String e: employees) {
            r.addEmployees();
        }
                // For every employee in e, printEmployee
        for(Employee e:r.getEmployees()) {
        System.out.println(e.getEmployee());
         }
        employeeScan.close();
                // Add Employee
        r.addEmployee();
        try {
        FileWriter employeeWrite = new FileWriter(new File("C:\\Program Files\\Yum\\CSVfiles\\Employees.csv"));
        for(Table t:r.getTables()){
            employeeWrite.append(t.getEmployee()).append(",");
        }
            employeeWrite.close();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
          */
        

    }
}
