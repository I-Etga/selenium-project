package src.cydeo.tests.day04_findElements_checkboxes_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import src.cydeo.utilities.WebDriverFactory;

import java.util.List;

public class T2_FindElements {
    public static void main(String[] args) {
        //TC #2: FindElements Task
        //1- Open a Chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

        //3- Locate all the links in the page.
        List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));

        //4- Print out the number of the links on the page.
        System.out.println("number of links = " + listOfLinks.size());
        // 5- Print out the texts of the links.
        //6- Print out the HREF attribute values of the links
        for (WebElement each : listOfLinks) {
            System.out.println("Text of link: " + each.getText());
            System.out.println("HREF attribute'value: " + each.getAttribute("href"));
        }


    }
}
