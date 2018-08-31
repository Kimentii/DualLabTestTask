import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class FileUtils {

    public static BusRepository parseInputFile(String filePath) throws FileNotFoundException, ParseException {
        BusRepository busRepository = new BusRepository();
        File inputFile = new File(filePath);
        try (Scanner scanner = new Scanner(inputFile)) {
            BusFactory busFactory = new BusFactory();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                busFactory.getBus(line);
            }
        }
        return busRepository;
    }

    public static void writeRepositoryToFile(BusRepository busRepository, String filePath) {

    }

}
