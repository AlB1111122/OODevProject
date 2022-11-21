package com.example.code.calender;

import java.util.*;
//reservation package is repuposed code from lab 7
public class ReservationCalendar{
   private ArrayList<Reservation> Reservations = new ArrayList<>();

   public void add(Reservation app){
      Reservations.add(app);
   }

   public ArrayList<Reservation> getReservationsForDay(ReservationDate day){
      ArrayList<Reservation> temp = new ArrayList<>();
      for(Reservation r:Reservations){
         if(r.getDay().compareTo(day.getDay()) > -1){
            temp.add(r);
         }
      }
      return temp;
   }

   public void cancel(Reservation Reservation){
      Reservations.remove(Reservation);
   }

   public ArrayList<Reservation> getReservations(){
      return Reservations;
   }
}
