import java.util.ArrayList;

public class Waiter extends Employee{
    private static int noWaiters = 0;

    Waiter(String name, int phoneNumber){
        super(name, phoneNumber, "W" + noWaiters);
        noWaiters++;
    }

    public void makeOrder(){

    }



}
