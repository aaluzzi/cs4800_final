package cs4800;

import cs4800.entities.Customer;
import cs4800.entities.Driver;
import cs4800.entities.Order;
import cs4800.entities.Restaurant;
import cs4800.enums.County;
import cs4800.enums.Cuisine;
import cs4800.enums.DietRestriction;
import cs4800.enums.Shift;
import cs4800.foods.Carb;
import cs4800.foods.Fat;
import cs4800.foods.Macronutrient;
import cs4800.foods.Protein;
import cs4800.meals.Meal;
import cs4800.meals.MealDecorator;
import cs4800.menu.MenuBuilder;

public class Main {
    public static void main(String[] args) {
        DeliveryServer server = DeliveryServer.getInstance();

        Customer[] customers = getCustomers();
        for (Customer customer : customers) {
            server.registerCustomer(customer);
        }

        Driver[] drivers = getDrivers();
        for (Driver driver : drivers) {
            server.registerDriver(driver);
        }

        Restaurant[] restaurants = getRestaurants();
        for (Restaurant restaurant : restaurants) {
            server.registerRestaurant(restaurant);
        }

        Order order1 = customers[0].beginOrder("Dave's", "Chicken and rice with cheese");
        Driver order1Driver = order1.getDriver();
        
        order1Driver.pickupCurrentOrder();
        order1Driver.deliverCurrentOrder();

        order1.print();

        Order order2 = customers[5].beginOrder("Great Wall Chinese", "Kung Pao Chicken with Fried Rice");
        Driver order2Driver = order2.getDriver();

        order2Driver.pickupCurrentOrder();
        order2.print();
    }

    public static Customer[] getCustomers() {
        return new Customer[] {
            new Customer("Bob Michael", "123 Oak Lane", County.LOS_ANGELES, DietRestriction.VEGAN),
            new Customer("Alice Johnson", "456 Elm St", County.ORANGE, DietRestriction.PALEO),
            new Customer("Emily Brown", "789 Oak St", County.LOS_ANGELES, DietRestriction.VEGAN),
            new Customer("Jack Wilson", "321 Maple Ave", County.LOS_ANGELES, DietRestriction.NONE),
            new Customer("Sophia Garcia", "654 Pine St", County.SAN_BERNARDINO, DietRestriction.NUT_ALLERGY),
            new Customer("Daniel Martinez", "987 Cedar St", County.ORANGE, DietRestriction.NONE),
            new Customer("Olivia Rodriguez", "246 Birch St", County.SAN_BERNARDINO, DietRestriction.VEGAN),
            new Customer("Michael Taylor", "135 Walnut St", County.LOS_ANGELES, DietRestriction.NONE),
            new Customer("Emma Anderson", "579 Spruce St", County.ORANGE, DietRestriction.NONE),
            new Customer("William Clark", "468 Sycamore St", County.ORANGE, DietRestriction.PALEO)
        };
    }

    public static Driver[] getDrivers() {
        return new Driver[] {
            new Driver("Joey Swoley", "43 Barbell Ave", County.LOS_ANGELES, Shift.EARLY),
            new Driver("Alice Johnson", "123 Main St", County.ORANGE, Shift.LATE),
            new Driver("Bob Smith", "456 Elm St", County.SAN_BERNARDINO, Shift.EARLY),
            new Driver("Emily Brown", "789 Oak St", County.LOS_ANGELES, Shift.LATE),
            new Driver("Jack Wilson", "321 Maple Ave", County.ORANGE, Shift.OVERNIGHT),
            new Driver("Sophia Garcia", "654 Pine St", County.LOS_ANGELES, Shift.LATE),
            new Driver("Daniel Martinez", "987 Cedar St", County.LOS_ANGELES, Shift.OVERNIGHT),
            new Driver("Olivia Rodriguez", "246 Birch St", County.LOS_ANGELES, Shift.EARLY)
        };
    }

    public static Restaurant[] getRestaurants() {
        MenuBuilder mb = new MenuBuilder();

        Meal meal1 = new Meal(new Macronutrient[] {
            new Protein("Chicken", DietRestriction.VEGAN),
            new Carb("Rice"),
            new Fat("Butter", DietRestriction.VEGAN)
        });

        Meal meal2 = new Meal(new Macronutrient[] {
            new Protein("Steak", DietRestriction.VEGAN),
            new Carb("Potato"),
            new Fat("Egg", DietRestriction.VEGAN)
        });

        Meal meal3 = new Meal(new Macronutrient[] {
            new Protein("Salmon", DietRestriction.VEGAN),
            new Carb("Quinoa"),
            new Fat("Peanut Oil", DietRestriction.NUT_ALLERGY)
        });

        Meal meal4 = new Meal(new Macronutrient[] {
            new Protein("Beef", DietRestriction.VEGAN),
            new Carb("Sweet Potato"),
            new Fat("Avocado")
        });

        mb.addMeal("Chicken and rice", meal1)
            .addMeal("Steak and potato with egg", meal2)
            .addMeal("Salmon with quinoa", meal3)
            .addMeal("Beef and sweet potatoes", meal4)
            .addMeal("Chicken and rice with cheese", new MealDecorator(meal1, new Fat("Cheese")))
            .addMeal("Steak and potato with egg topped with onions", new MealDecorator(meal2, new Carb("Onion")))
            .addMeal("Salmon with quina and broccoli", new MealDecorator(meal3, new Carb("Broccoli")));

        Restaurant restaurant = new Restaurant("Dave's", "123 Cornflower Rd", County.LOS_ANGELES, Cuisine.ITALIAN, 8, 18, mb.build());

        mb = new MenuBuilder();

        Meal chineseMeal1 = new Meal(new Macronutrient[] {
            new Protein("Kung Pao Chicken", DietRestriction.VEGAN),
            new Carb("Fried Rice"),
            new Fat("Peanut Oil", DietRestriction.NUT_ALLERGY)
        });
    
        Meal chineseMeal2 = new Meal(new Macronutrient[] {
            new Protein("Mapo Tofu", DietRestriction.VEGAN),
            new Carb("Steamed Rice"),
            new Fat("Vegetable Oil")
        });
    
        Meal chineseMeal3 = new Meal(new Macronutrient[] {
            new Protein("Sweet and Sour Pork", DietRestriction.VEGAN),
            new Carb("Chow Mein"),
            new Fat("Canola Oil")
        });
    
        Meal chineseMeal4 = new Meal(new Macronutrient[] {
            new Protein("Beijing Duck", DietRestriction.VEGAN),
            new Carb("Peking Noodles"),
            new Fat("Duck Fat")
        });
    
        mb.addMeal("Kung Pao Chicken with Fried Rice", chineseMeal1)
            .addMeal("Mapo Tofu with Steamed Rice", chineseMeal2)
            .addMeal("Sweet and Sour Pork with Chow Mein", chineseMeal3)
            .addMeal("Beijing Duck with Peking Noodles", chineseMeal4)
            .addMeal("Kung Pao Chicken with Fried Rice and Carrots", new MealDecorator(chineseMeal4, new Carb("Carrots")))
            .addMeal("Kung Pao Chicken with Fried Rice and Broccoli", new MealDecorator(chineseMeal4, new Carb("Broccoli")))
            .addMeal("Sweet and Sour Pork with Chow Mein and Tofu", new MealDecorator(chineseMeal3, new Protein("Tofu")));
    
        Restaurant restaurant2 = new Restaurant("Great Wall Chinese", "456 Willow St", County.ORANGE, Cuisine.CHINESE, 10, 20, mb.build());
        
        return new Restaurant[] {restaurant, restaurant2};
    }
    
}