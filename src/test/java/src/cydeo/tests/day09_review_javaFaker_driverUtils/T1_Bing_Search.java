package src.cydeo.tests.day09_review_javaFaker_driverUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import src.cydeo.utilities.ConfigurationReader;
import src.cydeo.utilities.WebDriverFactory;

import java.time.Duration;

public class T1_Bing_Search {
    //TC #1: Bing search

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1- Open a Chrome browser
        String webBrowser = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(webBrowser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- Go to: https://bing.com
        String URL = ConfigurationReader.getProperty("bingURL");
        driver.get(URL);

        //handle cookies
        WebElement rejectCookies = driver.findElement(By.xpath("//button[@id='bnp_btn_reject']"));
        rejectCookies.click();
    }

    @Test
    public void test1_bing_search() {
        //3- Write “apple” in search box
        String searchValue = ConfigurationReader.getProperty("searchValue");

        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='sb_form_q']"));
        searchBox.sendKeys(searchValue + Keys.ENTER);

        // 4- Verify title:
        //Expected: apple - Search
        String expectedTitle = ConfigurationReader.getProperty("expectedTitle");
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
/*
//Use `configuration.properties` for the following: 1. The browser type
    //2. The URL
    //3. The search keyword
    //4. Make title verification dynamic. If search value changes, title assertion should not fail.
 */
