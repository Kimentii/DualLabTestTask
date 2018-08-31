import java.util.ArrayList;

public class BusRepository {
    private ArrayList<Bus> buses;

    public void addBas(Bus bus) {
        buses.add(bus);
    }

    public ArrayList<Bus> getBuses() {
        return buses;
    }
}
