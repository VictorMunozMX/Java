package com.releases;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class ReadExcel {
    public static void main(String[] args) {
        // Lee todos los archivos en un directorio
        File folder = new File("C:\\Users\\Enrique.Munoz\\OneDrive - Solera Holdings, Inc" +
                "\\Documents\\Releases\\Manuals_xlsx\\");

        // Crear un nuevo archivo CSV
        File csvFile = new File("C:\\Users\\Enrique.Munoz\\OneDrive - Solera Holdings, Inc" +
                "\\Documents\\Releases\\Project Power BI\\Content_Release.csv");
        boolean header = true;

        // if file exist, delete
        if (csvFile.exists()) {
            csvFile.delete();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {

            File[] listOfFiles = folder.listFiles();
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("--> " + file.getName());

                    try (FileInputStream fileInputStream = new FileInputStream(file);

                        Workbook workbook = new XSSFWorkbook(fileInputStream)) {
                        Sheet sheet = workbook.getSheetAt(0); // Obtiene la primera hoja

                        // Omite la primera fila (encabezados)
                        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                            Row row = sheet.getRow(rowIndex);

                            if (row != null) { // Verifica que la fila no sea nula
                                StringBuilder rowData = new StringBuilder();

                                //for (Cell cell : row) {
                                for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
                                    Cell cell = row.getCell(cellIndex);

                                    // extract the year from the first cell
                                    if (cellIndex == 0){
                                        double cellValue = cell.getNumericCellValue();
                                        String cellValueFormatted = String.valueOf(cellValue).replace(".", "");
                                        cellValueFormatted = cellValueFormatted.substring(0, 4);
                                        rowData.append(cellValueFormatted).append(",");
                                    }
                                    if (cellIndex == 3){
                                        // subtract the letters from 0 until the first "_" in cell 3
                                        String cellValue = cell.getStringCellValue();
                                        int index = cellValue.indexOf("_");
                                        String cellValue2 = cellValue.substring(0, index);
                                        rowData.append(cellValue2).append(",");
                                    }
                                    switch (cell.getCellType()) {
                                        case STRING:
                                            rowData.append(cell.getStringCellValue().replace(",", " ")).append(",");
                                            //rowData.append(cell.getStringCellValue()).append(",");
                                            break;
                                        case NUMERIC:
                                            double numericValue = cell.getNumericCellValue();
                                            int intValue = (int) numericValue; // Convertir a int
                                            rowData.append(intValue).append(",");
                                            break;
                                        default:
                                            rowData.append("UNKNOWN,");
                                    }
                                }

                                // Elimina la última coma y escribe la fila en el archivo CSV
                                if (rowData.length() > 0) {
                                    rowData.setLength(rowData.length() - 1); // Elimina la última coma
                                }

                                // escribir un header para el archivo
                                if (header) {
                                    header = false;
                                    writer.write("Year,Proc_date,Release_id,Description,Brand,KII_Name,Fett,Package_id,Release");
                                    writer.newLine();
                                }
                                writer.write(rowData.toString());
                                writer.newLine(); // Nueva línea para la siguiente fila
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
