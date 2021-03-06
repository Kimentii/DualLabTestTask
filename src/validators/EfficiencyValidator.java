package validators;

import buses.Bus;
import buses.GrottyBus;
import buses.PoshBus;

import java.util.ArrayList;

public class EfficiencyValidator implements Validator {

    @Override
    public boolean canBeAdded(ArrayList<Bus> buses, Bus bus) {
        for (Bus b : buses) {
            if (b.getDepartureTime().equals(bus.getDepartureTime())
                    && b.getArrivalTime().compareTo(bus.getArrivalTime()) < 0) {
                return false;
            }
            if (b.getDepartureTime().compareTo(bus.getDepartureTime()) > 0
                    && b.getArrivalTime().compareTo(bus.getArrivalTime()) <= 0) {
                return false;
            }
            if (bus instanceof GrottyBus
                    && b instanceof PoshBus
                    && b.getDepartureTime().equals(bus.getDepartureTime())
                    && b.getArrivalTime().equals(bus.getArrivalTime())) {
                return false;
            }
        }
        return true;
    }
}
