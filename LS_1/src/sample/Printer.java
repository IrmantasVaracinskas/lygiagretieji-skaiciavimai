package sample;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Irmis on 2017-02-22.
 */
public class Printer {
    private static final String[] HEADER = {"Continent", "Country", "Column", "Column2", "Column3", "Column4", "Column5",
            "Column6", "Column7", "Column8", "Column9"};
    private FileReader fileReader = null;
    private CSVParser csvFileParser = null;
    private CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(HEADER);
    private String filename = "Countries-Continents.csv";
    private List<CSVRecord> csvRecords = null;

    public Printer() throws IOException {
        fileReader = new FileReader(filename);
        csvFileParser = new CSVParser(fileReader, csvFileFormat);
        csvRecords = csvFileParser.getRecords();
        csvFileParser.close();
    }
    public synchronized void writeTime(Region region) throws InterruptedException {
        switch (region) {
            case AFRICA: {
                System.out.println("Countries in Africa:");

                for(int i = 1; i < csvRecords.size(); i++){
                    CSVRecord record = csvRecords.get(i);

                    if(record.get("Continent").equals("Africa")){
                        System.out.println("   " + record.get("Country"));
                    }
                }
                break;
            }
            case ASIA: {
                System.out.println("Countries in Asia:");

                for(int i = 1; i < csvRecords.size(); i++){
                    CSVRecord record = csvRecords.get(i);

                    if(record.get("Continent").equals("Asia")){
                        System.out.println("   " + record.get("Country"));
                    }
                }
                break;
            }
            case EUROPE: {
                System.out.println("Countries in Europe:");

                for(int i = 1; i < csvRecords.size(); i++){
                    CSVRecord record = csvRecords.get(i);

                    if(record.get("Continent").equals("Europe")){
                        System.out.println("   " + record.get("Country"));
                    }
                }
                break;
            }

            case NORTH_AMERICA: {
                System.out.println("Countries in North America:");

                for(int i = 1; i < csvRecords.size(); i++){
                    CSVRecord record = csvRecords.get(i);

                    if(record.get("Continent").equals("North America")){
                        System.out.println("   " + record.get("Country"));
                    }
                }
                break;
            }

            case OCEANIA: {
                System.out.println("Countries in Oceania:");

                for(int i = 1; i < csvRecords.size(); i++){
                    CSVRecord record = csvRecords.get(i);

                    if(record.get("Continent").equals("Oceania")){
                        System.out.println("   " + record.get("Country"));
                    }
                }
                break;
            }

            case SOUTH_AMERICA: {
                System.out.println("Countries in South America:");

                for(int i = 1; i < csvRecords.size(); i++){
                    CSVRecord record = csvRecords.get(i);
                    if(record.get("Continent").equals("South America")){
                        System.out.println("   " + record.get("Country"));
                    }
                }
                break;
            }
        }
    }
}
