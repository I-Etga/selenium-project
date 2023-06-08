package src.cydeo.tests.day03_cssSelector_xpath.hwp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import src.cydeo.utilities.WebDriverFactory;

public class HWP3_BackAndForthNavigation {

    public static void main(String[] args) {

        //TC #3: Back and forth navigation
        // 1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


        // 2- Go to: https://google.com
        driver.get("https://google.com");

        //3-Reject cookies
        WebElement allRejectButton = driver.findElement(By.cssSelector("button#W0wltc"));
        // This is shortcut.Only possible for id and class attributes. "button[id='W0wltc']"

        //WebElement allRejectButton = driver.findElement(By.cssSelector("button.tHlp8d"));
        // --> There are 6 web element whose class attribute's value 'tHlp8d'. So not useful.
        // It will be located on the first one.

        allRejectButton.click();


        // 4- Click to Gmail from top right.
        WebElement gmailButton = driver.findElement(By.cssSelector("a[href='https://mail.google.com/mail/&ogbl']"));
        gmailButton.click();

        // 5- Verify title contains:
        // Expected: Gmail
        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("\"Gmail\" Title verification PASSED!");
        } else {
            System.out.println("\"Gmail\" Title verification FAILED!");
        }

        // 6- Go back to Google by using the .back();
        driver.navigate().back();

        // 7- Verify title equals:
        // Expected: Google
        expectedTitle = "Google";
        actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("\"Google\"Title verification PASSED!");
        } else {
            System.out.println("\"Google\"Title verification FAILED!");
        }

        driver.close();
    }
}
