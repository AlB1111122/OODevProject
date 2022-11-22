package com.example.code.calender;

import java.util.StringTokenizer;

public class ReservationDate implements Comparable{
   private int year;
   private int month;
   private int day;

   /**
    * takes a string and turns it into a Date
    * @param input a string input of the date
    */
   public ReservationDate(String input){
      StringTokenizer in = null;
      if(input.contains("/")){
         in = new StringTokenizer(input, "/");
      }else if(input.contains("-")){
         in = new StringTokenizer(input, "-");
      }else{
         return;
      }
      //StringTokenizer in = new StringTokenizer(input, "/");
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

   /**
    * returns the day of the month the date is
    * @return the day int
    */
   public int getDay(){
      return day;
   }

   /**
    * returns the month the date is in
    * @return an int of the month
    */
   public int getMonth(){
      return month;
   }

   /**
    * returns the year the date is in
    * @return an int of the year
    */
   public int getYear() {
      return year;
   }

   /**
    * returns a string representing the date
    * @return String of the date
    */
   @Override
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

   /**
    * compares the string of two dates to tell if they are equal
    * @param o the object to be compared. is cast to a string
    * @return 0 if the dates are the same or -1
    */
   @Override
   public int compareTo(Object o) {
      if(this.toString().compareTo(o.toString()) == 0){
         return 0;
      }else{
         return - 1;
      }
   }
}