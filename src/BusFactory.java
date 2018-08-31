import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BusFactory {
    public Bus getBus(String busDescription) throws ParseException {
        String[] busInfoStrs = busDescription.split(" ");
        String busName = busInfoStrs[0];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
        Calendar departureTime = Calendar.getInstance();
        departureTime.setTime(simpleDateFormat.parse(busInfoStrs[1]));
        Calendar arrivalTime = Calendar.getInstance();
        arrivalTime.setTime(simpleDateFormat.parse(busInfoStrs[2]));
        Bus bus = null;
        if (busName.equals(GrottyBus.BUS_NAME)) {
            bus = new GrottyBus(departureTime, arrivalTime);
        } else if (busName.equals(PoshBus.BUS_NAME)) {
            bus = new PoshBus(departureTime, arrivalTime);
        }
        return bus;
    }
}
