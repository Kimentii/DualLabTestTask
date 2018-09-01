package repositories;

import buses.Bus;
import validators.EfficiencyValidator;
import validators.ServiceTimeSizeValidator;
import validators.Validator;

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

    public ArrayList<Bus> getValidatedBuses() {
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
        for (Bus b : getValidatedBuses()) {
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
                return false;
            }
        }
        return true;
    }
}
