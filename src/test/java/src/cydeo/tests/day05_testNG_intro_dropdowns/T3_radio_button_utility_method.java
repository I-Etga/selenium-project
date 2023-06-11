package src.cydeo.tests.day05_testNG_intro_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import src.cydeo.utilities.WebDriverFactory;

import java.time.Duration;
import java.util.List;

public class T3_radio_button_utility_method {

    public static void main(String[] args) throws InterruptedException {
        //TC #3: Radiobutton handling
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        //click and verify hockey radio button is selected.
        clickAndVerifyRadioButton(driver, "sport", "hockey");
        //click and verify red radio button is selected.
        clickAndVerifyRadioButton(driver, "color", "red");

    }

    private static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String expectedID) {
        //Locate all-of-the 'sports' radio buttons, and store them in a List<WebElement>
        List<WebElement> sportsRadioButtons = driver.findElements(By.xpath("//input[@name='" + nameAttribute + "']"));
        //List<WebElement> sportsRadioButtons = driver.findElements(By.name(nameAttribute);

        // There is a shortcut --> type "iter"+ enter or sportsRadioButtons.for + enter
        for (WebElement each : sportsRadioButtons) {
            String actualID = each.getAttribute("id");
            System.out.println("actualID = " + actualID);

            if (actualID.equals(expectedID)) {
                each.click();
                System.out.println(actualID + " is selected= " + each.isSelected());
                break;
            }
        }
    }
}
