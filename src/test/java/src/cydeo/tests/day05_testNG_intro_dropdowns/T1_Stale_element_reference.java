package src.cydeo.tests.day05_testNG_intro_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import src.cydeo.utilities.WebDriverFactory;

import java.time.Duration;

public class T1_Stale_element_reference {


    public static void main(String[] args) throws InterruptedException {
        //XPATH PRACTICES
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #1: StaleElementReferenceException handling
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        // 3. Click to “Add Element” button
        WebElement addElementButton = driver.findElement(By.xpath("//div[@class='example']/button"));
        //WebElement addElementButton = driver.findElement(By.xpath("//button[.='Add Element']"));
        addElementButton.click();

        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//div[@id='elements']/button"));
        //WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));
        System.out.println("deleteButtonIsDisplayed, expecting true= " + deleteButton.isDisplayed());

        //5. Click to “Delete” button.
        Thread.sleep(2000);
        deleteButton.click();

        //6. Verify “Delete” button is NOT displayed after clicking.
        try {
            System.out.println("deleteButtonIsDisplayed, expecting false= " + deleteButton.isDisplayed());
            // It throws StaleElementReferenceException.
        } catch (StaleElementReferenceException e) {
            System.out.println("--> StaleElementReferenceException happened due to element being deleted from the page.");
            System.out.println("Which concludes our test case -PASSING!-");
            System.out.println("deleteButton.isDisplayed()= false");
        }

        //USE XPATH LOCATOR FOR ALL WEB ELEMENT LOCATORS

        //driver.close();
    }
}
