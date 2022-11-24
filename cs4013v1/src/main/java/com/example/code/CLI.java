package com.example.code;

import com.example.code.calender.Reservation;
import com.example.code.calender.ReservationDate;
import com.example.code.calender.ReservationTime;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class CLI {//add return to last page
    Yum yum;
    Restaurant restaurant;

    Kitchen kitchen;
    Scanner in = new Scanner(System.in);

    CLI(Yum yum){
        this.yum = yum;
    }

    public void run() throws IOException {
        boolean more = true;
        while(more) {
            openPage();
        }
    }

    public void openPage() throws IOException {
        System.out.println("0)Exit system. 1)Use as employee. 2)Use as customer");
        boolean blocked = true;
        while(blocked) {
            String userType = in.nextLine();
            if (userType.equals("0")) {
                throw new IOException("System closed");
            } else if (userType.equals("1")) {
                signInPage();
                blocked = false;
            } else if (userType.equals("2")) {
                customerBookingPage();
                blocked = false;
            }
            System.out.println("Invalid input");
        }
    }

    public void customerChoisesPages() throws IOException {
        boolean blocked = true;
        while(blocked){
            System.out.println("0)Exit 1)Make a booking. 2)Cancel a booking");
            String cusSelect = in.nextLine();
            if(cusSelect.equals("1")){
                customerBookingPage();
            }else if(cusSelect.equals("2")){
                cancelBookingPage();
            } else if (cusSelect.equals("0")) {
                throw new IOException("System closed");
            }else{
                System.out.println("Invalid input");
            }
        }
    }

    public void cancelBookingPage(){
        boolean blocked = true;
        int selection = 0;
        while (blocked) {
            System.out.println("Select a location");
            int i = 1;
            for (String s : yum.getRestrauntLocations()) {
                System.out.println(i + ")" + s);
            }
            String locationIn = in.nextLine();
            try {
                selection = Integer.parseInt(locationIn);
                if (selection > 0 && selection <= yum.getRestrauntLocations().size()) {
                    blocked = false;
                } else {
                    System.out.println("Invalid input");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input");
            }
        }
        String customerId = "";
        blocked = true;
        while(blocked){
            System.out.println("Enter your name");
            String nameIn = in.nextLine();

            System.out.println("Enter your phone number");
            String phoneNumberIn = in.nextLine();

            String name = "";
            int phNo = 0;
            try {
                name = getName(nameIn);
                phNo = getPhoneNo(phoneNumberIn);
                customerId = restaurant.getCustomerId(name,phNo);
                blocked = false;
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        int i = 1;
        int[] resIds = new int[10];
        for(Reservation r:restaurant.getReservations()){
            if(r.getCustomerId().equals(customerId)){
                System.out.print(i + ")" + r.toString());
                resIds[i - 1] = r.getReservationId();
                i++;
            }
        }
        System.out.println("Seclect the reservation you want to cancel");
        String resCancel = in.nextLine();
        int cancelIndex = 0;
        try {
            cancelIndex = getPhoneNo(resCancel);
        } catch (IOException e) {
            System.out.println("Invalid input");
            return;
        }
        if(cancelIndex < 1 || cancelIndex >= 10){
            restaurant.cancelReservation(cancelIndex - 1);
        }
    }

    public void customerBookingPage() {
        boolean blocked = true;
        int selection = 0;
        while (blocked) {
            System.out.println("Select a location");
            int i = 1;
            for (String s : yum.getRestrauntLocations()) {
                System.out.println(i + ")" + s);
            }
            String locationIn = in.nextLine();
            try {
                selection = Integer.parseInt(locationIn);
                if (selection > 0 && selection <= yum.getRestrauntLocations().size()) {
                    blocked = false;
                } else {
                    System.out.println("Invalid input");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input");
            }
        }
        restaurant = yum.getResturaunt(selection - 1);
        blocked = true;
        while (blocked) {
            System.out.println("Enter the number of people you wish to book for");
            String numPplIn = in.nextLine();

            System.out.println("Enter the date you wish to book for");
            String dateIn = in.nextLine();

            System.out.println("Enter the time you wish to book for");
            String timeIn = in.nextLine();

            System.out.println("Enter your name");
            String nameIn = in.nextLine();

            System.out.println("Enter your phone number");
            String phoneNumberIn = in.nextLine();


            try {
                int noP = numPeople(numPplIn);
                ReservationDate date = new ReservationDate(dateIn);
                ReservationTime time = new ReservationTime(timeIn);
                String name = getName(nameIn);
                int phNo = getPhoneNo(phoneNumberIn);
                System.out.println(restaurant.addReservation(noP, date, time, phNo, name));
                blocked = false;
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    public void signInPage() throws IOException {
        Employee signedIn = null;
        boolean blocked = true;
            while (blocked) {
                System.out.println("Enter the location you work at");
                String locationIn = in.nextLine();
                if (yum.getRestrauntLocations().contains(locationIn)) {
                    restaurant = yum.getResturaunt(locationIn);
                    kitchen = restaurant.getKitchen();
                    blocked = false;
                } else {
                    System.out.println("That location doesn't exist");
                }
            }
            blocked = true;
            while(blocked){
                System.out.println("Enter your employee Id");
                String idIn = in.nextLine();
                    for(Employee e: restaurant.getEmployees()){
                        if(e.getID().equals(idIn)){
                            signedIn = e;
                            blocked = false;
                        }
                    }
                    if(signedIn == null) {
                        System.out.println("No employee with that Id at this location");
                    }
            }
            blocked = true;
            while(blocked){
                System.out.println("Enter your password");
                String passwordIn = in.nextLine();
                if(signedIn.getPassword().equals(passwordIn)){
                    blocked = false;
                }else {
                    System.out.println("Incorrect password");
                }
            }
        if(signedIn instanceof Cheff){
            cheffPage();
        }else if(signedIn instanceof Waiter){
            waiterPage();
        }
    }
    public void cheffPage() throws IOException {
        boolean blocked = true;
        while(blocked){
            System.out.println("0)Exit. 1)Waiting dishes. 2)Cooking dishes.");
            String dishListChoice = in.nextLine();
            if(dishListChoice.equals("0")){
                throw new IOException("System closed");
            }else if(dishListChoice.equals("1")){
                int i = 1;
                for(String s:kitchen.getWatingDishString()){
                    System.out.println(i + ") " + s);
                    i++;
                }
                String wDishSelected = in.nextLine();
                try{
                    kitchen.setCooking(Integer.parseInt(wDishSelected) - 1);
                }catch(NumberFormatException | IndexOutOfBoundsException ex){
                    System.out.println(ex.getMessage());
                }
            }else if(dishListChoice.equals("2")){
                int i = 1;
                for(String s:kitchen.getCookingDishString()){
                    System.out.println(i + ") " + s);
                    i++;
                }
                String wDishSelected = in.nextLine();
                try{
                    kitchen.setDishReady(Integer.parseInt(wDishSelected) - 1);
                }catch(NumberFormatException | IndexOutOfBoundsException ex){
                    System.out.println(ex.getMessage());
                }
            }else{
                System.out.println("Invalid input");
            }
        }
    }

    public void waiterPage() throws IOException {//add make order
        boolean blocked = true;
        while (blocked) {
            System.out.println("0)Exit. 1)Deliver order. 2)Take walk-in. 3)Take payment");//add take order
            String waiterChoice = in.nextLine();
            if (waiterChoice.equals("0")) {
                throw new IOException("System closed");
            }else if(waiterChoice.equals("1")){
                System.out.println("Orders ready for delivery:");
                int i = 1;
                for(Order o:kitchen.getReadyOrders()){
                    System.out.println(i + ") " + o.toKitchenString());
                    i++;
                }
                String wDishSelected = in.nextLine();
                try{
                    kitchen.takeReadyOrder(Integer.parseInt(wDishSelected) - 1);
                    restaurant.setBills();
                }catch(NumberFormatException | IndexOutOfBoundsException ex){
                    System.out.println(ex.getMessage());
                }
            }else if(waiterChoice.equals("2")){
                System.out.println("Take walk in appointment\n" +
                        "Enter [number of people],[A member of the groups phone number],[A member of the groups name]");
                String[] walkInInfo = in.nextLine().split(",");
                if(walkInInfo.length - 3 == 0){
                    int noP = 0;
                    String name = null;
                    int phNo = 0;
                    try {
                        noP = numPeople(walkInInfo[0]);
                        name = getName(walkInInfo[1]);
                        phNo = getPhoneNo(walkInInfo[2]);
                        String tableNo = restaurant.addReservation(noP,new ReservationDate(LocalDate.now().toString()),new ReservationTime(LocalTime.now().toString().substring(0,5)),phNo,name);
                        if(!tableNo.contains("Reservation")){
                            System.out.println(tableNo);
                        }else {
                            System.out.printf("table %s%n", tableNo.substring(22, 24));
                        }
                    }catch(IOException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }else if(waiterChoice.equals("3")){
                System.out.println("Select the table paying");
                for(Table t: restaurant.getTables()){
                    System.out.println(t.getTableID());
                }
                String payingIn = in.nextLine();
                int tableSel = -1;
                try {
                    tableSel = Integer.parseInt(payingIn);
                    assert tableSel != -1;
                    ArrayList<Bill> bills = new ArrayList<>();
                    for(Bill b:restaurant.getUnpaidBills()){
                        if(b.getTableID() - tableSel == 0){
                            bills.add(b);
                        }
                    }
                    boolean block2 = true;
                    while(block2) {
                        System.out.println("Enter: [tip percentage],[(if payed by cash)Y/N]");
                        String payBillIn = in.nextLine();
                        String[] payBillarr = payBillIn.split(",");
                        if((payBillarr.length - 2 == 0)){
                            try{
                                int tip = numPeople(payBillarr[0]);
                                boolean cash = true;
                                if(payBillarr[1].equalsIgnoreCase("N")){
                                    cash = false;
                                }else if(!(payBillarr[1].equalsIgnoreCase("Y"))){
                                    System.out.println("Invalid input");
                                    block2 = false;
                                }
                                if (!bills.isEmpty()) {
                                    for (Bill b : bills) {
                                        b.payBill(tip,cash);
                                    }
                                }
                            }catch(IOException ex){
                                System.out.println("Invalid input");
                            }
                        }else{
                            System.out.println("Invalid input");
                        }
                    }
                }catch(NumberFormatException ex){
                    System.out.println();
                }

                //for(Order o: kitchen.getDeliverdOrders()){
                //    System.out.println(o.getBill().toString());
                //}
            }
        }
    }

    /**
     * processes string for taking walk ins
     * @param no the string of the number of people entered
     * @return returns no in an int form
     * @throws IOException throws exeption no is invalid input
     */
    private int numPeople(String no)throws IOException{
        if (!no.isEmpty()) {
            try {
                return Integer.parseInt(no);
            }catch(NumberFormatException ex){
                throw new IOException("Invalid number of people");
            }
        }else{
            throw new IOException("Invalid number of people");
        }
    }

    /**
     * returns the name of the person booking after being checked for correctness
     * @param in string being checked, should be a name
     * @return returns the name input
     * @throws IOException if input is invalid throws exeption
     */
    private String getName(String in)throws IOException{
        if(!in.isEmpty() && !(in.matches("[a-zA-Z]"))){
            return in;
        }else{
            throw new IOException("Invalid name");
        }
    }

    /**
     * returns phone number as int after checking it
     * @param no the string of a number entered
     * @return the int of the string
     * @throws IOException if the string is empty or contains lettwrs
     */
    private int getPhoneNo(String no)throws IOException{
        if (!no.isEmpty()) {
            try {
                return Integer.parseInt(no);
            }catch(NumberFormatException ex){
                throw new IOException("Invalid phone number");
            }
        }else{
            throw new IOException("Invalid phone number");
        }
    }
}

















