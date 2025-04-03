package com.epam.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties properties = new Properties();

    public static String getProperty(String propertyName){
        try(FileInputStream fileInputStream = new FileInputStream("src/main/java/com/epam/utils/Configurations/config.properties")){
            properties.load(fileInputStream);

            return properties.getProperty(propertyName);
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
