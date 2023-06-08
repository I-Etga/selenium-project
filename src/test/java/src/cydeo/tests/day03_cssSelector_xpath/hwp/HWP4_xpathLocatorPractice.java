package src.cydeo.tests.day03_cssSelector_xpath.hwp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import src.cydeo.utilities.WebDriverFactory;

public class HWP4_xpathLocatorPractice {

    public static void main(String[] args) {

        //HWP #4: Practice Cydeo – xpath locator practice
        // 1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");

        // 3- Click to “Home” link
        WebElement homeButton = driver.findElement(By.xpath("//a[@class='nav-link']"));
        homeButton.click();

        // 4- Verify title is as expected:
        // Expected: Practice
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!");
        }


        // PS: Locate “Home” link using “xpath” locator
    }
}
