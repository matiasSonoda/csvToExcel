package com.csvtoexcel.csvtoexcel;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CsvToExcel {
    
    private static final String CSV_FILE_PATH = "C:\\Users\\Brisa\\OneDrive - UTN HAEDO\\Escritorio\\Programación\\Java\\Csv to excel\\BDD CSV\\tableConvert.com_s3bqru.csv";
    
    public static void main (String[] args) {
                
        System.out.println("Read Data Line by Line With Header \n");
        readDataLineByLine(CSV_FILE_PATH);
        System.out.println("______________________________________________");
        
    }
    
    public static void readDataLineByLine(String file) {

        try(CSVReader reader = new CSVReader(new FileReader(file))) {
            List<Feature> features = new ArrayList<>();
            Map<Long,Feature> featureMap = new HashMap<>();
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("M/d/yyyy")
                .optionalStart()
                .appendPattern(" h:mm:ss a")
                .optionalEnd()
                .toFormatter(Locale.ENGLISH);
            String[] line;
 
            while ((line  = reader.readNext()) != null){
               
                LocalDateTime startDate = line[5].isEmpty() ? null : LocalDateTime.parse(line[5], formatter);
                LocalDateTime targetDate = line[6].isEmpty() ? null : LocalDateTime.parse(line[6], formatter);
                WorkItem workItem = new WorkItem(line[0], Long.parseLong(line[1]), 
                                                 line[2],line[3],line[4], 
                                                 startDate, targetDate, 
                                                 line[7].isEmpty() ? 0 : Integer.parseInt(line[7]), line[8]);
                
                if (workItem.getWorkItemType().toLowerCase().equals("feature"))
                    {
                    Feature feature = new Feature( workItem.getAssignedTo(), "equipo", workItem.getTitle(),false, workItem.getId());
                    
                    features.add(feature);
                    featureMap.put(workItem.getId(), feature);
                }else if(workItem.getAssignedTo().toLowerCase().equals("product backlog item")){
                    
                    BacklogItem backlogItem = new BacklogItem( 
                            workItem.getTitle(),workItem.getId(),
                            0,0, workItem.getTargetDate().toLocalDate());
                Feature parentFeature = featureMap.get(workItem.getId());
                if (parentFeature != null){
                    
                    parentFeature.setBacklogItem(backlogItem);
                    
                }
                
                
            
                }
               
            }
            
        }catch (CsvValidationException | IOException | NumberFormatException e){
                    e.printStackTrace();
                }
        
        
    }
}
