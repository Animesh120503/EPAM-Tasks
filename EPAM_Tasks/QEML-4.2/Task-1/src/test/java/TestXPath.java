import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestXPath {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("C:\\Users\\animesh_pradhan\\Desktop\\EPAM-Tasks\\QEML-4.2\\Task-1\\src\\main\\resources\\TestCode.html");
    }

    @Test
    public void validateTextUsingXPath(){
        WebElement spanElement = driver.findElement(By.xpath("//span[@class='mySpan']/../preceding-sibling::div/span"));

        assertEquals(spanElement.getText(), "Engineer Your Future", "Element not found.");
    }

    @AfterTest
    public void tearDown(){
        if(driver != null)
            driver.quit();
    }
}
