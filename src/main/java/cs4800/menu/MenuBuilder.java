package cs4800.menu;

import java.util.HashMap;

import cs4800.meals.RestrictableMeal;

public class MenuBuilder {

    HashMap<String, RestrictableMeal> meals;

    public MenuBuilder() {
        this.meals = new HashMap<>();
    }

    public MenuBuilder addMeal(String mealName, RestrictableMeal meal) {
        meals.put(mealName, meal);
        return this;
    }

    public Menu build() {
        return new Menu(meals);
    }

}
