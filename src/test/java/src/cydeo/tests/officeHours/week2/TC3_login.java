package src.cydeo.tests.officeHours.week2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.ConfigurationReader;
import src.cydeo.utilities.Driver;

public class TC3_login extends TestBase {
    // ** TC003 As a user I should be able to login with valid credentials
    //Setup & teardown methods come from TestBase superclass !!

    @Test
    public void loginTest(){

        // 2- Go to "https://seamlessly.net/"
        Driver.getDriver().get(ConfigurationReader.getProperty("seamlesslyURL"));

        // 3- Click Login label
        WebElement loginLabel = Driver.getDriver().findElement(By.linkText("Login"));
        loginLabel.click();

        // 4- Login to application with username as "Employee61" and password as "Employee123"
        WebElement inputUsername = Driver.getDriver().findElement(By.xpath("//input[@id='user']"));
        inputUsername.sendKeys("Employee61");

        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@id='password']"));
        inputPassword.sendKeys("Employee123" + Keys.ENTER);

        // 5- Verify the title contains "Files"
        String expectedTitle = "Files";
        String actualTitle = Driver.getDriver().getTitle();

        System.out.println("actualTitle.contains(expectedTitle) = " + actualTitle.contains(expectedTitle));

        Assert.assertTrue(actualTitle.contains(expectedTitle));


    }
}
