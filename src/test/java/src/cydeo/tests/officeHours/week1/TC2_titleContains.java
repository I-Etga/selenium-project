package src.cydeo.tests.officeHours.week1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.ConfigurationReader;
import src.cydeo.utilities.Driver;

public class TC2_titleContains extends TestBase {

    //  ** TC002 As a user I should be able to see the login page

    @Test
    public void titleTest() {

        // 2- Go to "https://vytrack.com"
        String URL = ConfigurationReader.getProperty("vyTrackURL");
        Driver.getDriver().get(URL);

        // 3- Click Login label
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//li[@id='menu-item-849']"));
        loginButton.click();

        // 4- Verify the title contains "Login"
        String expectedTitle = "Login";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));


    }

}
