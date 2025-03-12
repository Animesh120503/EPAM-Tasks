import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JavascriptExecutorTest {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        //Create a chromeDriver instance for Chrome browser
        driver = new ChromeDriver();
    }

    //Method to click the hidden element using javascript executor
    public void clickHiddenElement(WebDriver driver, WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver; //Create a Javascript Executor instance
        js.executeScript("arguments[0].click();", webElement); //Execute the click on hiddenButton through javascript
    }

    //Method to scroll to the element and click the element using javascript executor
    public void scrollToElementAndClick(WebDriver driver, WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver; //Create a Javascript Executor instance
        js.executeScript("arguments[0].scrollIntoView();", webElement); //scroll to the submit button
        js.executeScript("arguments[0].click();", webElement); //click on the submit button
    }

    @Test(priority = 1)
    //Test the clickHiddenElement() method
    public void testClickHiddenElement(){
        try {
            //Go to the HTML code snippet using the driver
            driver.get("http://localhost:63342/Task-4/hiddenElement.html?_ijt=edkqo6m0c7ilke1cvqj855m7p&_ij_reload=RELOAD_ON_SAVE");
            WebElement hiddenElement = driver.findElement(By.id("hiddenButton")); //Locate the hiddenButton element using id

            clickHiddenElement(driver, hiddenElement); //Execute the clickHiddenElement() method to click the button

            Alert alert = driver.switchTo().alert(); //Switch to the alert box generated
            String alertText = alert.getText(); //Get the text of alert
            alert.accept(); //Accept and close the Alert

            assertEquals(alertText, "Button Clicked!", "No Alert present."); //Assert if the text in the alert box are equal
        } catch(NoSuchElementException e){ //Catch exception if No element is found
            System.out.println(e.getMessage());
        } catch (Exception e) { //Catch all other exception
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 2)
    //Test the scrollToElementAndClick() method
    public void testScrollToElementAndClick(){
        try {
            //Go to the formy project URL using the driver
            driver.get("https://formy-project.herokuapp.com/form");
            WebElement submitButton = driver.findElement(By.xpath("//input[@id='datepicker']/ancestor::div[1]/following-sibling::div/a")); //Locate the submit button element using xpath

            scrollToElementAndClick(driver, submitButton); //Execute the scrollToElementAndClick() method to click the button

            String thanksURL = driver.getCurrentUrl(); //Get the URl of the current new webpage
            assert thanksURL != null; //Check if the URL is not null
            assertTrue(thanksURL.contains("/thanks")); //Assert the URL contains '/thanks' keyword
        } catch(NoSuchElementException e){ //Catch exception if No element is found
            System.out.println(e.getMessage());
        } catch (Exception e) { //Catch all other exceptions
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    //Close and quit the driver after all the tests are performed
    public void tearDown(){
        if(driver != null)
            driver.quit(); //Quit the driver
    }
}
