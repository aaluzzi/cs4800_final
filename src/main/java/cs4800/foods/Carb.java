package cs4800.foods;

import cs4800.enums.DietRestriction;

public class Carb extends Macronutrient {

    public Carb(String food) {
        super(food);
    }

    public Carb(String food, DietRestriction unconsumableBy) {
        super(food, unconsumableBy);
    }

    @Override
    public String toString() {
        return "Carb: " + super.getFood();
    }
    
}
