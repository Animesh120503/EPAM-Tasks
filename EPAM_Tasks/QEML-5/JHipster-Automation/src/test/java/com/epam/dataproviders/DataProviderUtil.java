package com.epam.dataproviders;

import com.epam.utils.ExcelUtils.ExcelDataReader;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviderUtil {
    @DataProvider(name="getExcelData")
    public Object[][] getData() throws IOException {
        return ExcelDataReader.fetchDataFromFile("loginData.xlsx");
    }
}
