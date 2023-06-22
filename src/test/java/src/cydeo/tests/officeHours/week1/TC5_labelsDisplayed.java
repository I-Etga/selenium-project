package src.cydeo.tests.officeHours.week1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.Driver;

import java.util.List;

public class TC5_labelsDisplayed extends TestBase {

    @Test
    public void labelsDisplayedTest() {

        //** TC005 As a user I should be able to see;
        // Home, About us, Our Approach,
        // Product and Services, Contact
        // and LOGIN labels are displayed

        // 2- Go to "https://vytrack.com"
        Driver.getDriver().get("https://vytrack.com/");

        //  3-verify Home, About us, Our Approach,
        //  Products and Services, Contact and LOGIN labels are displayed

        List<WebElement> labels = Driver.getDriver().findElements(By.xpath("//ul[@id='top-menu']/li"));

        for (WebElement each : labels) {
            if (each.isDisplayed()) {
                System.out.println(each.getText() + " isDisplayed");
            } else {
                System.out.println(each.getText() + " isNotDisplayed");
            }
            Assert.assertTrue(each.isDisplayed());
        }

    }
}
