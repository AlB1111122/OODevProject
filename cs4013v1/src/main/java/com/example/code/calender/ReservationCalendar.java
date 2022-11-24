package com.example.code.calender;

import java.util.*;
//reservation package is repurposed code from lab 7
public class ReservationCalendar{
   private ArrayList<Reservation> reservations = new ArrayList<>();

   /**
    * ads a new reservation to the calender
    * @param res the reservation to be added to the calendar
    */
   public void add(Reservation res){
      reservations.add(res);
   }

   public void addAll(ArrayList<Reservation> res){
      reservations.addAll(res);
   }
   /**
    * returns all the reservations booked for the given day
    * @param day the day being searched for reservations for
    * @return arrayList of reservations on the date inserted
    */
   public ArrayList<Reservation> getReservationsForDay(ReservationDate day){
      ArrayList<Reservation> temp = new ArrayList<>();
      for(Reservation r:reservations){
         if(r.getDay().compareTo(day.getDay()) > -1){
            temp.add(r);
         }
      }
      return temp;
   }

   /**
    * removes the given reservation from the calender
    * @param Reservation reservation to be removed from the calender
    */
   public void cancel(Reservation Reservation){
      reservations.remove(Reservation);
   }

   /**
    * returns a list of all the reservations in this calender
    * @return ArrayList of reservations
    */
   public ArrayList<Reservation> getReservations(){
      return reservations;
   }
}
