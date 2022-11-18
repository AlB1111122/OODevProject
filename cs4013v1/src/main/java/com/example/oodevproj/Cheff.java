package com.example.oodevproj;
import java.util.ArrayList;

public class Cheff extends Employee{
    private static int noCheffs = 0;
    private Dish cookingDish;

    Cheff(String name, int phoneNumber){
        super(name, phoneNumber, "Ch" + noCheffs);
        noCheffs++;
    }

    public Dish getCookingDish() {
        return cookingDish;
    }

    public void setCookingDish(Dish cookingDish) {
        if(this.cookingDish == null) {
            this.cookingDish = cookingDish;
        }
    }

    public void setCookingDishReady(){
       if(!(cookingDish == null)){
           cookingDish.setReady();
           cookingDish = null;
       }
    }
}
