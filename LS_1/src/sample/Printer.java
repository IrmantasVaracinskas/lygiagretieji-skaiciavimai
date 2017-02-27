package sample;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Irmis on 2017-02-22.
 */
public class Printer implements Closeable {
    private static final String[] HEADER = {"Continent", "Country", "Column", "Column2", "Column3", "Column4", "Column5",
            "Column6", "Column7", "Column8", "Column9"};
    private FileReader fileReader = null;
    private CSVParser csvFileParser = null;
    private CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(HEADER);
    private String filename = "Countries-Continents.csv";
    private List<CSVRecord> csvRecords = null;

    private PrintWriter writer = null;

    public Printer() throws IOException {
        fileReader = new FileReader(filename);
        csvFileParser = new CSVParser(fileReader, csvFileFormat);
        csvRecords = csvFileParser.getRecords();
        csvFileParser.close();

        writer = new PrintWriter("/./out.txt");
    }
    public void writeCountries(Region region, boolean sync) throws InterruptedException {
        if(sync){
            writeCountriesSynced(region);
        } else{
            writeCountriesUnsynced(region);
        }
    }

    private void writeCountriesUnsynced(Region region) throws InterruptedException {
        switch (region) {
            case AFRICA: {
                System.out.println("Countries in Africa:");
                writer.println("Countries in Africa:");

                for(int i = 1; i < csvRecords.size(); i++){
                    CSVRecord record = csvRecords.get(i);

                    if(record.get("Continent").equals("Africa")){
                        System.out.println("   1" + record.get("Country"));
                        writer.println("   1" + record.get("Country"));
                    }
                }
                break;
            }
            case ASIA: {
                System.out.println("Countries in Asia:");
                writer.println("Countries in Asia:");

                for(int i = 1; i < csvRecords.size(); i++){
                    CSVRecord record = csvRecords.get(i);

                    if(record.get("Continent").equals("Asia")){
                        System.out.println("   2" + record.get("Country"));
                        writer.println("   2" + record.get("Country"));
                    }
                }
                break;
            }
            case EUROPE: {
                System.out.println("Countries in Europe:");
                writer.println("Countries in Europe:");

                for(int i = 1; i < csvRecords.size(); i++){
                    CSVRecord record = csvRecords.get(i);

                    if(record.get("Continent").equals("Europe")){
                        System.out.println("   3" + record.get("Country"));
                        writer.println("   3" + record.get("Country"));
                    }
                }
                break;
            }

            case NORTH_AMERICA: {
                System.out.println("Countries in North America:");
                writer.println("Countries in North America:");

                for(int i = 1; i < csvRecords.size(); i++){
                    CSVRecord record = csvRecords.get(i);

                    if(record.get("Continent").equals("North America")){
                        System.out.println("   4" + record.get("Country"));
                        writer.println("   4" + record.get("Country"));
                    }
                }
                break;
            }

            case OCEANIA: {
                System.out.println("Countries in Oceania:");
                writer.println("Countries in Oceania:");

                for(int i = 1; i < csvRecords.size(); i++){
                    CSVRecord record = csvRecords.get(i);

                    if(record.get("Continent").equals("Oceania")){
                        System.out.println("   5" + record.get("Country"));
                        writer.println("   5" + record.get("Country"));
                    }
                }
                break;
            }

            case SOUTH_AMERICA: {
                System.out.println("Countries in South America:");
                writer.println("Countries in South America:");

                for(int i = 1; i < csvRecords.size(); i++){
                    CSVRecord record = csvRecords.get(i);
                    if(record.get("Continent").equals("South America")){
                        System.out.println("   6" + record.get("Country"));
                        writer.println("   6" + record.get("Country"));
                    }
                }
                break;
            }
        }
    }

    private synchronized void writeCountriesSynced(Region region) throws InterruptedException {
        switch (region) {
            case AFRICA: {
                System.out.println("Countries in Africa:");
                writer.println("Countries in Africa:");

                for(int i = 1; i < csvRecords.size(); i++){
                    CSVRecord record = csvRecords.get(i);

                    if(record.get("Continent").equals("Africa")){
                        System.out.println("   1" + record.get("Country"));
                        writer.println("   1" + record.get("Country"));
                    }
                }
                break;
            }
            case ASIA: {
                System.out.println("Countries in Asia:");
                writer.println("Countries in Asia:");

                for(int i = 1; i < csvRecords.size(); i++){
                    CSVRecord record = csvRecords.get(i);

                    if(record.get("Continent").equals("Asia")){
                        System.out.println("   2" + record.get("Country"));
                        writer.println("   2" + record.get("Country"));
                    }
                }
                break;
            }
            case EUROPE: {
                System.out.println("Countries in Europe:");
                writer.println("Countries in Europe:");

                for(int i = 1; i < csvRecords.size(); i++){
                    CSVRecord record = csvRecords.get(i);

                    if(record.get("Continent").equals("Europe")){
                        System.out.println("   3" + record.get("Country"));
                        writer.println("   3" + record.get("Country"));
                    }
                }
                break;
            }

            case NORTH_AMERICA: {
                System.out.println("Countries in North America:");
                writer.println("Countries in North America:");

                for(int i = 1; i < csvRecords.size(); i++){
                    CSVRecord record = csvRecords.get(i);

                    if(record.get("Continent").equals("North America")){
                        System.out.println("   4" + record.get("Country"));
                        writer.println("   4" + record.get("Country"));
                    }
                }
                break;
            }

            case OCEANIA: {
                System.out.println("Countries in Oceania:");
                writer.println("Countries in Oceania:");

                for(int i = 1; i < csvRecords.size(); i++){
                    CSVRecord record = csvRecords.get(i);

                    if(record.get("Continent").equals("Oceania")){
                        System.out.println("   5" + record.get("Country"));
                        writer.println("   5" + record.get("Country"));
                    }
                }
                break;
            }

            case SOUTH_AMERICA: {
                System.out.println("Countries in South America:");
                writer.println("Countries in South America:");

                for(int i = 1; i < csvRecords.size(); i++){
                    CSVRecord record = csvRecords.get(i);
                    if(record.get("Continent").equals("South America")){
                        System.out.println("   6" + record.get("Country"));
                        writer.println("   6" + record.get("Country"));
                    }
                }
                break;
            }
        }
    }

    public void close(){
        writer.flush();
        writer.close();
    }
}
