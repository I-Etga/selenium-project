package src.cydeo.tests.review.week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import src.cydeo.utilities.WebDriverFactory;

import java.time.Duration;

public class TC2_practicePage_login {
    public static void main(String[] args) {
        // TC#2: Practice page Login test
        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        // 2. Go to https://practice.cydeo.com/login
        driver.get("https://practice.cydeo.com/login");

        // 3. Enter username: "tomsmith"
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='username']"));
        inputUsername.sendKeys("tomsmith");

        // 4. Enter password: "SuperSecretPassword"
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='password']"));
        inputPassword.sendKeys("SuperSecretPassword");

        // 5. Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='wooden_spoon']"));
        loginButton.click();

        // 6. Verify text displayed on page
        //    Expected: "You logged into a secure area!"
        String expectedText = "You logged into a secure area!"; // failed
        //String expectedText = "You logged into a secure area!\n" + "×"; // passed
        String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();

        /*
          WebElement resultText1 = driver.findElement(By.cssSelector(".flash.success"));

          //How to handle white spaces !![normalize-space(text())='']
        WebElement resultText2 = driver.findElement(By.xpath("//div[normalize-space(text())='You logged into a secure area!']"));
         */

        if (actualText.contains(expectedText)) {
            System.out.println("Text Verification PASSED!");
        } else {
            System.out.println("Text Verification FAILED!");
        }

        driver.quit();

    }
}
