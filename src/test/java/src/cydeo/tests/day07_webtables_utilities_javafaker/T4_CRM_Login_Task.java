package src.cydeo.tests.day07_webtables_utilities_javafaker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import src.cydeo.utilities.BrowserUtils;
import src.cydeo.utilities.CRM_Utilities;
import src.cydeo.utilities.WebDriverFactory;

import java.time.Duration;

public class T4_CRM_Login_Task {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Create new test and make setups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
    }

    @Test
    public void test1_crm_login() {
        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk45@cybertekschool.com");

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //5. Click to`LogIn`button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //6. Verify title is as expected:
        // Expected: Portal
        // We are waiting 3 secs for title to be loaded to "(2) Portal"
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(driver, "(2) Portal");

    }

    @Test
    public void test2_crm_login() {

        //Logging in using the utility method we created in CRM_Utilities class
        CRM_Utilities.login_crm(driver);

        //6. Verify title is as expected:
        // Expected: Portal
        // We are waiting 3 secs for title to be loaded to "(2) Portal"
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(driver, "(2) Portal");

    }

    @Test
    public void test3_crm_login() {

        //Logging in using the utility method we created in CRM_Utilities class
        //CRM_Utilities.login_crm(driver, "helpdesk1@cydeo.com", "UserUser");
        CRM_Utilities.login_crm(driver, "hr100@cybertekschool.com", "UserUser");

        //6. Verify title is as expected:
        // Expected: Portal
        // We are waiting 3 secs for title to be loaded to "(2) Portal"
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(driver, "(2) Portal");

    }
    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }
}
/*
Valid emails
hr1@cybertekschool.com,
hr100@cybertekschool.com,
helpdesk1@cybertekschool.com,
helpdesk45@cybertekschool.com
marketing10@cybertekschool.com
marketing 74@cybertekschool.com
 */