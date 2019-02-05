package hello;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//This class allows extract the information from text file
//and process them


public class ReaderFile {
    private static FileInputStream inputStream = null;
    private static Scanner sc = null;
    private static String baseCodificator;
    private static List<String> outputByCity = new ArrayList<>();
    private static List<String> outputById = new ArrayList<>();

    //the method readData extract the information line by line, deciding, according to the argument, the processing of the information that must be done

    public static void readData(String path, String argument, String searchCriteria) throws IOException {
        File file = new File(path);

        try {
            inputStream = new FileInputStream(file.getAbsolutePath());
            sc = new Scanner(inputStream, "UTF-8");

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                line = line.toUpperCase();

                if (line.startsWith("F")) {
                    baseCodificator = line;
                } else if (line.startsWith("D")) {
                    String[] result = (formatLine(line, baseCodificator));
                    functionIndicator(argument, searchCriteria, result);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally

        {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }

    }

    //this method permit according to the indicator the kind of function to classify the output
    public static void functionIndicator(String argument, String searchCriteria, String[] result) {
        if ((result[1].contains(searchCriteria)) && (argument.equals("CITY"))) {
            if (outputById == null || outputByCity.size() == 0) {
                System.out.println(result[0] + ", " + result[2]);
                outputByCity.add(result[0]);

            } else {
                isCityRepeated(result);
            }
        } else if (result[2].contains(searchCriteria)) {
            if (outputById == null || outputById.size() == 0) {
                System.out.println(result[1]);
                outputById.add(result[1]);
            } else {
                isRepeatedById(result);
            }
        }
    }
//this method check if is already printed the city with the id in this result, if no exist, this method will print the city
    public static void isRepeatedById(String[] result) {
        boolean is = false;
        for (int i = 0; i < outputById.size(); i++) {
            if (outputById.get(i).contains(result[2])) {
                is=true;
                }
        }
        if (!is){
            System.out.println(result[1]);
            outputById.add(result[2]);

        }
    }
    //this method check if is already printed the name and id with the city in this result, if no exist, this method will print the name and id.
    public static void isCityRepeated(String[] result) {
        boolean is = false;
        for (int i = 0; i < outputByCity.size(); i++) {
            if (outputByCity.get(i).contains(result[0])) {
                is = true;
            }
        }
        if (!is) {
            System.out.println(result[0] + ", " + result[2]);
            outputByCity.add(result[0]);
        }
    }

    //the method formatLine process the information and retuned it, cleaning all lines deleting unnecesary information and formating this.
    public static String[] formatLine(String line, String baseCodificator) {
        String chain = line.substring(2);
        String[] fragments = new String[0];
        if (baseCodificator.equals("F1")) {
            fragments = chain.split(",");
        } else if ((baseCodificator.equals("F2")) || (baseCodificator.equals("F2 "))) {
            chain = chain.replace("-", "");
            fragments = chain.split(" ; ");
        }
        return fragments;
    }
}
