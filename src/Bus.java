import java.util.Calendar;

public abstract class Bus implements Comparable<Bus> {
    private static final String TIME_FORMAT = "%02d:%02d";

    private String busName;
    private Calendar departureTime;
    private Calendar arrivalTime;

    public Bus(String busName, Calendar departureTime, Calendar arrivalTime) {
        this.busName = busName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public int compareTo(Bus otherBus) {
        if (departureTime.compareTo(otherBus.getDepartureTime()) != 0) {
            return departureTime.compareTo(otherBus.getDepartureTime());
        }
        if (arrivalTime.compareTo(otherBus.getArrivalTime()) != 0) {
            return arrivalTime.compareTo(otherBus.getArrivalTime());
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(busName).append(" ");
        stringBuilder.append(String.format(TIME_FORMAT,
                departureTime.get(Calendar.HOUR_OF_DAY),
                departureTime.get(Calendar.MINUTE)))
                .append(" ");
        stringBuilder.append(String.format(TIME_FORMAT,
                arrivalTime.get(Calendar.HOUR_OF_DAY),
                arrivalTime.get(Calendar.MINUTE)))
                .append(" ");
        return stringBuilder.toString();
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
