import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;

public class TestDropdown{
    WebDriver driver;

    @BeforeTest
    // Set up the browser and navigate to the test page
    public void setup() {
        driver = new ChromeDriver();
        try {
            driver.get("https://demoqa.com/select-menu");
            driver.manage().window().maximize();
        } catch (WebDriverException e) {
            System.err.println("Error navigating to the test page: " + e.getMessage());
            tearDown(); // Close browser if setup fails
        }
    }

//    // Scroll to make elements visible if not in viewport
//    public void performScrolling() {
//        try {
//            new Actions(driver)
//                    .scrollToElement(driver.findElement(By.xpath("//div[text()='Interactions']")))
//                    .perform();
//        } catch (NoSuchElementException e) {
//            System.err.println("Failed to find element to scroll: " + e.getMessage());
//        } catch (Exception e) {
//            System.err.println("Error while scrolling: " + e.getMessage());
//        }
//    }

    @BeforeMethod
    // Scroll to make elements visible if not in viewport
    public void performScrolling() {
        System.out.println("Working....");
        try {
            new Actions(driver)
                    .scrollToElement(driver.findElement(By.xpath("//div[text()='Interactions']")))
                    .perform();
        } catch (NoSuchElementException e) {
            System.err.println("Failed to find element to scroll: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error while scrolling: " + e.getMessage());
        }
    }

    @Test(priority = 1)
    // Attempt to select option from a dropdown and handle potential exceptions
    public void testDropDownSelectionByValue() {
        try {
            WebElement selectValue = driver.findElement(By.xpath("//div[@id='withOptGroup']"));
            selectValue.click();
            WebElement selectValueOption = driver.findElement(By.xpath("//div[@id='react-select-2-option-0-1']"));
            selectValueOption.click();
            Select select = new Select(driver.findElement(By.id("hub")));
            driver.getWindowHandles();
            assertTrue(selectValue.getText().contains("Group 1, option 2"));
        } catch (NoSuchElementException e) {
            Assert.fail("Dropdown element not found: " + e.getMessage());
        } catch (Exception e) {
            Assert.fail("Error selecting dropdown option: " + e.getMessage());
        }
    }

//    @Test(priority = 2)
//    // Test method for selecting an option from another dropdown menu
//    public void testDropDownSelectOne() {
//        try {
//            performScrolling();
//            WebElement selectOne = driver.findElement(By.xpath("//div[@id='selectOne']"));
//            selectOne.click();
//            selectOne.sendKeys("Dr."); //Use the search box functionality
//            WebElement selectOneOption = driver.findElement(By.xpath("//div[@id='react-select-3-option-0-0']"));
//            selectOneOption.click();
//        } catch (NoSuchElementException e) {
//            Assert.fail("Dropdown element not found: " + e.getMessage());
//        } catch (Exception e) {
//            Assert.fail("Error selecting dropdown option: " + e.getMessage());
//        }
//    }
//
//    @Test(priority = 2)
//    public void testDropDownSelectOne() {
//        try {
//            performScrolling();
//            WebElement selectOne = driver.findElement(By.xpath("//div[@id='selectOne']"));
//            selectOne.click();
//
//            // Explicitly wait for the input field to be visible
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='react-select-3-input']")));
//            inputField.sendKeys("Dr.");
//
//            // Wait for the options to be clickable
//            WebElement selectOneOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='react-select-3-option-0-0']")));
//            selectOneOption.click();
//
//            assertTrue(selectOne.getText().contains("Dr."));
//        } catch (NoSuchElementException e) {
//            Assert.fail("Dropdown element not found: " + e.getMessage());
//        } catch (Exception e) {
//            Assert.fail("Error selecting dropdown option: " + e.getMessage());
//        }
//    }
//
//    @Test(priority = 2)
//    public void testDropDownSelectOne() {
//        try {
//            performScrolling();
//            WebElement selectOne = driver.findElement(By.xpath("//div[@id='selectOne']"));
//            selectOne.click();
//
//            // Configures a wait that ignores certain exceptions while waiting for an element.
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.pollingEvery(Duration.ofMillis(500))  // Check for element availability every 500 milliseconds
//                    .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
//
//            // Explicitly wait for the input field to be visible and then send keys
//            WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='react-select-3-input']")));
//            inputField.sendKeys("Dr.");
//
//            // Wait for the options to be clickable after sending the keys
//            WebElement selectOneOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='react-select-3-option-0-0']")));
//            selectOneOption.click();
//
//            assertTrue(selectOne.getText().contains("Dr."));
//        } catch (NoSuchElementException e) {
//            Assert.fail("Dropdown element not found: " + e.getMessage());
//        } catch (Exception e) {
//            Assert.fail("Error selecting dropdown option: " + e.getMessage());
//        }
//    }

    @Test(priority = 2)
    // Test typing and selection in a searchable dropdown component.
    public void testSearchAndSelectInDropdown() {
        try {
            WebElement selectOne = driver.findElement(By.xpath("//div[@id='selectOne']"));
            selectOne.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);

            WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='react-select-3-input']")));
            inputField.sendKeys("Dr.");

            WebElement selectOneOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='react-select-3-option-0-0']")));
            selectOneOption.click();

            assertTrue(selectOne.getText().contains("Dr."));
        } catch (NoSuchElementException e) {
            Assert.fail("Dropdown element not found: " + e.getMessage());
        } catch (Exception e) {
            Assert.fail("Error selecting dropdown option: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    // Test interaction with HTML <select> element
    public void testOldSelectDropDown() {
        try {
            performScrolling();
            Select oldStyleMenuSelect = new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
            oldStyleMenuSelect.selectByVisibleText("Purple");

            assertEquals(oldStyleMenuSelect.getFirstSelectedOption().getText(), "Purple", "Values do not match.");
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + e.getMessage());
        } catch (Exception e) {
            Assert.fail("Error interacting with old style dropdown: " + e.getMessage());
        }
    }

//    @Test(priority = 4)
//    // Test selections from a multi-select dropdown
//    public void testMultipleSelectDropDown() {
//        try {
//            performScrolling();
//            WebElement multiSelectDropDown = driver.findElement(By.xpath("//b[contains(text(),'Multiselect')]/../following-sibling::div"));
//            multiSelectDropDown.click();
//            WebElement selectGreen = driver.findElement(By.xpath("//div[@id='react-select-4-option-0']"));
//            WebElement selectBlue = driver.findElement(By.xpath("//div[@id='react-select-4-option-1']"));
//            selectGreen.click();
//            selectBlue.click();
//
//            assertTrue(multiSelectDropDown.getText().contains("Blue"));
//            assertTrue(multiSelectDropDown.getText().contains("Green"));
//        } catch (NoSuchElementException e) {
//            Assert.fail("Dropdown element not found: " + e.getMessage());
//        } catch (Exception e) {
//            Assert.fail("Error selecting multiple dropdown options: " + e.getMessage());
//        }
//    }

//    @Test
//    public void testMultiSelectDropdown() {
////        WebElement dropdown = driver.findElement(By.className("css-11unzgr"));
//        WebElement dropdown = driver.findElement(By.xpath("//b[contains(text(),'Multiselect')]/../following-sibling::div"));
//        Select select = new Select(dropdown);
//        select.selectByVisibleText("Green");
//        select.selectByVisibleText("Blue");
//        List<WebElement> selectedOptions = select.getAllSelectedOptions();
//        Assert.assertEquals(selectedOptions.size(), 2, "Not all options were selected!");
//        Assert.assertTrue(selectedOptions.stream().anyMatch(option -> option.getText().equals("Green")), "Volvo not selected!");
//        Assert.assertTrue(selectedOptions.stream().anyMatch(option -> option.getText().equals("Blue")), "Opel not selected!");
//    }

    @Test(priority = 5)
    // Interact with a multiple select HTML element
    public void testStandardMultipleSelect() {
        try {
            performScrolling();
            Select standardMultipleSelect = new Select(driver.findElement(By.id("cars")));
            standardMultipleSelect.selectByVisibleText("Volvo");
            standardMultipleSelect.selectByVisibleText("Saab");

            List<WebElement> selectedWebElementList = standardMultipleSelect.getAllSelectedOptions();
            List<String> carsSelected = selectedWebElementList.stream().map(WebElement::getText).toList();
            assertEquals(carsSelected, List.of("Volvo","Saab"));
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + e.getMessage());
        } catch (Exception e) {
            Assert.fail("Error interacting with standard multiple select: " + e.getMessage());
        }
    }

//    @AfterTest
//    // Clean up resources by closing the browser
//    public void tearDown() {
//        if (driver != null) {
//            try {
//                driver.quit();
//            } catch (WebDriverException e) {
//                System.err.println("Error closing the driver: " + e.getMessage());
//            }
//        }
//    }

    @AfterTest
    // Make sure to close the browser safely.
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (WebDriverException e) {
                System.err.println("Error closing the driver: " + e.getMessage());
                driver = null; // Ensuring no further method calls if quit fails.
            }
        }
    }
}