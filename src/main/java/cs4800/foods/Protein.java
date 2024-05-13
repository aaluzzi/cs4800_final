package cs4800.foods;

import cs4800.enums.DietRestriction;

public class Protein extends Macronutrient {

    public Protein(String food) {
        super(food);
    }

    public Protein(String food, DietRestriction unconsumableBy) {
        super(food, unconsumableBy);
    }

    @Override
    public String toString() {
        return "Protein: " + super.getFood();
    }
    
}
