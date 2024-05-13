package cs4800.entities;
import java.time.Instant;
import java.util.ArrayList;

import cs4800.foods.Macronutrient;

public class Order {

    private final Restaurant restaurant;
    private final Customer customer;
    private final Driver driver;
    private final ArrayList<Macronutrient> foods;
    private final Instant creationTime;
    private Instant pickupTime;
    private Instant deliveredTime;

    public Order(Restaurant restaurant, Customer customer, Driver driver, ArrayList<Macronutrient> foods) {
        this.restaurant = restaurant;
        this.customer = customer;
        this.driver = driver;
        this.foods = foods;
        this.creationTime = Instant.now();
        this.pickupTime = null;
        this.deliveredTime = null;
    }

    public Driver getDriver() {
        return driver;
    }

    public void pickup() {
        this.pickupTime = Instant.now();
    }

    public void deliver() {
        this.deliveredTime = Instant.now();
    }

    public void print() {
        System.out.println("Order:\nCUSTOMER:\n" + customer.toString() 
                + "\n\nRESTAURANT:\n" + restaurant.toString() 
                + "\n\nDRIVER:\n" + driver.toString() 
                + "\n\nITEMS:\n" + foods.toString()
                + "\n\nCreated: " + creationTime
                + "\nPicked up: " + pickupTime
                + "\nDelivered: " + deliveredTime); 
    }

}
