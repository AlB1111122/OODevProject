package com.example.oodevproj.calender;

import java.util.StringTokenizer;

public class ReservationTime{
   private int hours;
   private int minutes;

   ReservationTime(String input){
      StringTokenizer in = new StringTokenizer(input, ":");
      if(in.countTokens() < 2 || in.countTokens() > 2){
         throw new RuntimeException("not a valid time");
      }
      int[] tokens = new int[2];
      String temp = "";
      int i = 0;
      while(in.hasMoreTokens()){
         temp = in.nextToken();
         if (temp.length() != 2 || temp.matches("[a-zA-Z]")){
            throw new RuntimeException("not a valid time");
         }
         tokens[i] = Integer.parseInt(temp);
         i++;
      }
      hours = tokens[0];
      minutes = tokens[1];
   }

   public int getTimeMin(){
      return minutes + (hours * 60);
   }

   public int getHours(){
      return hours;
   }

   public int getMinutes(){
      return minutes;
   }

   public String toString(){
      String h = "" + hours;
      String m = "" + minutes;
      if(hours < 10){
         h = "0" + hours;
      }
      if(minutes < 10){
         m = "0" + minutes;
      }
      return String.format("%s:%s",h,m);
   }
}