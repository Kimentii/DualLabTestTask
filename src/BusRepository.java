import java.util.ArrayList;
import java.util.Collections;

public class BusRepository {
    private ArrayList<Bus> buses = new ArrayList<>();
    private ArrayList<Validator> validators;

    public BusRepository() {
        validators = new ArrayList<>();
        validators.add(new ServiceTimeSizeValidator());
        validators.add(new EfficiencyValidator());
    }

    public void addBas(Bus bus) {
        buses.add(bus);
    }

    public ArrayList<Bus> getBuses() {
        ArrayList<Bus> validatedBuses = new ArrayList<>();
        for (Bus b : buses) {
            if (canBeAdded(b)) {
                validatedBuses.add(b);
            }
        }
        return validatedBuses;
    }

    public <T extends Bus> ArrayList<T> getTypedBuses(Class<T> busClass) {
        ArrayList<T> typedBuses = new ArrayList<>();
        for (Bus b : buses) {
            if (b.getClass().equals(busClass)) {
                typedBuses.add((T) b);
            }
        }
        Collections.sort(typedBuses);
        return typedBuses;
    }

    private boolean canBeAdded(Bus bus) {
        for (Validator v : validators) {
            if (!v.canBeAdded(buses, bus)) {
                // System.out.println("Can't be added because of " + v.getClass().getSimpleName());
                return false;
            }
        }
        return true;
    }
}
