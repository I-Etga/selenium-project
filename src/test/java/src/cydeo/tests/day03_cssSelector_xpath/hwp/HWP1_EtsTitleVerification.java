package src.cydeo.tests.day03_cssSelector_xpath.hwp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import src.cydeo.utilities.WebDriverFactory;

public class HWP1_EtsTitleVerification {

    public static void main(String[] args) {
        //HWP #1: Etsy Title Verification
        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");

        //3.1-Accept cookies
        WebElement cookiesAcceptButton = driver.findElement(By.cssSelector("button[class='wt-btn wt-btn--filled wt-mb-xs-0']"));
        cookiesAcceptButton.click();

     /*   //3.2-Adjust cookies
        WebElement cookiesSettingButton = driver.findElement(By.cssSelector("button[class='wt-btn wt-btn--transparent']"));
        cookiesSettingButton.click();

        WebElement cookiesDoneButton = driver.findElement(By.cssSelector("button[class='wt-btn wt-btn--primary wt-pl-xs-8 wt-pr-xs-8 wt-pl-sm-10 wt-pr-sm-10 wt-pl-md-3 wt-pr-md-3 wt-pl-lg-3 wt-pr-lg-3 wt-pl-xl-3 wt-pr-xl-3 wt-pl-tv-3 wt-pr-tv-3']"));
        //cookiesDoneButton.click(); --> (locator works but click method does not work)
                            */

        // 4. Search for “wooden spoon”
        WebElement searchBox = driver.findElement(By.cssSelector("input#global-enhancements-search-query")); // id(#) and class(.) attributes have shortcut !
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);

        // 5. Verify title:
        // Expected: “Wooden spoon - Etsy DE”
        String expectedTitle = "Wooden spoon - Etsy DE";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!");
        }

        driver.close();
    }
}
