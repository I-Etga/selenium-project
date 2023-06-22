package src.cydeo.tests.officeHours.week1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.Driver;

public class TC4_passwordType extends TestBase {
    //  ** TC004 As a user I should be able to see the password hidden as default

    @Test
    public void test_typePassword(){
        // 2- Go to "https://vytrack.com"
        Driver.getDriver().get("https://vytrack.com/");

        // 3- Click Login label
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//li[@id='menu-item-849']"));
        loginButton.click();

        // 4- Login to application with username as "User1" and password as "UserUser123"
        WebElement inputUsername = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']"));
        inputUsername.sendKeys("User1");

        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']"));
        inputPassword.sendKeys("UserUser123");

        // 5- Verify the password is hidden
        Assert.assertEquals(inputPassword.getAttribute("type"),"password");
    }
}
