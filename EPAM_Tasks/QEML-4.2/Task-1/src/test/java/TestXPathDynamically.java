import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
class XPathValidationAndDynamicLocator {

    /**
     * Task 1: Validate text using XPath
     * This method finds the "Target Element" using XPath and asserts its text content.
     *
     * @param driver WebDriver instance
     */
    public void validateTextUsingXPath(WebDriver driver) {
        // XPath to locate the target element
        String xpathExpression = "//div/span[text()='Engineer Your Future']";
        // Find the element
        WebElement targetElement = driver.findElement(By.xpath(xpathExpression));
        // Validate the text
        assertEquals(targetElement.getText(), "Engineer Your Future", "Text does not match!");
    }

    /**
     * Task 2: Locate a product dynamically by name
     * This method finds a product code (td element) based on the given product name.
     *
     * @param driver      WebDriver instance
     * @param productName Name of the product to search for
     * @return WebElement representing the product code
     */
    public WebElement findProductByName(WebDriver driver, String productName) {
        // Dynamic XPath to locate the product code based on the product name
        String dynamicXPath = "//table[@id='productsTable']//tr[td[text()='" + productName + "']]/td[1]";
        // Find and return the element
        return driver.findElement(By.xpath(dynamicXPath));
    }
}
public class TestXPathDynamically {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("C:\\Users\\animesh_pradhan\\Desktop\\EPAM-Tasks\\QEML-4.2\\Task-1\\src\\main\\resources\\Product.html");
    }

    public static WebElement findProductByName(WebDriver driver, String productNameStr){
        WebElement productCode = driver.findElement(By.xpath("//td[text()='"+productNameStr+"']//preceding-sibling::td"));
        return productCode;
    }

    @Test
    public void testXpathDynamic(){
        WebElement productCode = findProductByName(driver, "Google Pixel 4");

        assertEquals(productCode.getText(), "PROD_002", "Product code not found.");
    }

    @AfterTest
    public void tearDown(){
        if(driver != null)
            driver.quit();
    }


//    public static void main(String[] args) {
//        // Set up WebDriver (Make sure to set the correct path for your chromedriver)
//        WebDriver driver = new ChromeDriver();
//        XPathValidationAndDynamicLocator obj = new XPathValidationAndDynamicLocator();
//        try {
//            // Navigate to the page
//            driver.get("C:\\Users\\animesh_pradhan\\Desktop\\EPAM-Tasks\\QEML-4.2\\Task-1\\src\\main\\resources\\Product.htmlA");
//
//            // Task 1: Validate Text
//            obj.validateTextUsingXPath(driver);
//
//            // Task 2: Locate Product Code Dynamically
//            WebElement productCode = obj.findProductByName(driver, "Google Pixel 4");
//            System.out.println("Product Code: " + productCode.getText());
//
//        } finally {
//            driver.quit(); // Close the browser
//        }
//    }
}
