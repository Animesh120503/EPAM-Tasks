import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestForm {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void testInputFirstAndLastName(){
        WebElement firstName = driver.findElement(By.xpath("//input[@id='first-name']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id='last-name']"));

        firstName.sendKeys("Helen");
        lastName.sendKeys("Pie");

        //Verification
        String firstNameValue = firstName.getAttribute("value");
        String lastNameValue = lastName.getAttribute("value");

        assertEquals(firstNameValue, "Helen", "Value does not match");
        assertEquals(lastNameValue, "Pie", "Value does not match");
    }

    @Test(priority = 2)
    public void testJobTitle(){
        WebElement jobTitle = driver.findElement(By.xpath("//input[@id='job-title']"));
        jobTitle.sendKeys("Senior Software Developer");

        String jobTitleValue = jobTitle.getAttribute("value");
        assertEquals(jobTitleValue, "Senior Software Developer", "Value does not match");
    }

    @Test(priority = 3)
    public void testHighestEducationRadio(){
        WebElement collegeRadioBtn = driver.findElement(By.xpath("//input[@id='radio-button-2']"));
        collegeRadioBtn.click();

        assertTrue(collegeRadioBtn.isSelected());
    }

    @Test(priority = 4)
    public void testGenderCheckBox(){
        WebElement maleCheckBox = driver.findElement(By.xpath("//input[@id='checkbox-1']"));
        maleCheckBox.click();

        assertTrue(maleCheckBox.isSelected());
    }

    @Test(priority = 5)
    public void testYearsOfExperience(){
        Select yearsOfExperience = new Select(driver.findElement(By.xpath("//select[@id='select-menu']")));
        yearsOfExperience.selectByVisibleText("0-1");
    }

    @Test(priority = 6)
    public void testDateSelection(){
        WebElement dateInput = driver.findElement(By.xpath("//input[@id='datepicker']"));
        dateInput.sendKeys("05/12/2003");

        String dateInputValue = dateInput.getAttribute("value");
        assertEquals(dateInputValue, "05/12/2003", "Dates do not match");
    }

    @Test(priority = 7)
    public void checkIfFormIsSubmitted() throws InterruptedException {
        WebElement submitBtn = driver.findElement(By.xpath("//a[text()='Submit']"));

        submitBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement specificElementOnNewPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Thanks for submitting your form']")));

        System.out.println(specificElementOnNewPage.getText());
        assertEquals(specificElementOnNewPage.getText(), "Thanks for submitting your form");
    }

    @AfterTest
    public void tearDown(){
        if(driver != null)
            driver.quit();
    }
}
