import java.util.Calendar;

public abstract class Bus {
    private String busName;
    private Calendar departureTime;
    private Calendar arrivalTime;

    public Bus(String busName, Calendar departureTime, Calendar arrivalTime) {
        this.busName = busName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getBusName() {
        return busName;
    }

    public Calendar getDepartureTime() {
        return departureTime;
    }

    public Calendar getArrivalTime() {
        return arrivalTime;
    }
}
