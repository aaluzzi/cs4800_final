package cs4800.entities;

import cs4800.DeliveryServer;
import cs4800.enums.County;
import cs4800.enums.Shift;

public class Driver {

    private final String name;
    private final String address;
    private final County county;
    private final Shift shift;

    private DeliveryServer mediator;

    public Driver(String name, String address, County county, Shift shift) {
        this.name = name;
        this.address = address;
        this.county = county;
        this.shift = shift;
    }

    public County getCounty() {
        return county;
    }

    public boolean isWorkingAt(int hour) {
        return shift.getStartHour() <= hour && shift.getEndHour() >= hour;
    }

    public void setMediator(DeliveryServer mediator) {
        this.mediator = mediator;
    }

    public void pickupCurrentOrder() {
        mediator.markOrderAsPickedUp(this);
    }

    public void deliverCurrentOrder() {
        mediator.markOrderAsDelivered(this);
    }

    public String toString() {
        return name + "\n" + address + "\n" + county;
    }

}
