package com.csvtoexcel.csvtoexcel;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvToExcel {
    
    private static final String CSV_FILE_PATH = "C:\\Users\\Brisa\\OneDrive - UTN HAEDO\\Escritorio\\Programación\\Java\\Csv to excel\\BDD CSV\\tableConvert.com_s3bqru.csv";
    
    public static void main (String[] args) {
        
        System.out.println("Read Data Line by Line With Header \n");
        readDataLineByLine(CSV_FILE_PATH);
        System.out.println("______________________________________________");
        
    }
    
    public static void readDataLineByLine(String file) {
        System.out.println("Hello World!");
        
        try {
            //Creo objeto FileReader
            //Pas ocomo parametro un archivo CSV
            FileReader filereader = new FileReader(file);
            
            //Creo el objeto lector csvReader
            // el archivo es un parametro
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            
            //Ahora leo linea por linea
            while ((nextRecord  = csvReader.readNext()) != null){
                for (String cell : nextRecord){
                    System.out.print(cell + "\t"); 
                }
                System.out.println();
            }
            
         }
        catch (Exception e){
                    e.printStackTrace();
                }
        
        
    }
}
