package com.example.oodevproj.calender;

public class Reservation{
   private ReservationDate day;
   private ReservationTime from;
   private ReservationTime to;

   Reservation(String input){
      String[] inputs = input.split(", ",4);
      try{
      }catch(RuntimeException e){
         System.out.println("desc Exception caught:invalid input, please use format:\n" +
                 "Description, DD/MM/YYYY, HH:MM, HH:MM");
      }
      try {
         day = new ReservationDate(inputs[1]);
      }catch(RuntimeException e){
      System.out.println("date Exception caught:invalid input, please use format:\n" +
              "Description, DD/MM/YYYY, HH:MM, HH:MM");
      }try{
         from = new ReservationTime(inputs[2]);
      }catch(RuntimeException e){
         System.out.println("ap from Exception caught:invalid input, please use format:\n" +
                 "Description, DD/MM/YYYY, HH:MM, HH:MM");
      }try{
         to = new ReservationTime(inputs[3]);
      }catch(RuntimeException e){
         System.out.println("Exception caught:invalid input, please use format:\n" +
                 "Description, DD/MM/YYYY, HH:MM, HH:MM");
      }
   }

   public ReservationDate getDay(){
      return day;
   }

   public  int getFromMin(){
      return from.getTimeMin();
   }

   public int getToMin(){
      return to.getTimeMin();
   }

   public String format(){
      return String.format("Description: %s, %s, %s, %s",description,day.toString(), from.toString(),to.toString());
   }

   public String toString(){
      return String.format("Description: %s, %s, %s, %s",description,day.toString(), from.toString(),to.toString());
   }
}
