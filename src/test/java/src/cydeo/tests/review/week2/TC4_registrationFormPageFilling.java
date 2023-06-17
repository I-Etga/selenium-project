package src.cydeo.tests.review.week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import src.cydeo.utilities.WebDriverFactory;

import java.time.Duration;

public class TC4_registrationFormPageFilling {

    public static void main(String[] args) {
        // TC#4: Registration Form Page Filling Form Test

        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        // 2. Go to https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        // 3. Enter First name: "John"
        WebElement firstNameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameBox.sendKeys("John");
        // 4. Enter Last name: "Smith"
        WebElement lastNameBox = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameBox.sendKeys("Smith");
        // 5. Enter Username: "johnsmith123"
        WebElement userNameBox = driver.findElement(By.xpath("//input[@name='username']"));
        userNameBox.sendKeys("johnsmith123");
        // 6. Enter Email address: "john.smith@email.com"
        WebElement emailBox = driver.findElement(By.xpath("//input[@name='email']"));
        emailBox.sendKeys("john.smith@email.com");
        // 7. Enter password: "John1234"
        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='password']"));
        passwordBox.sendKeys("John1234");
        // 8. Enter Phone number: "123-456-7890"
        WebElement phoneNumberBox = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneNumberBox.sendKeys("123-456-7890");
        // 9. Click to "Male" from Gender
        WebElement radioButtonMale = driver.findElement(By.xpath("//input[@value='male']"));
        radioButtonMale.click();

        // 10. Enter Date of birth "01/28/1990"
        WebElement dateOfBirthBox = driver.findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirthBox.sendKeys("01/28/1990");

        // 11. Select "Department of Engineering" from Department/Office dropdown
        WebElement selectDepartmentDD = driver.findElement(By.xpath("//option[@value='DE']"));
        selectDepartmentDD.click();

        // 12. Select "SDET" from Job title dropdown
        WebElement selectJobDD = driver.findElement(By.xpath("//option[.='SDET']"));
        selectJobDD.click();

        // 13. Click to "Java" from languages
        WebElement programmingLanguageCheckBox = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        programmingLanguageCheckBox.click();

        // 14. Click to "Sign up" button
        WebElement signUpButton = driver.findElement(By.xpath("//button[@id='wooden_spoon']"));
        signUpButton.click();

        // 15. Verify text displayed on page
        //     Expected: "Well done!"
        String expectedText = "Well done!";
        String actualText = driver.findElement(By.xpath("//h4[@class='alert-heading']")).getText();

        if (expectedText.equals(actualText)) {
            System.out.println("Text Verification PASSED!");
        } else {
            System.out.println("Text Verification FAILED!");
            System.out.println(actualText);


        }
    }
}
