package src.cydeo.tests.officeHours.week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.cydeo.utilities.ConfigurationReader;
import src.cydeo.utilities.Driver;

public class TC4_showPassword {
    // ** TC004 As a user I should be able to show password
    //Setup & teardown methods come from TestBase superclass !!

    @Test
    public void passwordTest() {

        // 2- Go to "https://seamlessly.net/"
        Driver.getDriver().get(ConfigurationReader.getProperty("seamlesslyURL"));

        // 3- Click Login label
        WebElement loginLabel = Driver.getDriver().findElement(By.linkText("Login"));
        loginLabel.click();

        // 4- Login to application with username as "Employee61" and password as "Employee123"
        WebElement inputUsername = Driver.getDriver().findElement(By.xpath("//input[@id='user']"));
        inputUsername.sendKeys("Employee61");

        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@id='password']"));
        inputPassword.sendKeys("Employee123");

        // 5- Click the eye toggle
        WebElement eyeToggle = Driver.getDriver().findElement(By.xpath("//img[@src='/core/img/actions/toggle.svg']"));
        eyeToggle.click();

        // 5- Verify the password is not hidden

        boolean isNotHidden = false;

        if (inputPassword.getAttribute("type").equals("text")) {
            isNotHidden = true;
        }
        Assert.assertTrue(isNotHidden);

    }
}
