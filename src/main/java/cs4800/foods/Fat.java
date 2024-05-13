package cs4800.foods;

import cs4800.enums.DietRestriction;

public class Fat extends Macronutrient {

    public Fat(String food) {
        super(food);
    }

    public Fat(String food, DietRestriction unconsumableBy) {
        super(food, unconsumableBy);
    }

    @Override
    public String toString() {
        return "Fat: " + super.getFood();
    }
    
}
