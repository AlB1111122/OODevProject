import java.util.ArrayList;

public class Cheff extends Employee{
    private static int noCheffs = 0;
    private ArrayList<Dish> cookingDishes = new ArrayList<Dish>();
    private ArrayList<Dish> completeDishes = new ArrayList<Dish>();


    Cheff(String name, int phoneNumber){
        super(name, phoneNumber, "Ch" + noCheffs);
        noCheffs++;
    }

    public ArrayList<Dish> getCookingDishes() {
        return cookingDishes;
    }

    public void setRedy(Dish order){
    }

    public void setDishReady(int selection){
        cookingDishes.get(selection).setReady();
        completeDishes.add(cookingDishes.get(selection));
        cookingDishes.remove(selection);
    }
}
