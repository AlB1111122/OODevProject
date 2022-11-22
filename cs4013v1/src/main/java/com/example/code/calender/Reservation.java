package com.example.code.calender;

public class Reservation{

   private int reservationId;
   private int numPeople;
   private ReservationDate day;
   private ReservationTime from;
   private ReservationTime to;
   private int tableId;
   private String customerId;

   /**
    * creates a new reservation
    * @param reservationId the unique(for the resturaunt) identifier for the reservation
    * @param numPeople number of people the reservation is for
    * @param day the day it is on
    * @param time the time the reservation is on
    * @param tableId the ID number of the table booked
    * @param customerId the ID of the customer who booked the table
    */
   public Reservation(int reservationId,int numPeople, ReservationDate day, ReservationTime time,int tableId,String customerId){
      this.reservationId = reservationId;
      this.numPeople = numPeople;
      this.day = day;
      this.from = time;
      this.to = makeTo();
      this.tableId = tableId;
      this.customerId = customerId;
   }

   /**
    * returns the reservations ID number
    * @return reservationId
    */
   public int getReservationId() {
      return reservationId;
   }

   /**
    * returns the number of people the booking is for
    * @return int of the number of people the booking is for
    */
   public int getNumPeople() {
      return numPeople;
   }

   /**
    * returns the day the booking is for
    * @return ReservationDate of the day booked for
    */
   public ReservationDate getDay(){
      return day;
   }
   /**
    * returns the time the booking starts at
    * @return ReservationTime of the time booked for
    */
   public ReservationTime getFrom() {
      return from;
   }

   /**
    * returns a time 2 hours after the table was booked for reperesenting the ending time
    * @return ReservationTime of the time the reservations ends at
    */
   public ReservationTime getTo() {
      return to;
   }

   /**
    * returnes the time the reservation starts at in minutes for easier maths
    * @return the time he reservations starts at in minutes
    */
   public  int getFromMin(){
      return from.getTimeMin();
   }

   /**
    * returnes the time the reservation ends at in minutes for easier maths
    * @return the time he reservations ends at in minutes
    */
   public int getToMin(){
      return to.getTimeMin();
   }

   /**
    * returns the reserved table
    * @return the ID of the table that is reserved
    */
   public int getTableNo() {
      return tableId;
   }

   /**
    * returns the ID of the customer who booked the table
    * @return the Id of the customer
    */
   public String getCustomerId() {
      return customerId;
   }

   /**
    * ads 2 hours to the time the reservation starts at to make the time it ends at
    * @return ReservationTime the reservation ends at
    */
   private ReservationTime makeTo(){
      String str = String.format("%d:%d",from.getHours()+2,from.getMinutes());
      return new ReservationTime(str);
   }

   /**
    * makes an internal string to be read and written to CSV files
    * @return string of the details of the reservation
    */
   public String toInternalString(){
      return String.format("%d,%d,%d/%d/%d,%d:%d,%d,%s"
              ,reservationId,numPeople,day.getDay(),day.getMonth(),day.getYear(),from.getHours(),from.getMinutes(),tableId,customerId);
   }

   /**
    * returns a string of details of the reservation in clear english
    * @return string of the reservation
    */
   @Override
   public String toString(){
      return String.format("People: %d, Date: %d/%d/%d,Time: %d:%d"
              ,numPeople,day.getDay(),day.getMonth(),day.getYear(),from.getHours(),from.getMinutes());
   }
}
