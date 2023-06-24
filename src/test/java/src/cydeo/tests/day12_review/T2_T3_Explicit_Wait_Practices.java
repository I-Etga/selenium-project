package src.cydeo.tests.day12_review;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import src.cydeo.pages.DynamicControlsPage;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.BrowserUtils;
import src.cydeo.utilities.Driver;

public class T2_T3_Explicit_Wait_Practices extends TestBase {
    //create DynamicControlsPage object
    DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    @Override
    public void setup() {
        super.setup();
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls ");
        dynamicControlsPage = new DynamicControlsPage();

    }

    @Test
    public void t2_remove_checkbox_test() {

        //TC #2: Explicit wait practice

        // 3- Click to “Remove” button
        dynamicControlsPage.removeButton.click();

       /* //4- Wait until “loading bar disappears” [specific situation. So explicit wait through WebDriverWait]
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));*/

        //line 38-42 utilized !!
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Checkbox is not displayed
        // dynamicControlsPage.checkbox.isDisplayed() --> if displayed, returns true;
        // dynamicControlsPage.checkbox.isDisplayed() --> if not displayed, returns false;

        //Assert.assertTrue(!dynamicControlsPage.checkbox.isSelected());
        try {
            //assertFalse method is expecting a "false" boolean value to PASS the test.
            Assert.assertFalse(dynamicControlsPage.checkbox.isSelected());
        } catch (NoSuchElementException n) {
            //n.printStackTrace();
            System.out.println("NoSuchElementException is thrown. It means that the Checkbox is not on the page.");
            Assert.assertTrue(true);
        }

        //b. “It’s gone!” message is displayed.

        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());


        //NOTE: FOLLOW POM
    }

    @Test
    public void t3_enableTextBox_test() {
        //TC #3: Explicit wait practice

        // 3- Click to “Enable” button
        dynamicControlsPage.enableButton.click();


        //4- Wait until “loading bar disappears”
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);


        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(dynamicControlsPage.inputBox.isEnabled(), "Input box is not enable!!");

        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed(), "Message is not enabled!!");
        Assert.assertTrue(dynamicControlsPage.message.getText().equals("It's enabled!"));

        //NOTE: FOLLOW POM
    }
}
