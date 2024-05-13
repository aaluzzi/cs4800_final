package cs4800.meals;

import java.util.ArrayList;

import cs4800.enums.DietRestriction;
import cs4800.foods.Macronutrient;

public class Meal implements RestrictableMeal {

    private final Macronutrient[] foods;

    public Meal(Macronutrient[] foods) {
        this.foods = foods;
    }

    public ArrayList<Macronutrient> getFoodsFor(DietRestriction restriction) {
        ArrayList<Macronutrient> safeFoods = new ArrayList<>();
        for (Macronutrient food : foods) {
            if (food.safeToEatFor(restriction)) {
                safeFoods.add(food);
            }
        }
        return safeFoods;
    }

}
