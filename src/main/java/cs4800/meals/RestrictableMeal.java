package cs4800.meals;

import java.util.ArrayList;

import cs4800.enums.DietRestriction;
import cs4800.foods.Macronutrient;

public interface RestrictableMeal {

    public ArrayList<Macronutrient> getFoodsFor(DietRestriction restriction);

}
