package src.cydeo.tests.day10_upload_actions_jsexecuter;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.BrowserUtils;
import src.cydeo.utilities.ConfigurationReader;
import src.cydeo.utilities.Driver;

public class T6_JavaScriptExecutor_Practice extends TestBase {

    @Test
    public void infinite_scroll_test_using_JSExecuter() {

        //TC #6: Scroll using JavascriptExecutor


        //2- Go to: https://practice.cydeo.com/infinite_scroll
        Driver.getDriver().get(ConfigurationReader.getProperty("practiceInfiniteScrollURL"));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();



        // 3- Use below JavaScript method and scroll
        //a. 750 pixels down 10 times. b. 750 pixels up 10 times
        //JavaScript method to use : window.scrollBy(0,0)

        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(750,0)");
        }
    }
}
