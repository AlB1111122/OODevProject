import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import  java .util.ArrayList;
import java .io.File;
import java.io.PrintWriter;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
       //creat a customer
        Person jhon  = new Person("Id : 8908","name : jho  ",99  ) ;
         Person Aly  = new Person("id : 8907"," name: lili  ",99 ) ;
         //store customer in a list
        ArrayList<Person> Listofperson = new   ArrayList<Person>();
        Listofperson.add( jhon);
        Listofperson.add( Aly);
        // creat a File and store the Arraylist in so the file will keep each customer in by write in
        File csvfile = new   File ("Listofperson.csv");// name of the file
        PrintWriter outfile = new PrintWriter(csvfile); // write in the
        for (Person customers :  Listofperson){
         //   write in the in file add on it customer
           outfile. printf("%s,%s,%d \n,",customers.getID(),customers.getName(),customers.getPhoneNumber());

        }
        outfile.close(); // close the file



         System.out.println( Listofperson.get(1).toString());
       // System.out.println(personjhon.getName());





        //System.out.println();





      // System.out.println(Employee .toString( "Dideir ", 99867, "manager " ,"food and beverage "  ));
    }
}