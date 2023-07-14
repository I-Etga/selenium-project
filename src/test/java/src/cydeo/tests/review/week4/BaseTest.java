package src.cydeo.tests.review.week4;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import src.cydeo.utilities.ConfigurationReader;
import src.cydeo.utilities.Driver;

public abstract class BaseTest {

    @BeforeMethod
    public void setup(){

        Driver.getDriver().get(ConfigurationReader.getProperty("webtable.url"));

    }

    @AfterMethod
    public void teardown(){
        Driver.closeDriver();

        // You can also implement taking screenshot method here to take a screenshot after each test
    }
}
