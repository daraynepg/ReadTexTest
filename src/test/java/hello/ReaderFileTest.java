package hello;

import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ReaderFileTest {
    String line = "D Rhonda Hopkins ; BARCELONA ; 54315871-Z";
    String line2 = "D Lowell Miles,BARCELONA,04217040J";
    String baseCodificator = "F2";
    String baseCodificator2 = "F1";
    String[] textFormated = {"Rhonda Hopkins", "BARCELONA", "54315871Z"};
    String[] textFormated2 = {"Lowell Miles", "BARCELONA", "04217040J"};
    private String sourceFile = "src/resources/data.txt";


//This method tests the information load, requesting it by Id
    @Test
    public void readDataByID() throws Exception {
        ReaderFile.readData(sourceFile, "ID", "69429384C"); //Russell Pope,BARCELONA,69429384C

    }
    //This method tests the information load, requesting it by City
    @Test
    public void readDataByCity() throws Exception {
        ReaderFile.readData(sourceFile, "CITY", "BARCELONA"); //Russell Pope,BARCELONA,69429384C

    }

    @Test
    public void formatLine() throws Exception {
        assertArrayEquals("formated text", textFormated, ReaderFile.formatLine(line, baseCodificator));
        assertArrayEquals("formated text", textFormated2, ReaderFile.formatLine(line2, baseCodificator2));
    }

}