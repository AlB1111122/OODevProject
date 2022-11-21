package com.example.code.calender;

public class Reservation{

   private int reservationId;
   private int numPeople;
   private ReservationDate day;
   private ReservationTime from;
   private ReservationTime to;
   private int tableNo;
   private String customerId;

   public Reservation(int reservationId,int numPeople, ReservationDate day, ReservationTime time,int tableNo,String customerId){
      this.reservationId = reservationId;
      this.numPeople = numPeople;
      this.day = day;
      this.from = time;
      this.to = makeTo();
      this.tableNo = tableNo;
      this.customerId = customerId;
   }

   public int getReservationId() {
      return reservationId;
   }

   public int getNumPeople() {
      return numPeople;
   }

   public ReservationDate getDay(){
      return day;
   }

   public ReservationTime getFrom() {
      return from;
   }

   public ReservationTime getTo() {
      return to;
   }

   public  int getFromMin(){
      return from.getTimeMin();
   }

   public int getToMin(){
      return to.getTimeMin();
   }

   public int getTableNo() {
      return tableNo;
   }

   public String getCustomerId() {
      return customerId;
   }

   private ReservationTime makeTo(){
      String str = String.format("%d:%d",from.getHours()+2,from.getMinutes());
      return new ReservationTime(str);
   }

   public String toInternalString(){
      return String.format("%d,%d,%d/%d/%d,%d:%d,%d,%s"
              ,reservationId,numPeople,day.getDay(),day.getMonth(),day.getYear(),from.getHours(),from.getMinutes(),tableNo,customerId);
   }
@Override
   public String toString(){
      return String.format("People: %d, Date: %d/%d/%d,Time: %d:%d"
              ,numPeople,day.getDay(),day.getMonth(),day.getYear(),from.getHours(),from.getMinutes());
   }
   //ReservationId, numPeople, date, time, tableNo, customerId
}
