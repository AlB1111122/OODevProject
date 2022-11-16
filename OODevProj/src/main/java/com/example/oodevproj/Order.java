import java.util.ArrayList;

public class Order{
    private ArrayList<Dish> dishes = new ArrayList<Dish>();
    private String waiterID;
    private Customer customer;

    Order(String waiterID, Customer customer, ArrayList<Dish> dishes){
        this.customer = customer;
        this.waiterID = waiterID;
        this.dishes = dishes;
    }
}
