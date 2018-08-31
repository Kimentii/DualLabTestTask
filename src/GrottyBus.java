import java.util.Calendar;

public class GrottyBus extends Bus {
    public static final String BUS_NAME = "Grotty";

    public GrottyBus(Calendar departureTime, Calendar arrivalTime) {
        super(BUS_NAME, departureTime, arrivalTime);
    }
}
