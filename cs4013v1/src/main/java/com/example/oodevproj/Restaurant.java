package com.example.oodevproj;

import java.util.ArrayList;

public class Restaurant{
    private int restaurantID;
    private int capacity;
    private ArrayList<Table> tables = new ArrayList<Table>();
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();


    Restaurant(int restaurantID){
        this.restaurantID = restaurantID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void addTables(int seats){
        Table newTable = new Table(seats, tables.size() + 1);
        tables.add(newTable);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(){
        int cap = 0;
        for(Table t:tables){
            cap = cap + t.getSeats();
        }
        capacity = cap;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }
}























