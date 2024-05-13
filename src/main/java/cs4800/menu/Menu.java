package cs4800.menu;

import java.util.HashMap;

import cs4800.meals.RestrictableMeal;

public class Menu {

    private final HashMap<String, RestrictableMeal> meals;

    public Menu(HashMap<String, RestrictableMeal> meals) {
        this.meals = meals;
    }

    public RestrictableMeal getMeal(String mealName) {
        return meals.get(mealName);
    }
}
