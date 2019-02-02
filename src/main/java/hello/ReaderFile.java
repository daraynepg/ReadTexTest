package hello;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//This class allows extract the information from text file
//and process them
//the method readData extract the information line by line
//the method formatLine process the information and retuned it.
public class ReaderFile {
   public static FileInputStream inputStream = null;
    public static Scanner sc = null;
    public static String baseCodificator;
    public static List<String> outputByCity = new ArrayList<>();
    public static List<String> outputById = new ArrayList<>();

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
                    continue;
                } else if (line.startsWith("D")) {
                    String[] result = (formatLine(line, baseCodificator));
                    if ((result[1].contains(searchCriteria)) && (argument.equals("CITY"))) {
                        if (outputByCity.size() == 0 || outputById == null) {
                            System.out.println(result[0] + ", " + result[2]);
                            outputByCity.add(result[0]);

                        } else if (outputByCity.size() > 0) {
                            boolean is=false;
                            for (int i = 0; i < outputByCity.size(); i++) {
                                if (outputByCity.get(i).contains(result[0])) {
                                   is=true;
                                }
                            }
                            if (is==false){
                                System.out.println(result[0] + ", " + result[2]);
                                outputByCity.add(result[0]);
                            }
                        }
                    } else if (result[2].contains(searchCriteria)) {
                        if (outputById == null || outputById.size() == 0) {
                            System.out.println(result[1]);
                            outputById.add(result[1]);
                        } else if (outputById.size() > 0) {
                            for (int i = 0; i < outputById.size(); i++) {
                                if (!outputById.get(i).contains(result[2])) {
                                    System.out.println(result[1]);
                                    outputById.add(result[2]);
                                }
                            }
                        }
                    }
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
