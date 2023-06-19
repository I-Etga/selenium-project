package src.cydeo.tests.officeHours.week1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.ConfigurationReader;
import src.cydeo.utilities.Driver;

public class TC3_login_Test extends TestBase {

    //** TC003 As a user I should be able to login with valid credentials


    @Test
    public void login_test() throws InterruptedException {
        // 2- Go to "https://vytrack.com"
        String URL = ConfigurationReader.getProperty("vyTrackURL");
        Driver.getDriver().get(URL);

        // 3- Click Login label
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//li[@id='menu-item-849']"));
        loginButton.click();

        // 4- Login to application with username as "User1" and password as "UserUser123"
        WebElement inputUsername = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']"));
        inputUsername.sendKeys("User1");

        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']"));
        inputPassword.sendKeys("UserUser123" + Keys.ENTER);

        // 5- Verify the title is "Dashboard";

        String expectedTitle = "Dashboard";
        String actualTitle = Driver.getDriver().getTitle();

        Thread.sleep(3000);
        Assert.assertEquals(actualTitle, expectedTitle);

    }

}
