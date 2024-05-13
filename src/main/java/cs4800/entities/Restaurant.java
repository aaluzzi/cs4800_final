package cs4800.entities;

import cs4800.enums.Cuisine;
import cs4800.menu.Menu;
import cs4800.enums.County;

public class Restaurant {

    private final String name;
    private final String address;
    private final County county;
    private final Cuisine cuisine;
    private final int startHour;
    private final int endHour;
    private final Menu menu;

    public Restaurant(String name, String address, County county, Cuisine cuisine, int startHour, int endHour, Menu menu) {
        this.name = name;
        this.address = address;
        this.county = county;
        this.cuisine = cuisine;
        this.startHour = startHour;
        this.endHour = endHour;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public Menu getMenu() {
        return menu;
    }

    public boolean isOpenAt(int hour) {
        return startHour <= hour && endHour >= hour;
    }

    @Override
    public String toString() {
        return name + "\n" + address;
    }

}
