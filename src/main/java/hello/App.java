package hello;

import java.io.File;
import java.io.IOException;


//Init app for search by criteria
// @param args
// fileName = args[0], path to load the text file
// argument = args[1], must be the value {ID} or {CITY} to specify the search field
// searchCriteria = args[2], must be {ID value} or {CITY name} for specify the field value to search

public class App {
    public static void main(String[] args) throws IOException {

        if (args.length == 3) {
            String fileName = args[0];
            String argument = args[1].toUpperCase();
            String searchCriteria = args[2].toUpperCase();

            File file = new File(fileName);
            if (file.exists())
                ReaderFile.readData(fileName, argument, searchCriteria);
            else
                System.out.println("You must provide a valid file");

        } else {
            System.out.println("You must enter all arguments");
        }
    }
}

