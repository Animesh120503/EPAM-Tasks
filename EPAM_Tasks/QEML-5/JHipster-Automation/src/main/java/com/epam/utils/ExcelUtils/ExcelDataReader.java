package com.epam.utils.ExcelUtils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataReader {
    public static Object[][] fetchDataFromFile(String fileName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/ExcelData/"+fileName);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                data[i][j] = sheet.getRow(i).getCell(j).toString();
            }
        }

        return data;
    }

}
