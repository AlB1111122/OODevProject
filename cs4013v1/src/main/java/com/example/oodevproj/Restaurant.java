package com.example.oodevproj;

import com.example.oodevproj.calender.Reservation;
import com.example.oodevproj.calender.ReservationCalendar;
import com.example.oodevproj.calender.ReservationDate;
import com.example.oodevproj.calender.ReservationTime;

import java.util.ArrayList;
import java.util.Calendar;

public class Restaurant{
    private int restaurantID;
    private int capacity;
    private ArrayList<Table> tables = new ArrayList<Table>();
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private ReservationCalendar cal = new ReservationCalendar();
    public Restaurant(int restaurantID){
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

    public ReservationCalendar getCalender(){
        return cal;
    }

    public void addCustomer(String name, int phoneNumber){
        Customer c = new Customer(name,phoneNumber);
        customers.add(c);
    }

    public String addReservations(int numPeople, ReservationDate date, ReservationTime time, int phoneNumber, String name){
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
        int temp = numPeople + 3;
        Table booking = null;
        for(Table t:tables){
            if(t.getSeats() >= numPeople && temp < t.getSeats() && checkScheduleForConflict(time,date)){
                temp = t.getSeats();
                booking = t;
            }
        }
        if(checkScheduleForConflict(time,date)){
            return "No tables are avalible for a group of that size at that time";
        }
        if(booking != null) {
            try {
                Reservation r = new Reservation(cal.getReservations().size() + 1, numPeople, date, time, booking.getTableID(), customerId);
                cal.add(r);
                return String.format("Sucsessfully reserved a table for %d at %s on %s!\n" +
                        "You will shortly receive a text confirming your booking, and an hour before to remind you"
                        ,numPeople,time.toString(),date.toString());
            } catch (RuntimeException ex) {
                return ex.getMessage();
            }
        }
        return "There are no tables available for a group of that size at this resturaunt";
    }

    private boolean checkScheduleForConflict(ReservationTime time, ReservationDate date){
        for(Reservation res:cal.getReservationsForDay(date)){
            if (time.getTimeMin() > res.getFromMin() && time.getTimeMin() < res.getToMin() ||
                    (time.getTimeMin() + 120) > res.getFromMin() && (time.getTimeMin() + 120) < res.getToMin() ) {
                return true;
            }
        }
        return false;
    }
}
























