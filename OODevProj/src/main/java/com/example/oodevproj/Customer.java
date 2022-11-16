public class Customer extends Person{
    private static int noCustomers = 0;

    Customer(String name, int phoneNumber){
        super(name, phoneNumber);
        super.setID("C" + noCustomers);
        noCustomers++;
    }


}
