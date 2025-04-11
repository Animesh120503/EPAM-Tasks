package com.epam.ui.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UIConfigReader {
    static Properties properties = new Properties();
    private static final Logger logger = LogManager.getLogger(UIConfigReader.class);

    public static String getProperty(String propertyName){
        try(FileInputStream fileInputStream = new FileInputStream("src/main/java/com/epam/ui/config/config.properties")){
            properties.load(fileInputStream);

            return properties.getProperty(propertyName);
        }catch(IOException e){
            logger.fatal("Unable to get property.", e);
            return null;
        }
    }
}
