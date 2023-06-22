package src.cydeo.tests.officeHours.week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.ConfigurationReader;
import src.cydeo.utilities.Driver;

public class TC2_favoriteColorSport extends TestBase {

    @Test
    public void favoriteCS_test() throws InterruptedException {

        //**  TC002 As a user I should be able to select my favorite color and sport


        //  2-goto https://practice.cydeo.com/
        Driver.getDriver().get(ConfigurationReader.getProperty("practiceURL"));

        //  3-click Radio Buttons
        WebElement radioButtonLink = Driver.getDriver().findElement(By.linkText("Radio Buttons"));
        radioButtonLink.click();

        //  4-verify title contains Radio buttons
        String expectedTitle = "Radio buttons";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //  5-select the favorite color as Red
        WebElement radioButtonRed = Driver.getDriver().findElement(By.xpath("//input[@id='red']"));
        radioButtonRed.click();

        //Thread.sleep(3000);// in order to see the process. Normally we don't use that !!

        //  6-verify the Red is selected
        System.out.println("radioButtonRed.isSelected() = " + radioButtonRed.isSelected());// in order to see what it returns
        Assert.assertTrue(radioButtonRed.isSelected());

        //  7-select the favorite sport as Football
        WebElement radioButtonFootball = Driver.getDriver().findElement(By.xpath("//input[@id='football']"));
        radioButtonFootball.click();

        //Thread.sleep(3000);// in order to see the process. Normally we don't use that !!

        //  8-verify the Football is selected
        System.out.println("radioButtonFootball.isSelected() = " + radioButtonFootball.isSelected());
        Assert.assertTrue(radioButtonFootball.isSelected());
    }
}
