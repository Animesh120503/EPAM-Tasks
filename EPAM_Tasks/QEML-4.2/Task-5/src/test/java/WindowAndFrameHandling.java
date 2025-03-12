import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class WindowAndFrameHandling {
    private WebDriver driver;
    private WebDriverWait wait;

    //Set up the WebDriver, configure settings, and initialize WebDriverWait for use in tests.
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();  // Instantiate the ChromeDriver
        driver.manage().window().maximize();  // Maximize the browser window for clear visibility
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Create an instance of WebDriverWait with a 10-second timeout
    }

    //Opens a new window using button click on the page and handles the transition between the original and new windows.
    public void handleMultipleWindows() {
        try {
            driver.get("https://formy-project.herokuapp.com/switch-window"); // Navigate to the URL
            WebElement openNewTabBtn = driver.findElement(By.id("new-tab-button")); // Find the button to open a new tab
            openNewTabBtn.click();  // Click the button which opens a new tab

            Set<String> windowHandles = driver.getWindowHandles(); // Retrieve all open window handles
            Iterator<String> iterator = windowHandles.iterator();
            String originalWindow = iterator.next();  // The original window is assumed to be the first window
            String newWindow = iterator.next();       // New window opened by the button click

            driver.switchTo().window(newWindow);  // Switch WebDriver control to the new window
            driver.close();  // Close the new window after necessary actions or assertions
            driver.switchTo().window(originalWindow);  // Return control back to the original window

        } catch(NoSuchElementException e){
            e.getMessage();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Navigates to a webpage containing an iframe and switches the driver context to that iframe.
    public void handleFrames() {
        try {
            driver.get("https://qa-practice.netlify.app/iframe"); // Navigate to a page with an iframe
            WebElement iframe = driver.findElement(By.xpath("//iframe[@id='iframe-checkboxes']")); // Locate the iframe by its XPath
            driver.switchTo().frame(iframe);  // Switch to the iframe for interaction within it
        } catch(NoSuchElementException e){
            e.getMessage();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Tests the handling of multiple window contexts, includes switching windows and handling alerts.
    @Test(priority = 1)
    public void testHandleMultipleWindow() {
        try {
            handleMultipleWindows();

            // Interact with elements and validate expected outcomes
            WebElement alertBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("alert-button")));
            alertBtn.click();  // Click the button that triggers an alert
            Alert alert = driver.switchTo().alert();  // Switch to the alert dialog
            String alertText = alert.getText();  // Read the text from the alert

            assertEquals(alertText, "This is a test alert!", "Alert text does not match expected value.");
            alert.accept();  // Close the alert
        } catch(NoSuchElementException e){
            e.getMessage();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Test interaction within an iframe and validate elements and text.
    @Test(priority = 2)
    public void testHandlingIFrames() {
        try {
            handleFrames();

            // Interact with a link within the iframe and validate resulting text change
            WebElement learnMore = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='learn-more']")));
            learnMore.click();  // Clicks the link inside iframe

            WebElement showText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='show-text']")));
            assertEquals(showText.getText(), "This text appears when you click the \"Learn more\" button", "Text after clicking Learn More does not match the expected.");

            driver.switchTo().parentFrame();  // Switch back to the main content from the iframe

            // Validate another element outside the iframe to ensure context has been switched back
            WebElement sidebarText = driver.findElement(By.xpath("//nav[@id='sidebar']//h3/a[text()='QA Practice']"));
            assertEquals(sidebarText.getText(), "QA Practice", "Sidebar text does not match expected value.");
        } catch (NoSuchElementException e){
            e.getMessage();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Clean up resources and close the browser after the test completes.
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser and end the session cleanly
        }
    }
}