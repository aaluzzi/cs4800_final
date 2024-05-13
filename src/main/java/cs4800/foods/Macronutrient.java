package cs4800.foods;

import cs4800.enums.DietRestriction;

public abstract class Macronutrient {

    private final String food;
    private final DietRestriction unconsumableBy;

    public Macronutrient(String food) {
        this(food, null);
    }

    public Macronutrient(String food, DietRestriction unconsumableBy) {
        this.food = food;
        this.unconsumableBy = unconsumableBy;
    }

    public String getFood() {
        return food;
    }

    public boolean safeToEatFor(DietRestriction restriction) {
        return restriction != unconsumableBy;
    }

}
