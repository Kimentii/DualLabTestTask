import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class Main {
    private static final String OUTPUT_FILE_NAME = "output.txt";

    public static void main(String[] args) {
        String filePath = args[0];
        System.out.println("File path: " + filePath);
        BusRepository busRepository = null;
        try {
            busRepository = FileUtils.parseInputFile(filePath);
            showBuses(busRepository);
            FileUtils.writeRepositoryToFile(busRepository, OUTPUT_FILE_NAME);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void showBuses(BusRepository busRepository) {
        for (Bus bus : busRepository.getBuses()) {
            System.out.println(bus.toString());
        }
    }
}
