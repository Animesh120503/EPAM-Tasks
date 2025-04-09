package com.epam.ui.dataproviders;

import com.epam.utils.ExcelUtils.ExcelDataReader;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviderUtil {
    @DataProvider(name="getValidLoginData")
    public Object[][] getData() throws IOException {
        return ExcelDataReader.fetchDataFromFile("loginData.xlsx");
    }

    @DataProvider(name="getInvalidLoginData")
    public Object[][] getInvalidData() throws IOException {
        return ExcelDataReader.fetchDataFromFile("InvalidLoginData.xlsx");
    }
}
