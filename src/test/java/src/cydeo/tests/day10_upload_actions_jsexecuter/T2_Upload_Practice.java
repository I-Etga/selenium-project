package src.cydeo.tests.day10_upload_actions_jsexecuter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.Driver;

import java.io.File;

public class T2_Upload_Practice extends TestBase {

    @Test
    public void upload_test1() {
        //TC #2 Upload Test

        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //2. Find some small file from your computer, and get the path of it.

        File file = new File("/Users/i.etga/Desktop/UploadPractice.txt");
        Assert.assertTrue(file.exists());
        // 3. Upload the file.
        WebElement uploadButton = Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']"));
        uploadButton.sendKeys("/Users/i.etga/Desktop/UploadPractice.txt");
        //4. Assert:
        // -File uploaded text is displayed on the page
        WebElement uploadMessage = Driver.getDriver().findElement(By.xpath("//div[@class='example']/h3"));

        Assert.assertTrue(uploadMessage.isDisplayed());


    }


}
