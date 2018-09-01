package factories;

import buses.Bus;
import buses.GrottyBus;
import buses.PoshBus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BusFactory {
    private static final String TIME_FORMAT = "HH:mm";

    public Bus getBus(String busDescription) throws ParseException {
        String[] busInfoStrs = busDescription.split(" ");
        String busName = busInfoStrs[0];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT);
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
