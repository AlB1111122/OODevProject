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
    private static int orders;
    private int reservations;

    private String location;
    private ArrayList<Table> tables = new ArrayList<Table>();
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private ArrayList<MenuCatagory> menu = new ArrayList<>();

    private ArrayList<Bill> bills = new ArrayList<>();
    private Kitchen kitchen = new Kitchen();

    public Restaurant(int restaurantID, String location){
        this.restaurantID = restaurantID;
        this.location = location;
    }
    public Restaurant(int restaurantID, String location,ArrayList<Table> tables,ArrayList<Customer> customers,ArrayList<MenuCatagory> menu,ArrayList<Bill> bills){
        this.restaurantID = restaurantID;
        this.location = location;
        this.tables = tables;
        getReservations();
        this.customers = customers;
        this.menu = menu;
        this.bills = bills;
        setCapacity();
    }

    public void setBills(){
       for(Order o:kitchen.getDeliverdOrders()){
           if(!bills.contains(o.getBill())) {
               bills.add(o.getBill());
           }
       }
    }

    public ArrayList<Bill> getUnpaidBills(){
        ArrayList<Bill> unpaid = new ArrayList<>();
        for(Bill b:bills){
            if(b.getIsPaid()){
                unpaid.add(b);
            }
        }
        return unpaid;
    }
    public ArrayList<Bill> getBills(){return bills;}
    
    public void addBill(double price){
        Bill newBill = new Bill(0, dishes ,price, new ReservationDate("Str"));
        bills.add(newBill);
    }

    public ArrayList<MenuCatagory> getMenu() {
        return menu;
    }

    public void addMenuCatagory(String catagoryName,String[][] dishes){
        menu.add(new MenuCatagory(catagoryName,dishes));
    }

    public ArrayList<Reservation> getReservations(){
        ArrayList<Reservation> reservations = new ArrayList<>();
        for(Table t:tables){
            reservations.addAll(t.getCalender().getReservations());
        }
        this.reservations = reservations.size();
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
    public void addTableId(int id){
        Table newTable = new Table(tables.size() + 2, id);
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
                return String.format("Reservation for table %d at %s on %s! You will receive a text an hour before to remind you"
                        ,booking.getTableID(),time.toString(),date.toString());
            } catch (RuntimeException ex) {
                return ex.getMessage();
            }
        }
        return "There are no tables available for a group of that size at this resturaunt";
    }

    public void cancelReservation(int reservationId){
        Reservation canceling = null;
        if(!getReservations().isEmpty()) {
            for (Reservation r : getReservations()) {
                if (r.getReservationId() - reservationId == 0) {
                    canceling = r;
                    break;
                }
            }
        }
        for(Table t: tables) {
            assert canceling != null;
            if(canceling.getTableNo() - t.getTableID() == 0){
                t.getCalender().cancel(canceling);
                return;
            }
        }
    }

    public Order makeOrder(int tableId,ArrayList<Dish> dishes){//posibly change lateer
        orders++;
        for(Dish d:dishes){
            d.setOrderId(orders);
        }
        return new Order(orders,tableId,dishes);
    }

}
























