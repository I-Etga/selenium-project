package src.cydeo.tests.officeHours.week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.ConfigurationReader;
import src.cydeo.utilities.Driver;

public class TC1_checkbox extends TestBase {

    @Test
    public void checkboxTest() throws InterruptedException {
        //**  TC001 As a user I should be able to click checkboxes

        //  2-goto https://practice.cydeo.com/
        Driver.getDriver().get(ConfigurationReader.getProperty("practiceURL1"));

        //  3-click Checkboxes
        //WebElement checkboxesLink =Driver.getDriver().findElement(By.xpath("//a[.='Checkboxes']"));
        WebElement checkboxesLink = Driver.getDriver().findElement(By.linkText("Checkboxes"));
        checkboxesLink.click();

        //  4-verify title contains Checkboxes
        String expectedTitle = "Checkboxes";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        Thread.sleep(3000);

        //  5-click Checkbox 1
        WebElement checkbox1 = Driver.getDriver().findElement(By.xpath("//input[@id='box1']"));
        checkbox1.click();

        //  6-verify the Checkbox 1 is checked
        Assert.assertTrue(checkbox1.isSelected());


        //  7-click Checkbox 2
        WebElement checkbox2 = Driver.getDriver().findElement(By.xpath("//input[@id='box2']"));
        checkbox2.click();

        Thread.sleep(3000);
        //  8-verify the Checkbox 2 is checked
        Assert.assertTrue(checkbox2.isSelected());
        // checkbox2 is selected by default. So if we click, then it's unselected. That's why test fails !!

    }


}
