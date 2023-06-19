package src.cydeo.tests.review.week3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.ConfigurationReader;
import src.cydeo.utilities.Driver;

public class TC2_Alert_practice extends TestBase {
    //// TC : Alert practice


    @Test
    public void test1_JSAlert() {
        // 2. Go to website: https://practice.cydeo.com/javascript_alerts
        String URL = ConfigurationReader.getProperty("practiceJSAlertsURL");
        Driver.getDriver().get(URL);

        // 3. Click to “Click for JS Prompt” button
        WebElement clickJSPrompt = Driver.getDriver().findElement(By.xpath("//button[.='Click for JS Prompt']"));
        clickJSPrompt.click();

        // 4. Send “hello” text to alert
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys("hello");

        // 5. Click to OK button from the alert
        alert.accept();

        // 6. Verify “You entered: hello” text is displayed.
        WebElement message = Driver.getDriver().findElement(By.xpath("//p[@id='result']"));

        String expectedText = "You entered: hello";
        String actualText = message.getText();

        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals(actualText, expectedText);
    }

}
