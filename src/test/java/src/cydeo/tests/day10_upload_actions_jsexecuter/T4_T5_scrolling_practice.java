package src.cydeo.tests.day10_upload_actions_jsexecuter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.BrowserUtils;
import src.cydeo.utilities.ConfigurationReader;
import src.cydeo.utilities.Driver;

public class T4_T5_scrolling_practice extends TestBase {

    @Test
    public void t4_t5_scrolling_practice() {
        //TC #4: Scroll practice

        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get(ConfigurationReader.getProperty("practiceURL1"));
        //locate driver
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        //Create Actions object
        Actions actions = new Actions(Driver.getDriver());

        //3- Scroll down to “Powered by CYDEO”
        actions.moveToElement(cydeoLink).perform();
        BrowserUtils.sleep(3);
        //4- Scroll using Actions class “moveTo(element)” method


        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.
        // 2- Scroll back up to “Home” link using PageUP button
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_DOWN).perform();

    }
}
