package src.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_LibraryVerifications {
    public static void main(String[] args) throws InterruptedException {

        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //2. Go to http://library2.cybertekschool.com/login.html
        driver.get("http://library2.cybertekschool.com/login.html");

        //3. Enter username: “incorrect@email.com”
        WebElement inputEmailAdress = driver.findElement(By.className("form-control"));
        inputEmailAdress.sendKeys("incorrect@email.com");
        //4. Enter password: “incorrect password”
        WebElement inputPassword = driver.findElement(By.id("inputPassword"));
        inputPassword.sendKeys("incorrect password");

        //5- Locate Sign in button using : tagName locator
        WebElement signButton = driver.findElement(By.tagName("button")); // That's the only button on tested page !!
        signButton.click();

        Thread.sleep(3000);
        driver.close();

        //. Verify: visually “Sorry, Wrong Email or Password” displayed
        // VERIFIED
    }
}
/*
PS: Locate username input box using “className” locator
Locate password input box using “id” locator
Locate Sign in button using “tagName” locator
 */
