package src.cydeo.tests.review.week3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.Driver;

public class TC3_iFrame_practice extends TestBase {

    //// TC : Iframe practice

    @BeforeMethod
    public void setupMethod() {

        //2. Go to: https://login1.nextbasecrm.com/
        Driver.getDriver().get("https://login1.nextbasecrm.com/");

        //// 1. Users are already login and on the homepage of CRM app

        //Enter valid username
        WebElement inputUsername = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk45@cybertekschool.com");

        //Enter valid password
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //Click to`LogIn`button
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

    }

    @Test
    public void test1_crm_iFrame() {


        //create locator
        //switch to iFrame

        Driver.getDriver().findElement(By.xpath("//span[.='Message']")).click();
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//*[@id=\"bx-html-editor-iframe-cnt-idPostFormLHE_blogPostForm\"]/iframe")));
        WebElement messageTabIframe = Driver.getDriver().findElement(By.xpath("//body[@ contenteditable ='true']"));

        //Users write test message
        messageTabIframe.sendKeys("Hello Guys!");

        // back to parent/default frame
        Driver.getDriver().switchTo().parentFrame();

        // 4. Users click the SEND button
        WebElement sendButton = Driver.getDriver().findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

        // 5. Verify the message is displayed on the feed
        WebElement blogMessage = Driver.getDriver().findElement(By.xpath("//div[contains(@id,'blog_post_body')]"));

        String expectedText = "Hello Guys!";
        String actualText = blogMessage.getText();

        Assert.assertTrue(blogMessage.isDisplayed());
        Assert.assertEquals(actualText, expectedText);

    }

}


