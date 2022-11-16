package com.example.oodevproj.calender;

import java.util.*;

public class ReservationCalendar {
   private ArrayList<Reservation> Reservations = new ArrayList<>();

   public void add(Reservation app){
      ReservationDate usedDate = app.getDay();
      int from = app.getFromMin();
      int to = app.getToMin();
      //for(Reservation a: Reservations){
        // if(app.getDay().toString().matches(a.getDay().toString())){
        //    Reservations.add(app);
        // }else if(to <= a.getFromMin() && from >= a.getToMin()){
        //    Reservations.add(app);
        // }
      if(!getReservationsForDay(usedDate).isEmpty()){
         for(Reservation a: getReservationsForDay(usedDate)){
            if(to > a.getFromMin() && from < a.getToMin()){
               return;
            }
         }
      }
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
