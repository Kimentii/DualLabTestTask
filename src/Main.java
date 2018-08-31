import java.io.FileNotFoundException;
import java.text.ParseException;

public class Main {
    private static final String OUTPUT_FILE_NAME = "output.txt";

    public static void main(String[] args) {
        String filePath = args[0];
        System.out.println("File path: " + filePath);
        BusRepository busRepository = null;
        try {
            busRepository = FileUtils.parseInputFile(filePath);
            FileUtils.writeRepositoryToFile(busRepository, OUTPUT_FILE_NAME);
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }

    }
}
