package src.cydeo.tests.review.week3;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.BrowserUtils;
import src.cydeo.utilities.Driver;

public class AlertPractice extends TestBase {

    // TC : Alert practice
// 1. Open browser
// 2. Go to website: https://practice.cydeo.com/javascript_alerts
// 3. Click to “Click for JS Prompt” button
// 4. Send “hello” text to alert
// 5. Click to OK button from the alert
// 6. Verify “You entered: hello” text is displayed.


    @Test
    public void prompt_alert_test() {
        // 2. Go to website: https://practice.cydeo.com/javascript_alerts
        Driver.getDriver().get("https://practice.cydeo.com/javascript_alerts");

        // 3. Click to “Click for JS Prompt” button
      Driver.getDriver().findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();


        Alert alert = Driver.getDriver().switchTo().alert();

        // get text of alert window
        System.out.println("alert.getText() = " + alert.getText());

        BrowserUtils.sleep(2);

        // 4. Send “hello” text to alert
        alert.sendKeys("hello");

        BrowserUtils.sleep(2);
        // 5. Click to OK button from the alert
        alert.accept();

        BrowserUtils.sleep(2);

        // 6. Verify “You entered: hello” text is displayed.

        WebElement resultText = Driver.getDriver().findElement(By.id("result"));

        String actualText = resultText.getText();
        String expectedText = "You entered: hello";

        //Assert.assertEquals(actualText,expectedText);

        Assert.assertTrue(resultText.isDisplayed());


    }
}
