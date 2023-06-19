package src.cydeo.tests.day09_review_javaFaker_driverUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import src.cydeo.utilities.BrowserUtils;
import src.cydeo.utilities.ConfigurationReader;
import src.cydeo.utilities.Driver;

public class T2_DriverUtil_Practice {
 /*   WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1- Open a Chrome browser
        String webBrowser = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(webBrowser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }*/

    @Test
    public void test1_bing_search() {

        //2- Go to: https://bing.com
        String URL = ConfigurationReader.getProperty("bingURL");
        //driver.get(URL);

        //Driver.getDriver()--> will return me the "driver"
        //instead if writing "driver" from now on, we will write Driver.getDriver();
        Driver.getDriver().get(URL);


        //handle cookies
        WebElement rejectCookies = Driver.getDriver().findElement(By.xpath("//button[@id='bnp_btn_reject']"));
        rejectCookies.click();

        //3- Write “apple” in search box
        String searchValue = ConfigurationReader.getProperty("searchValue");

        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//textarea[@id='sb_form_q']"));
        searchBox.sendKeys(searchValue + Keys.ENTER);

        // 4- Verify title:
        //Expected: apple - Search
        String expectedTitle = ConfigurationReader.getProperty("expectedTitle");
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void bing_search_test2(){

        //2- Go to: https://bing.com
        //Driver.getDriver() ---> will return me the "driver"
        //instead of writing "driver" from now on, we will write Driver.getDriver();
        Driver.getDriver().get(ConfigurationReader.getProperty("bingURL"));

        //3- Write “apple” in search box

        //locate the search box
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//textarea[@name='q']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search
        //Expected: flowers - Search
        BrowserUtils.sleep(2);
        String actualTitle = Driver.getDriver().getTitle();

        //String expectedTitle = "apple - Search";
        //We are just making the expectedTitle dynamic based on the text we are searching.
        String expectedTitle = ConfigurationReader.getProperty("searchValue")+" - Search";

        Assert.assertTrue(actualTitle.equals(expectedTitle));


    }

    @AfterMethod
    public void tearDownMethod(){
        /*
        We won't be using the selenium's quit method directly anymore.[causes exception]

        Driver.getDriver().quit(); --> no more using this method

        We will use Driver.closeDriver();
         */

        Driver.closeDriver();

    }
}
