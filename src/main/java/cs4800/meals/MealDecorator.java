package cs4800.meals;

import java.util.ArrayList;

import cs4800.enums.DietRestriction;
import cs4800.foods.Macronutrient;

public class MealDecorator  implements RestrictableMeal {

    private final RestrictableMeal wrapee;
    private final Macronutrient topping;

    public MealDecorator(RestrictableMeal wrapee, Macronutrient topping) {
        this.wrapee = wrapee;
        this.topping = topping;
    }

    @Override
    public ArrayList<Macronutrient> getFoodsFor(DietRestriction restriction) {
        ArrayList<Macronutrient> originalMeal = wrapee.getFoodsFor(restriction);
        if (topping.safeToEatFor(restriction)) {
            originalMeal.add(topping);
        }
        return originalMeal;
    }

}
