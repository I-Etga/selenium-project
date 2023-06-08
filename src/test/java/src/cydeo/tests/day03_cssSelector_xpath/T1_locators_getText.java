package src.cydeo.tests.day03_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import src.cydeo.utilities.WebDriverFactory;

public class T1_locators_getText {

    public static void main(String[] args) throws InterruptedException {

        //TC #1: NextBaseCRM, locators and getText() practice
        // 1- Open a Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = WebDriverFactory.getDriver("crome");
        driver.manage().window().maximize();


        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Enter incorrect username: “incorrect”
        WebElement usernameInput = driver.findElement(By.name("USER_LOGIN"));
        usernameInput.sendKeys("incorrect");

        //4- Enter incorrect password: “incorrect”
        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
        passwordInput.sendKeys("incorrect");

        //5- Click to login button.
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password

        String expectedErrorMessage = "Incorrect login or password";
        String actualErrorMessage = driver.findElement(By.className("errortext")).getText();

        if (actualErrorMessage.equals(expectedErrorMessage)) {
            System.out.println("Error text verification PASSED!");
        } else {
            System.out.println("Error text verification FAILED!");
        }


        Thread.sleep(3000);
        driver.close();


        //PS: Inspect and decide which locator you should be using to locate web elements.
    }
}
