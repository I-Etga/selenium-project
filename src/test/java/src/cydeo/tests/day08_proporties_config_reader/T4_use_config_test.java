package src.cydeo.tests.day08_proporties_config_reader;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import src.cydeo.utilities.ConfigurationReader;
import src.cydeo.utilities.WebDriverFactory;

import java.time.Duration;

public class T4_use_config_test {
    //TC #4: Google search[Use `configuration.properties`]
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Create new test and make setups
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to: "https://google.com"
        driver.get(ConfigurationReader.getProperty("googleUrl"));
    }

    @Test
    public void google_search_test() {

        //handle cookies
        WebElement rejectButton = driver.findElement(By.xpath("//button[@id='W0wltc']"));
        rejectButton.click();

        // 3- Write “apple” in search box
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        // 4- Verify title:
        //Expected: apple - Google Search
        String expectedTitle = "Apple - Google Suche";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

    }
}
