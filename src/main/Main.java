package main;

import buses.Bus;
import repositories.BusRepository;
import utils.FileUtils;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    private static final String OUTPUT_FILE_NAME = "output.txt";

    public static void main(String[] args) {
        String filePath = args[0];
        BusRepository busRepository = null;
        try {
            busRepository = FileUtils.parseInputFile(filePath);
            FileUtils.writeRepositoryToFile(busRepository, OUTPUT_FILE_NAME);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
