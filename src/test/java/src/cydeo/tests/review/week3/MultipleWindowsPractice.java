package src.cydeo.tests.review.week3;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.Driver;

import java.util.Set;

public class MultipleWindowsPractice extends TestBase {

    @Test
    public void multiple_windows_handling_test(){

        // TC : Windows handle practice
        //    1. Open browser
        //    2. Go to website: https://demoqa.com/browser-windows
        Driver.getDriver().get("https://demoqa.com/browser-windows");

        //    3. Click on New Tab button
       Driver.getDriver().findElement(By.id("tabButton")).click();

        //    4. Click on New Window button
       Driver.getDriver().findElement(By.id("windowButton")).click();

        //    5. Click on New Window Message button
        Driver.getDriver().findElement(By.id("messageWindowButton")).click();

        //    6. Store parent window handle id in a variable
        String parentWindowHandle = Driver.getDriver().getWindowHandle();

        //    7. Store all window handle ids in to a Set
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        System.out.println("allWindowHandles.size() = " + allWindowHandles.size());

        //    9. Print out each window title
        for (String eachwindow : allWindowHandles) {

            System.out.println("Each window id: "+ eachwindow);
            Driver.getDriver().switchTo().window(eachwindow);
            System.out.println("Current window title: "+ Driver.getDriver().getTitle());

        }


    }
}
