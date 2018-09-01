import java.util.ArrayList;

public class EfficiencyValidator implements Validator {

    @Override
    public boolean canBeAdded(ArrayList<Bus> buses, Bus bus) {
        for (Bus b : buses) {
            if (b.getDepartureTime().compareTo(bus.getDepartureTime()) == 0
                    && b.getArrivalTime().compareTo(bus.getArrivalTime()) < 0) {
                return false;
            }
            if (b.getDepartureTime().compareTo(bus.getDepartureTime()) > 0
                    && b.getArrivalTime().compareTo(bus.getArrivalTime()) <= 0) {
                return false;
            }
        }
        return true;
    }
}
