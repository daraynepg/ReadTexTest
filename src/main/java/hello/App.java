package hello;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        ReaderFile readerFile = new ReaderFile();
        readerFile.readData("D:\\data.txt", "CITY", "LAS VEGAS");
        if (args.length == 3) {
            String fileName = args[0];
            String argument = args[1].toUpperCase();
            String searchCriteria = args[2].toUpperCase();

            File file = new File(fileName);

            if (file.exists())
                readerFile.readData("D:\\data.txt", "ID", "54315871Z");
            else
                System.out.println("Please, you must provide a valid file to process!");

        } else {
            System.out.println("Please, you must enter all the necessary arguments!");
        }
    }
}

