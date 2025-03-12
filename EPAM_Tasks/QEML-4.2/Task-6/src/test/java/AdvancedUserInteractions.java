import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AdvancedUserInteractions {
    WebDriver driver;
    WebDriverWait wait;

    //Initialize the WebDriver and set up necessary web browser properties.
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();  // Create an instance of ChromeDriver
        driver.manage().window().maximize();  // Maximize the browser window
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // WebDriverWait with a 10-second timeout
    }

    //Perform a drag and drop operation on a specified draggable element to a specified target.
    public void performDragAndDrop() {
        try {
            driver.get("https://formy-project.herokuapp.com/dragdrop");  // Navigate to the drag and drop example page

            // Locate the draggable element (source) and the drop target (destination) on the page
            WebElement sourceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='image']")));
            WebElement targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='box']")));

            // Execute the drag and drop action using Actions class
            new Actions(driver)
                    .dragAndDrop(sourceElement, targetElement)
                    .perform();
        } catch (NoSuchElementException e) {
            System.out.println("No such element found: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Failed to perform drag and drop: " + e.getMessage(), e);
        }
    }

    //Perform a mouse hover over a specified element.
    public void performMouseHover() {
        try {
            driver.get("https://www.geeksforgeeks.org/");

            // Identify the element on which to hover
            WebElement targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='topMainHeader']//div[text()='Courses']")));

            // Perform mouse hover action using Actions class
            new Actions(driver)
                    .moveToElement(targetElement)
                    .perform();

        } catch (NoSuchElementException e) {
            System.out.println("No such element found: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Failed to perform mouse hover: " + e.getMessage(), e);
        }
    }

    //Test to verify the drag and drop functionality works as expected.
    @Test(priority = 1)
    public void testDragAndDrop() {
        try {
            performDragAndDrop();
            // Verify that the drag and drop operation was successful by checking the text within the drop zone
            WebElement afterDropElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='box']/p")));
            String afterDropText = afterDropElement.getText();
            assertEquals(afterDropText, "Dropped!", "Item not dropped correctly");
        } catch (NoSuchElementException e) {
            System.out.println("No such element found: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error during drag and drop test: " + e.getMessage(), e);
        }
    }

    //Test to verify that mouse hover displays additional elements as expected.
    @Test(priority = 2)
    public void testMouseHover() {
        try {
            performMouseHover();
            // Verify the element that appears only after mouse hover is present, and its text matches expected
            WebElement gateCourses = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='topMainHeader']//div[text()='Courses']/../following-sibling::ul/li/a[text()='GATE Courses']")));
            assertEquals(gateCourses.getText(), "GATE Courses", "Displayed text does not match the expected");

            // Click the link to navigate to the GATE courses page and verify URL
            gateCourses.click();
            assertTrue(driver.getCurrentUrl().contains("gate"), "URL does not contain expected path");
        } catch (NoSuchElementException e) {
            System.out.println("No such element found: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error during mouse hover test: " + e.getMessage(), e);
        }
    }

    //Clean up driver resources and close the browser after the test execution is complete.
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Terminate the browser session
        }
    }
}