package src.cydeo.tests.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import src.cydeo.utilities.Driver;

import java.time.Duration;

// This class is the parent of all Test classes
// You will update this class based on what you are keep writing in your most test classes
// instead writing in all test classes, you can just write in this class
// and you can extend this class from any class
// This class is abstract because we don't want to create any object with using this class
public abstract class TestBase {


    @BeforeMethod
    public void setup() {
        // 1. Open Chrome browser
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
        //driver.close();
    }
}