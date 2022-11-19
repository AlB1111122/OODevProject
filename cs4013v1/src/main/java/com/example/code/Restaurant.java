package com.example.code;

import com.example.code.calender.Reservation;
import com.example.code.calender.ReservationCalendar;
import com.example.code.calender.ReservationDate;
import com.example.code.calender.ReservationTime;

import java.io.IOException;
import java.util.ArrayList;

public class Restaurant{
    private int restaurantID;
    private int capacity;

    private int orders;
    private int reservations;

    private String location;
    private ArrayList<Table> tables = new ArrayList<Table>();
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private Kitchen kitchen = new Kitchen();
    public Restaurant(int restaurantID, String location){
        this.restaurantID = restaurantID;
        this.location = location;
    }

    public ArrayList<Reservation> getReservations(){
        ArrayList<Reservation> reservations = new ArrayList<>();
        for(Table t:tables){
            reservations.addAll(getReservations());
        }
        return reservations;
    }

    public String getLocation() {
        return location;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void addTable(int seats){
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

    public String getCustomerId(String name, int phoneNum)throws IOException{
        for(Customer c:customers){
            if(c.getName().equals(name) && c.getPhoneNumber() - phoneNum ==0){
                return c.getID();
            }
        }
        throw new IOException("Not an existing customer");
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public Kitchen getKitchen(){
        return kitchen;
    }

    public void addCustomer(String name, int phoneNumber){
        Customer c = new Customer(name,phoneNumber);
        customers.add(c);
    }

    public String addReservation(int numPeople, ReservationDate date, ReservationTime time, int phoneNumber, String name){
        String customerId = "";
        for(Person p:customers){
            if(p.getPhoneNumber() - phoneNumber == 0){
                customerId = p.getID();
                break;
            }
        }
        if(customerId.equals("")){
            addCustomer(name,phoneNumber);
            customerId = customers.get(customers.size() - 1).getID();
        }
        Table booking = null;
        for(Table t:tables){
            if(t.getSeats() >= numPeople && t.getSeats() < numPeople + 3){
                if(!t.checkScheduleForConflict(time,date)) {
                    booking = t;
                    break;
                }
            }
        }
        if(booking != null) {
            if(booking.checkScheduleForConflict(time,date)){
                return "No tables are avalible for a group of that size at that time";
            }
            try {
                Reservation r = new Reservation(reservations,numPeople, date, time, booking.getTableID(), customerId);
                booking.addReservation(r);
                reservations++;
                return String.format("Sucsessfully reserved a table for %d at %s on %s! " +
                        "You will shortly receive a text confirming your booking, and an hour before to remind you"
                        ,numPeople,time.toString(),date.toString());
            } catch (RuntimeException ex) {
                return ex.getMessage();
            }
        }
        return "There are no tables available for a group of that size at this resturaunt";
    }

    public void makeOrder(int tableId,ArrayList<Dish> dishes){//posibly change lateer
        Order order = new Order(orders,tableId);
        for(Dish d:dishes){
            order.addDish(d);
        }
    }
}
























