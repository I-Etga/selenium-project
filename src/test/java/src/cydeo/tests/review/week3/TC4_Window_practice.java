package src.cydeo.tests.review.week3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.Driver;

public class TC4_Window_practice extends TestBase {
    // TC : Windows handle practice


    @Test
    public void window_practice_test1() {
        //    2. Go to website: https://demoqa.com/browser-windows
        Driver.getDriver().get("https://demoqa.com/browser-windows");

        //    3. Click on New Tab button

        WebElement newTabButton = Driver.getDriver().findElement(By.xpath("//button[@id='tabButton']"));
        newTabButton.click();

        //    4. Click on New Window button
        WebElement newWindowButton = Driver.getDriver().findElement(By.xpath("//button[@id='windowButton']"));
        newWindowButton.click();

        //    5. Click on New Window Message button
        WebElement messageWindowButton = Driver.getDriver().findElement(By.xpath("//button[@id='messageWindowButton']"));
        messageWindowButton.click();

        //    6. Store parent window handle id in a variable
        String parentWindowHandle = Driver.getDriver().getWindowHandle();
        System.out.println("parentWindowHandle = " + parentWindowHandle);
        System.out.println("Driver.getDriver().getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());


        //    7. Store all window handle ids in to a Set
        for (String each : Driver.getDriver().getWindowHandles()) {

            Driver.getDriver().switchTo().window(each);
            //    9. Print out each window title
            System.out.println("Driver.getDriver().getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());
            System.out.println("Current title while switching windows: " + Driver.getDriver().getTitle()); // there are no title in the html pages !!
            System.out.println("Current handle while switching windows: " + Driver.getDriver().getWindowHandle());

        }

    }

}
