package src.cydeo.tests.day05_testNG_intro_dropdowns;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import src.cydeo.utilities.WebDriverFactory;

import java.time.Duration;

public class T4_TestNG_Selenium_Intro {

    WebDriver driver; // declare here. So I can access everywhere in the class !!

    @BeforeMethod
    public void setupMethod() {
        //TC #4: Cydeo Title Verification
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2. Go to https://www.cydeo.com
        driver.get("https://practice.cydeo.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1_cydeo_title_verification() {
        // 3. Verify title:
        //Expected: Cydeo
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);


    }


}
