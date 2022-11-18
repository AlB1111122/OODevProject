//package org.calender;

import com.sun.source.tree.UsesTree;
import com.sun.source.tree.WhileLoopTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class   Customermenu {
   private  HashMap<String ,Double>  customerDishesSection = new HashMap<String ,Double>() ;
    private Scanner in;

    /**
     * Constructs an Customnu object.
     */
    public Customermenu() {
        in = new Scanner(System.in);
    }

    /**
     * Runs the system. a customer can review the menu dishes
     *
     */
    Dish dish = new Dish ();
    String[] dishes = dish.getdishes();
    double [] dishesPrice  = dish.getdishesPrise();
    public void run( ) {


        boolean more = true;
            //  AppointmentCalendar calendar = new AppointmentCalendar();
            //   customeer  review the menu
         // after select  item or dish
         // checch if the dish is in the kist of dish

        //Dish dish = new Dish ();


        while (more) {

                String  command = in.nextLine().toUpperCase();
                System.out.println("Please enter a validation selection");
                System.out.println("r) eview mun ) A) add order   C)ancel  S)how  Q)uit");
                command = in.nextLine().toUpperCase();

                if (command.equals("r")) {
                    System.out.println("see all dish on scree ");
                    //Dish dish = new Dish ();

                    for (int i =0;i<dish.getdishes().length; i++){
                        String[] dishes = dish.getdishes();
                        double [] dishesPrice  = dish.getdishesPrise();
                        System.out.println( "dish number " + i + " name of the dish"  +dishes[i].toString() +" price"+dishesPrice [i]);
                        System.out.println( );

                    }//after see the menu a customer select dishes . so well staore all sect of customer in a new Arralist

                    System.out.println("how many  dish do you want to select enter nummer  ? : ");
                    int howManydish   = in.nextInt();

                    int i =0;
                     while (i !=howManydish ) {
                        System.out.println("select dish  number  : ");
                        int dishnmber = in.nextInt();
                        customerDishesSection.put(dishes[dishnmber], dishesPrice[dishnmber]);
                         i ++;
                    }

                } else if (command.equals("C")) {
                    System.out.println("do nothing exist the menu ");
                    more = false;
                }
            }
        }
  }

