import javafx.geometry.Pos;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtils {

    public static BusRepository parseInputFile(String filePath) throws FileNotFoundException, ParseException {
        BusRepository busRepository = new BusRepository();
        File inputFile = new File(filePath);
        try (Scanner scanner = new Scanner(inputFile)) {
            BusFactory busFactory = new BusFactory();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Bus bus = busFactory.getBus(line);
                busRepository.addBas(bus);
            }
        }
        return busRepository;
    }

    public static void writeRepositoryToFile(BusRepository busRepository, String filePath) throws IOException {
        ArrayList<GrottyBus> grottyBuses = busRepository.getTypedBuses(GrottyBus.class);
        ArrayList<PoshBus> poshBuses = busRepository.getTypedBuses(PoshBus.class);

        File outputFile = new File(filePath);
        FileWriter fileWriter = new FileWriter(outputFile);
        for (PoshBus poshBus : poshBuses) {
            fileWriter.write(poshBus.toString() + "\n");
        }
        fileWriter.write("\n");
        for (GrottyBus grottyBus : grottyBuses) {
            fileWriter.write(grottyBus.toString() + "\n");
        }
        fileWriter.close();
    }

}
