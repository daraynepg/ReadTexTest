package hello;

import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;

import static org.junit.Assert.*;

public class ReaderFileTest {
    private String[] textFormated = {"Rhonda Hopkins", "BARCELONA", "54315871Z"};
    private String[] textFormated2 = {"Lowell Miles", "BARCELONA", "04217040J"};
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
        String line = "D Rhonda Hopkins,BARCELONA,54315871Z";
        String baseCodificator = "F1";
        assertArrayEquals("formated text", textFormated, ReaderFile.formatLine(line, baseCodificator));
        String line2 = "D Lowell Miles ; BARCELONA ; 04217040-J";
        String baseCodificator2 = "F2";
        assertArrayEquals("formated text", textFormated2, ReaderFile.formatLine(line2, baseCodificator2));
    }

    @Test
    public void functionIndicatorTest()throws Exception{
        String argument= "ID";
        String searchCriteria="04810023X";
        String [] result= {"Susan Holland","SAN FRANCISCO","04810023X "};
        ReaderFile.functionIndicator(argument, searchCriteria, result);
    }

    @Test
    public void isRepeatedByIdTest() throws Exception{
        String [] result= {"Russell Pope","BARCELONA","69429384C"};
        ReaderFile.isRepeatedById(result);
    }
    @Test
    public void isCityRepeatedTest() throws Exception{
        String [] result= {"Shelley Payne","MADRID","54808168L"};
        ReaderFile.isCityRepeated(result);
    }
}