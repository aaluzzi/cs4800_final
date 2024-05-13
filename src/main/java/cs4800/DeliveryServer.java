package cs4800;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import cs4800.entities.Customer;
import cs4800.entities.Driver;
import cs4800.entities.Order;
import cs4800.entities.Restaurant;
import cs4800.enums.County;
import cs4800.meals.RestrictableMeal;

public class DeliveryServer {

    private static DeliveryServer instance;

    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Driver> drivers = new ArrayList<>();
    private HashMap<String, Restaurant> restaurants = new HashMap<>();
    private HashMap<Driver, Order> activeOrders = new HashMap<>();

    private DeliveryServer() {
    }

    public static DeliveryServer getInstance() {
        if (instance == null) {
            instance = new DeliveryServer();
        }
        return instance;
    }

    public void registerCustomer(Customer customer) {
        customer.setMediator(this);
        customers.add(customer);
    }

    public void registerDriver(Driver driver) {
        driver.setMediator(this);
        drivers.add(driver);
    }

    public void registerRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getName(), restaurant);
    }

    public Order createOrder(Customer customer, String restaurantName, String mealName) {
        Restaurant restaurant = restaurants.get(restaurantName);
        RestrictableMeal meal = restaurant.getMenu().getMeal(mealName);
        Driver driver = getFreeDriverIn(customer.getCounty());
        if (restaurant != null && restaurant.isOpenAt(getCurrentHour()) && meal != null && driver != null) {
            Order order = new Order(restaurant, customer, driver, meal.getFoodsFor(customer.getDietRestriction()));
            activeOrders.put(driver, order);
            return order;
        }
        return null;
    }

    private Driver getFreeDriverIn(County county) {
        for (Driver driver : drivers) {
            if (!activeOrders.containsKey(driver)
                    && driver.getCounty() == county
                    && driver.isWorkingAt(getCurrentHour())) {
                return driver;
            }
        }
        return null;
    }

    public void markOrderAsPickedUp(Driver driver) {
        Order order = activeOrders.get(driver);
        if (order != null) {
            order.pickup();
        }
    }

    public void markOrderAsDelivered(Driver driver) {
        Order order = activeOrders.get(driver);
        if (order != null) {
            order.deliver();
            activeOrders.remove(driver);
        }
    }

    public Object getCurrentOrder(Driver driver) {
        return activeOrders.get(driver);
    }

    private int getCurrentHour() {
        return LocalTime.now().getHour();
    }

}
