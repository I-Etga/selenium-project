package src.cydeo.tests.day10_upload_actions_jsexecuter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.ConfigurationReader;
import src.cydeo.utilities.Driver;

public class T3_actions_hover extends TestBase {
    @Test
    public void hover_test1(){
        //TC #3: Hover Test

        //1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get(ConfigurationReader.getProperty("practiceHoverURL"));

        //create Actions object

        Actions actions = new Actions(Driver.getDriver());

        // 2. Hover over to first image
        WebElement firstImage = Driver.getDriver().findElement(By.xpath("//div[@class='example']/div[1]"));
        //move to the first image[element]
        actions.moveToElement(firstImage).perform();

        //3. Assert:
        //a. “name: user1” is displayed
        WebElement name1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        Assert.assertTrue(name1.isDisplayed());

        // 4. Hover over to second image
        WebElement secondImage = Driver.getDriver().findElement(By.xpath("//div[@class='example']/div[2]"));
        actions.moveToElement(secondImage).perform();

        //5. Assert:
        //a. “name: user2” is displayed
        WebElement name2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        Assert.assertTrue(name2.isDisplayed());


        // 6. Hover over to third image
        WebElement thirdImage = Driver.getDriver().findElement(By.xpath("//div[@class='example']/div[3]"));
        actions.moveToElement(thirdImage).perform();

        //7. Confirm:
        //a. “name: user3” is displayed
        WebElement name3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));// sometimes . does not work. User @text
        Assert.assertTrue(name3.isDisplayed());
    }
}
