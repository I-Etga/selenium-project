package src.cydeo.tests.day03_cssSelector_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import src.cydeo.utilities.WebDriverFactory;

public class T2_locators_getText_getAttribute {
    public static void main(String[] args) throws InterruptedException {

        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        // 1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        String expectedText = "Remember me on this computer";
        String actualText = driver.findElement(By.className("login-item-checkbox-label")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("\"Remember me\" label text verification PASSED!");
        } else {
            System.out.println("\"Remember me\" label text verification FAILED!");
        }

        // 4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        expectedText = "FORGOT YOUR PASSWORD?";
        actualText = driver.findElement(By.className("login-link-forgot-pass")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("\"Forgot password\" link text verification PASSED!");

        } else {
            System.out.println("\"Forgot password\" label text verification FAILED!");
        }

        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
        expectedText = "forgot_password=yes";
        actualText = driver.findElement(By.className("login-link-forgot-pass")).getAttribute("href");

        if (actualText.contains(expectedText)) {
            System.out.println("\"Forgot password\" href attribute's value verification PASSED!");

        } else {
            System.out.println("\"Forgot password\" href attribute's value verification FAILED!");
        }

        //PS: Inspect and decide which locator you should be using to locate web elements.

        Thread.sleep(3000);
        driver.close();
    }

}
