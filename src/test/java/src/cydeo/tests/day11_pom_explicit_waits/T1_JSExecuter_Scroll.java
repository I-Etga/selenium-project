package src.cydeo.tests.day11_pom_explicit_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.BrowserUtils;
import src.cydeo.utilities.Driver;

public class T1_JSExecuter_Scroll extends TestBase {
    //TC #1: Scroll using JavascriptExecutor

    @Test
    public void scroll_using_js_executor() {

        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");

        //Locating the links to be used later
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));

        //create JSExecuter object
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


        // 3- Scroll down to “Cydeo” link
        js.executeScript("arguments[0].scrollIntoView(true)", cydeoLink, homeLink);

        //4- Scroll up to “Home” link
        BrowserUtils.sleep(2);
        //js.executeScript("arguments[1].scrollIntoView(true)",cydeoLink,homeLink);
        js.executeScript("arguments[0].scrollIntoView(true)", homeLink);


        //Use below provided JS method only
        //JavaScript method to use : arguments[0].scrollIntoView(true)
        //Note: You need to locate the links as web elements and pass them as arguments into executeScript() method
    }
}
