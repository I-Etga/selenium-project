package src.cydeo.tests.day05_testNG_intro_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import src.cydeo.utilities.WebDriverFactory;

import java.time.Duration;

public class T5_dropdown_intro {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //TC#5: Verifying “Simple dropdown” and “State selection” dropdown default values
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }


    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

    @Test
    public void simple_dropdown_test() {
        //3. Verify “Simple dropdown” default selected value is correct
        //Locating the dropdown as a web element
        WebElement simpleDropDown = driver.findElement(By.xpath("select[@id='dropdown']"));

        //Creating Select class object, and passing the dropdown into the constructor
        Select select = new Select(simpleDropDown);

        //Expected: “Please select an option”
        String expectedDefaultValue = "Please select an option";
        String actualDefaultValue = select.getFirstSelectedOption().getText();

        //Do our assertion
        Assert.assertEquals(actualDefaultValue, expectedDefaultValue);
        Assert.assertTrue(actualDefaultValue.equals(expectedDefaultValue));

        //4. Verify “State selection” default selected value is correct
        // Expected: “Select a State”

        //Create Select object, and also locate the dropdown itself in my constructor.
        Select stateDropdown = new Select(driver.findElement(By.xpath("select[@id='state']")));

        String expectedDefaultStateValue = "Select a State";
        String actualDefaultStateValue = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualDefaultStateValue, expectedDefaultStateValue);
    }

}
