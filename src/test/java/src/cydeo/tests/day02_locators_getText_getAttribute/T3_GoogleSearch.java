package src.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {

    public static void main(String[] args) {

        //TC#3: Google search
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        //Accepts all cookies. This is the privacy policy thing in Europe]--> Otherwise, we can't keep testing
        driver.findElement(By.id("W0wltc")).click();
        //driver.findElement(By.xpath("//button[@id='W0wltc']"));

        // 3- Write “apple” in search box
        //a. locate search box
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        // I'm looking for the name of the web element

        WebElement googleLogo = driver.findElement(By.className("lnXdpd"));
        //WebElement googleLogo = driver.findElement(By.xpath("//img[@class='lnXdpd']");
        // driver.findElement(By.cssSelector("img[class='lnXdpd']"));

        //b. enter "apple" key, and press ENTER
        googleSearchBox.sendKeys("apple" + Keys.ENTER);
        // sendKeys() accepts String

        // 4- Press ENTER to search
        //googleSearchBox.sendKeys(Keys.ENTER);

        //5- Verify title:
        //Expected: Title should start with “apple” word

        String expectedInBeginningOfTitle = "apple";
        String actualTitle = driver.getTitle();

        if (actualTitle.startsWith(expectedInBeginningOfTitle)) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!");
        }

        driver.close();
    }

}
