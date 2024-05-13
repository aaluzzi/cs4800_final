package cs4800.entities;

import cs4800.enums.DietRestriction;
import cs4800.DeliveryServer;
import cs4800.enums.County;

public class Customer {

    private final String name;
    private final String address;
    private final County county;
    private final DietRestriction restriction;

    private DeliveryServer mediator;

    public Customer(String name, String address, County county, DietRestriction restriction) {
        this.name = name;
        this.address = address;
        this.county = county;
        this.restriction = restriction;
    }

    public void setMediator(DeliveryServer mediator) {
        this.mediator = mediator;
    }

    public Order beginOrder(String restaurantName, String mealName) {
        return mediator.createOrder(this, restaurantName, mealName);
    }

    public County getCounty() {
        return county;
    }

    public DietRestriction getDietRestriction() {
        return restriction;
    }

    @Override
    public String toString() {
        return name + "\n" + address + "\n" + county + "\nRestriction: " + restriction;
    }

}
