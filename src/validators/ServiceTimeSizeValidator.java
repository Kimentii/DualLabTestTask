package validators;

import buses.Bus;

import java.util.ArrayList;

public class ServiceTimeSizeValidator implements Validator {
    private static final long MS_PER_HOUR = 3_600_000;

    @Override
    public boolean canBeAdded(ArrayList<Bus> buses, Bus bus) {
        long departureTime = bus.getDepartureTime().getTimeInMillis();
        long arrivalTime = bus.getArrivalTime().getTimeInMillis();
        long period = arrivalTime - departureTime;
        return period <= MS_PER_HOUR;
    }
}
