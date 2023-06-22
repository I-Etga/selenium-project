package src.cydeo.tests.day11_pom_explicit_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.Driver;

public class T2_to_T6_Actions_Practices extends TestBase {


    @Test
    public void test2_dropPoint() {
        //TC2 #: Drag and drop default value verification
        //1. Go to https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");

        WebElement dropPoint = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));

        // 2. Verify big circle default text is as below.
        String expectedText = "Drag the small circle here.";
        String actualText = dropPoint.getText();

        //3. Assert:
        Assert.assertEquals(actualText, expectedText);
        //-Text in big circle changed to: “Drag the small circle here.”

    }

    @Test
    public void test3_dragDrop() {
        //TC3 #: Drag and drop into the big circle
        //1. Go to https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");

        //Locating the circle web elements
        WebElement dropPoint = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));


        // 2. Drag and drop the small circle to bigger circle.
        Actions actions = new Actions(Driver.getDriver());
        //actions.dragAndDrop(smallCircle,dropPoint).perform();

        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(dropPoint)
                .pause(1000)
                .release()
                .perform();
        // 2. Verify big circle default text is as below.
        String expectedText = "You did great!";
        String actualText = dropPoint.getText();

        //3. Assert:
        Assert.assertEquals(actualText, expectedText);

        //-Text in big circle changed to: “You did great!”
    }

    @Test
    public void test4_clickAndHold() {
        // TC4 #: Click and hold
        //1. Go to https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");

        //Locating the circle web elements
        WebElement dropPoint = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));


        //2. Click and hold the small circle.
        Actions actions = new Actions(Driver.getDriver());
        //actions.dragAndDrop(smallCircle,dropPoint).perform();

        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(cydeoLink)
                .pause(1000)
                .perform();
        // 2. Verify big circle default text is as below.
        String expectedText = "Drop here.";
        String actualText = dropPoint.getText();

        //3. Assert:
        Assert.assertEquals(actualText, expectedText);

        //-Text in big circle changed to: “Drop here.”
    }

    @Test
    public void test5_dragDropOutsideDropPoint() {
        // TC4 #: Click and hold
        //1. Go to https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");

        //Locating the circle web elements
        WebElement dropPoint = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));


        // 2. Drag and drop the small circle to bigger circle.
        Actions actions = new Actions(Driver.getDriver());
        //actions.dragAndDrop(smallCircle,dropPoint).perform();

        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(cydeoLink)
                .pause(1000)
                .release()
                .pause(1000)
                .perform();
        // 2. Verify big circle default text is as below.
        String expectedText = "Try again!";
        String actualText = dropPoint.getText();

        //3. Assert:
        Assert.assertEquals(actualText, expectedText);

        //-Text in big circle changed to: “Try again!”

    }

    @Test
    public void test6_dragDropOutsideDropPoint() {
        // TC4 #: Click and hold
        //1. Go to https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");

        //Locating the circle web elements
        WebElement dropPoint = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));


        //Drag the small circle on top of the big circle, hold it, and verify.
        Actions actions = new Actions(Driver.getDriver());
        //actions.dragAndDrop(smallCircle,dropPoint).perform();

        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(dropPoint)
                .pause(1000)
                .pause(1000)
                .perform();
        // 2. Verify big circle default text is as below.
        String expectedText = "Now drop...";
        String actualText = dropPoint.getText();

        //3. Assert:
        Assert.assertEquals(actualText, expectedText);

        //-Text in big circle changed to: “Now drop...”

    }
}
