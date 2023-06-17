package src.cydeo.tests.review.week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import src.cydeo.utilities.WebDriverFactory;

import java.time.Duration;

public class TC1_Navigations_getMethod_Practice {
    public static void main(String[] args) throws InterruptedException {
        // 1. Open a Chrome browser
        // 2. Go to: https://www.etsy.com
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to: https://www.etsy.com
        driver.get("https://www.etsy.com");

        // 3. Navigate to https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        // 4. Navigate back, forward and refresh
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        // 5. Write “selenium” in search box
        WebElement searchBox = driver.findElement(By.xpath(" //input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("selenium"); //  + Keys.ENTER

        // 6. Press search button to search
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        searchButton.click();

        // 7. Verify title is "Amazon.com : selenium"
        String expectedTitle = "Amazon.com : selenium";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title Verification PASSED!");
        } else {
            System.out.println("Title Verification FAILED!");
        }

        // 8. Verify url contains "selenium"
        String expectedPartialURL = "selenium";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedPartialURL)) {
            System.out.println("URL Verification PASSED!");
        } else {
            System.out.println("URL Verification FAILED!");
        }

        driver.quit();
    }
}
