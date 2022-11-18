package com.example.code.calender;

import java.util.StringTokenizer;

public class ReservationDate{
   private int year;
   private int month;
   private int day;

   public ReservationDate(String input){
      StringTokenizer in = new StringTokenizer(input, "/");
      if(in.countTokens() < 3 || in.countTokens() > 3){
         throw new RuntimeException("not a valid date");
      }
      int[] tokens = new int[3];
      String temp = "";
      int i = 0;
      while(in.hasMoreTokens()){
         temp = in.nextToken();
         if (temp.matches("[a-zA-Z]")){
            throw new RuntimeException("not a valid date");
         }
         tokens[i] = Integer.parseInt(temp);
         i++;
      }
      day = tokens[0];
      month = tokens[1];
      year = tokens[2];
   }

   public int getDay(){
      return day;
   }

   public int getMonth(){
      return month;
   }

   public int getYear() {
      return year;
   }

   public String toString(){
      String dayS = "" + day;
      if(day < 10){
         dayS = "0" + day;
      }
      String monthS = "" + month;
      if(month < 10){
         monthS = "0" + month;
      }
      String yearS = "" + year;
      if(year < 10){
         yearS = "0" + year;
      }
      return String.format("%s/%s/%s",dayS,monthS,yearS);
   }

}