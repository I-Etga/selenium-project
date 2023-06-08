package src.cydeo.tests.day03_cssSelector_xpath.hwp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import src.cydeo.utilities.WebDriverFactory;

public class HWP2_ZeroBankHeaderVerification {

    public static void main(String[] args) {
        //HWP #2: Zero Bank header verification
        // 1. Open Chrome browse
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        // 3. Verify header text
        // Expected: “Log in to ZeroBank”

        String expectedHeader = "Log in to ZeroBank";
        String actualHeader = driver.findElement(By.tagName("h3")).getText();
        if (expectedHeader.equals(actualHeader)) {
            System.out.println("Header verification PASSED!");
        } else {
            System.out.println("Header verification FAILED!");
        }


    }

}
