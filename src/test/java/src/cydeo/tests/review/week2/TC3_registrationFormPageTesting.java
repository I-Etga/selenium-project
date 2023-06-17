package src.cydeo.tests.review.week2;

import org.openqa.selenium.WebDriver;
import src.cydeo.utilities.WebDriverFactory;

import java.time.Duration;

public class TC3_registrationFormPageTesting {

    public static void main(String[] args) {
        // TC#3: Registration Form Page Testing

        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // 2. Go to https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        // 3. Verify title is as expected:
        // Expected: "Registration Form"
        String expectedTitle = "Registration Form";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title Verification PASSED!");
        } else {
            System.out.println("Title Verification FAILED!");
        }

    }
}
