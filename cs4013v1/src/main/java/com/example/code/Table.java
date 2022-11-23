package com.example.code;

import com.example.code.calender.Reservation;
import com.example.code.calender.ReservationCalendar;
import com.example.code.calender.ReservationDate;
import com.example.code.calender.ReservationTime;

import java.util.ArrayList;

public class Table{
    private int tableID;
    private int seats;
    private ReservationCalendar cal = new ReservationCalendar();

    Table(int seats, int tableID){
        this.tableID = tableID;
        this.seats = seats;
    }

    Table(int seats, int tableID, ArrayList<Reservation> reservations){
        this.tableID = tableID;
        this.seats = seats;
        cal.addAll(reservations);
    }

    public int getTableID(){
        return tableID;
    }

    public int getSeats(){
        return seats;
    }

    public String toString(){
        return String.format("Table number: %d, Number of seats %d",tableID,seats);
    }

    public ReservationCalendar getCalender(){
        return cal;
    }

    public void addReservation(Reservation reservation) {
        cal.add(reservation);
    }

    public boolean checkScheduleForConflict(ReservationTime time, ReservationDate date){
        for(Reservation res:cal.getReservationsForDay(date)){
            if (time.getTimeMin() >= res.getFromMin() && time.getTimeMin() <= res.getToMin() ||
                    (time.getTimeMin() + 120) >= res.getFromMin() && (time.getTimeMin() + 120) <= res.getToMin() ) {
                return true;
            }
        }
        return false;
    }
}
