package src.cydeo.tests.officeHours.week1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.ConfigurationReader;
import src.cydeo.utilities.Driver;

public class TC1_isDisplayed extends TestBase {

    @Test
    public void test1() {
        // **  TC001 As a user I should be able to see Login label is displayed

        //  2-goto https://vytrack.com/
        String URL = ConfigurationReader.getProperty("vyTrackURL");
        Driver.getDriver().get(URL);

        //  3-verify Login is displayed
        WebElement loginLink = Driver.getDriver().findElement(By.xpath("//a[@href='http://app.vytrack.com']"));

        Assert.assertTrue(loginLink.isDisplayed());

    }

}
