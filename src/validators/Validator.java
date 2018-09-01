package validators;

import buses.Bus;

import java.util.ArrayList;

public interface Validator {
    boolean canBeAdded(ArrayList<Bus> buses, Bus bus);
}