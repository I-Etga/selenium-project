package src.cydeo.tests.review.week4;


import org.testng.Assert;
import org.testng.annotations.Test;
import src.cydeo.pages.LibraryLoginPage;
import src.cydeo.utilities.Driver;

public class LibraryLoginTest {

    @Test
    public void required_field_error_message_test(){
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");

        //3- Do not enter any information

        //4- Click to “Sign in” button
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();

        libraryLoginPage.signInButton.click();

        //5- Verify expected error is displayed:
        //Expected: This field is required.
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());

    }


}
