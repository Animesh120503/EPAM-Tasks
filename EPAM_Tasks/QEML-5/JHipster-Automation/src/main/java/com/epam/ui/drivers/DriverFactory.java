package com.epam.ui.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
class InvalidBrowserException extends Exception{
    public InvalidBrowserException(String message){
        super(message);
    }
}
public class DriverFactory{
    WebDriver driver;

    public WebDriver initializeDriver(String browserType) throws InvalidBrowserException {
        switch (browserType.toLowerCase()){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-popup-blocking");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new InvalidBrowserException("Invalid Browser Type.");
        }
        return driver;
    }
}
