package src.cydeo.tests.day10_upload_actions_jsexecuter;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.ConfigurationReader;
import src.cydeo.utilities.Driver;

public class TC1_registrationForm extends TestBase {
//TC#1: Registration form confirmation

    @Test
    public void registrationFrom_test1() {

        //2. Go to website: https://practice.cydeo.com/registration_form
        String URL = ConfigurationReader.getProperty("practiceRegistrationFromURL");
        Driver.getDriver().get(URL);

        //create Faker obj
        Faker faker = new Faker();
        //3. Enter first name
        WebElement firstnameBox = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstnameBox.sendKeys(faker.name().firstName());
        //4. Enter last name
        WebElement lastnameBox = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastnameBox.sendKeys(faker.name().firstName() + faker.name().lastName());
        //5. Enter username
        WebElement usernameBox = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        usernameBox.sendKeys(faker.name().fullName().replace(" ", ""));
        //6. Enter email address
        WebElement emailBox = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        emailBox.sendKeys(faker.internet().emailAddress());
        //7. Enter password
        WebElement passwordBox = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        passwordBox.sendKeys(faker.internet().password(8, 11, true, true, true));
        //8. Enter phone number
        WebElement phoneBox = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneBox.sendKeys(faker.numerify("571-###-####"));
        //9. Select a gender from radio buttons
        WebElement selectMaleRadioBtn = Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
        selectMaleRadioBtn.click();
        //10.Enter date of birth
        WebElement dateOfBirth = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirth.sendKeys("04/07/1987");
        //11.Select Department/Office
        Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        select.selectByValue("DE");

        //12.Select Job Title
        Select select1 = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        select1.selectByVisibleText("SDET");
        //13.Select programming language from checkboxes
        WebElement programmingLanguageCB = Driver.getDriver().findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        programmingLanguageCB.click();
        //14.Click to sign up button
        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));
        signUpButton.click();
        //15.Verify success message “You’ve successfully completed registration.” is displayed.
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//div[@id='content']//p"));

        String expectedMessage = "You’ve successfully completed registration.";
        String actualMessage = successMessage.getText();

        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertEquals(actualMessage, expectedMessage);
    }


}
