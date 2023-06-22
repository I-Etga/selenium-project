package src.cydeo.tests.review.week3;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.Driver;

public class TC1_JavaFaker_Practice extends TestBase {
    // TC: Java Faker practice


    @Test
    public void test1_javaFaker() {

        // 2. Go to https://practice.cydeo.com/login
        Driver.getDriver().get("https://practice.cydeo.com/login");

        //create Faker object
        Faker faker = new Faker();

        // 3. Enter username using java faker
        String randomUsername = faker.name().username();

        WebElement inputUsername = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        inputUsername.sendKeys(randomUsername);

        // 4. Enter password using java faker
        String randomPassword = faker.internet().password(10, 15, true, true, true);

        WebElement passwordUsername = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        passwordUsername.sendKeys(randomPassword);

        // 5. Click to Log in button
        WebElement clickButton = Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));
        clickButton.click();

        // 6. Verify text displayed on page
        //    Expected: "Your username is invalid!"
        WebElement flashAlert = Driver.getDriver().findElement(By.xpath("//div[@id='flash']"));
        String expectedText = "Your username is invalid!";
        String actualText = flashAlert.getText();

        Assert.assertTrue(flashAlert.isDisplayed());
        Assert.assertTrue(actualText.contains(expectedText));

    }

}
