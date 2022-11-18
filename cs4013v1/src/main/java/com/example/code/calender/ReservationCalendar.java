package com.example.code.calender;

import java.util.*;

public class ReservationCalendar{
   private ArrayList<Reservation> Reservations = new ArrayList<>();

   public void add(Reservation app){
      Reservations.add(app);
   }

   public ArrayList<Reservation> getReservationsForDay(ReservationDate day){
      ArrayList<Reservation> temp = new ArrayList<>();
      for(Reservation a:Reservations){
         if(a.getDay().toString().matches(day.toString())){
            temp.add(a);
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
