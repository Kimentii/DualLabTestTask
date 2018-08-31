import java.util.ArrayList;

public class BusRepository {
    private ArrayList<Bus> buses = new ArrayList<>();
    private ArrayList<Validator> validators;

    public BusRepository() {
        validators = new ArrayList<>();
        validators.add(new TripTimeValidator());
    }

    public void addBas(Bus bus) {
        if (canBeAdded(bus)) {
            buses.add(bus);
        }
    }

    public ArrayList<Bus> getBuses() {
        return buses;
    }

    private boolean canBeAdded(Bus bus) {
        for (Validator v : validators) {
            if (!v.canBeAdded(buses, bus)) {
                return false;
            }
        }
        return true;
    }
}
