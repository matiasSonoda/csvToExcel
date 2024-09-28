package com.csvtoexcel.csvtoexcel;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CsvToExcel {
    
    private static final String CSV_FILE_PATH = "C:\\Users\\Brisa\\OneDrive - UTN HAEDO\\Escritorio\\Programación\\Java\\Csv to excel\\BDD CSV\\tableConvert.com_s3bqru.csv";
    
    public static void main (String[] args) {
                
        readDataLineByLine(CSV_FILE_PATH);
        
    }
    
    
    
    
    
    public static void excelGenerator(List<Feature> features){
        
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Work Items");
        
        //Crear la fila de encabezado
        String[] headers = {"Correo Dev", "Equipo", "Nombre desarrollo (feature)",
                            "Es fix?(feature)","ID DevOps(feature)","Nombre PBI","ID PBI","Estimación Inicial(PBI)",
                            "Estimación Actual(PBI)","Horas Faltantes(Resta)","Fecha Termino(Target Date-PBI)"};
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++){
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }
        
        //Escribir los datos
        int rowNum = 1;
        for (Feature currentFeature : features){
            for ( BacklogItem currentBacklog : currentFeature.getBacklogItems() ){
                
                Row row = sheet.createRow(rowNum++);
                
                row.createCell(0).setCellValue(currentFeature.getCorreo());
                row.createCell(1).setCellValue(currentFeature.getEquipo());
                row.createCell(2).setCellValue(currentFeature.getNombreDesarrollo());
                row.createCell(3).setCellValue(currentFeature.isFix());
                row.createCell(4).setCellValue(currentFeature.getIdDevOps());
                row.createCell(5).setCellValue(currentBacklog.getNombrePbi());
                row.createCell(6).setCellValue(currentBacklog.getIdPbi());
                row.createCell(7).setCellValue(currentBacklog.getEstimacionInicial());
                row.createCell(8).setCellValue(currentBacklog.getEstimacionActual());
                row.createCell(9).setCellValue(currentBacklog.getHorasFaltantes());
                row.createCell(10).setCellValue(currentBacklog.getFechaFin());
                
            }
        }
        //Ajustar el tamaño de las columnas
        for ( int i = 0; i < headers.length;i++){
            
            sheet.autoSizeColumn(i);
            
        }
        //Escribir el archivo en el sistema
        try(FileOutputStream fileOut = new FileOutputStream("C:/Users/Brisa/OneDrive - UTN HAEDO/Escritorio/Programación/Java/Csv to excel/excels/work_items.xlsx")){
            
            workbook.write(fileOut);
            System.out.println("Archivo Excel escrito exitosamente.");

        }catch(IOException e){
            
            e.printStackTrace();
            
        }
        //Cerrar el wortkbook
        try{
            workbook.close();
            System.out.println("Workbook cerrado exitosamente.");
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public static void readDataLineByLine(String file) {

        try (CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            List<Feature> features = new ArrayList<>();
            Feature currentFeature = null;
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
                                                 line[7].isEmpty() ? 0 : Integer.parseInt(line[7]),
                                                 line[8]);
                
                if (workItem.getWorkItemType().toLowerCase().equals("feature"))
                    {
                    currentFeature = new Feature( workItem.getAssignedTo(), "equipo", workItem.getTitle(),false, workItem.getId());
                    features.add(currentFeature);
                    
                    }else if(workItem.getWorkItemType().toLowerCase().equals("product backlog item")){
                        LocalDate date = Optional.ofNullable(workItem.getTargetDate()).map(LocalDateTime::toLocalDate).orElse(null);
                        BacklogItem backlogItem = new BacklogItem(workItem.getTitle(),workItem.getId(),
                                                                  0,0, date);
                    if (currentFeature != null){
                    
                        currentFeature.setBacklogItem(backlogItem);
                    
                    }
                }
            }
            excelGenerator(features);
        }catch (CsvValidationException | IOException | NumberFormatException e){
                    e.printStackTrace();
                }   
    }
}
