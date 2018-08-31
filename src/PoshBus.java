import java.util.Calendar;

public class PoshBus extends Bus {
    public static final String BUS_NAME = "Posh";

    public PoshBus(Calendar departureTime, Calendar arrivalTime) {
        super(BUS_NAME, departureTime, arrivalTime);
    }
}
