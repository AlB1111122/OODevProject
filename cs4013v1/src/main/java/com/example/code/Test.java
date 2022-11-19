package com.example.code;

import com.example.code.calender.ReservationDate;
import com.example.code.calender.ReservationTime;

public class Test {
    static Restaurant r = new Restaurant(1,"lim");

    public  static void main(String[] args){
        r.addTable(2);
        r.addTable(2);
        r.addTable(6);
        ReservationDate d = new ReservationDate("12/11/2022");
        ReservationTime t = new ReservationTime("11:30");

        System.out.println(r.addReservation(2,d,t,345345345,"al"));
        System.out.println(r.addReservation(2,d,t,345345345,"al"));
        System.out.println(r.addReservation(2,d,t,345345345,"al"));
        System.out.println(r.addReservation(5,d,t,345345345,"al"));
    }
}
