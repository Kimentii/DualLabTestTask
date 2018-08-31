import java.util.ArrayList;

public class BusRepository {
    private ArrayList<Bus> buses = new ArrayList<>();

    public void addBas(Bus bus) {
        buses.add(bus);
    }

    public ArrayList<Bus> getBuses() {
        return buses;
    }
}
