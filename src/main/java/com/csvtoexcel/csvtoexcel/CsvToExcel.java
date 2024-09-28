package com.csvtoexcel.csvtoexcel;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvToExcel {
    
    private static final String CSV_FILE_PATH = "C:\\Users\\Brisa\\OneDrive - UTN HAEDO\\Escritorio\\Programación\\Java\\Csv to excel\\BDD CSV\\tableConvert.com_s3bqru.csv";
    
    public static void main (String[] args) {
                
        System.out.println("Read Data Line by Line With Header \n");
        readDataLineByLine(CSV_FILE_PATH);
        System.out.println("______________________________________________");
        
    }
    
    public static void readDataLineByLine(String file) {
        
        try {
            List<Feature> features = new ArrayList<>();
            Map<Long,Feature> featureMap = new HashMap<>();

            //Creo objeto FileReader
            //Pas ocomo parametro un archivo CSV
            FileReader filereader = new FileReader(file);
            
            //Creo el objeto lector csvReader
            // el archivo es un parametro
            CSVReader csvReader = new CSVReader(filereader);
            String[] line;
            
            //Ahora leo linea por linea
            while ((line  = csvReader.readNext()) != null){
                WorkItem workItem = new WorkItem(line[0], Long.parseLong(line[1]), line[2],line[3],line[4], LocalDate.parse(line[5]), LocalDate.parse(line[6]), Integer.parseInt(line[7]), line[8]);
                
                if (workItem.getWorkItemType().toLowerCase().equals("feature")){
                    Feature feature = new Feature(
                            workItem.getAssignedTo(), "equipo", workItem.getTitle(),
                            false, workItem.getId()
                    );
                    features.add(feature);
                    featureMap.put(workItem.getId(), feature);
                }else if(workItem.getAssignedTo().toLowerCase().equals("product backlog item")){
                    
                    BacklogItem backlogItem = new BacklogItem( workItem.getTitle(),workItem.getId(),
                    0,0, workItem.getTargetDate());
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
