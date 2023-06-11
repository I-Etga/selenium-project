package src.cydeo.tests.day05_testNG_intro_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import src.cydeo.utilities.WebDriverFactory;

import java.time.Duration;

public class T2_radio_buttons {
    public static void main(String[] args) throws InterruptedException {
        //XPATH PRACTICES
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #2: Radiobutton handling
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        //3. Click to “Hockey” radio button
        WebElement hockeyRadioButton = driver.findElement(By.xpath("//input[@id='hockey']"));

        Thread.sleep(2000);
        hockeyRadioButton.click();

        //4. Verify “Hockey” radio button is selected after clicking.
        if (hockeyRadioButton.isSelected()) {
            System.out.println("Button is selected. Verification PASSED!");
        } else {
            System.out.println("Button is selected. Verification FAILED!");
        }
        //USE XPATH LOCATOR FOR ALL Web Element LOCATORS
    }

}
