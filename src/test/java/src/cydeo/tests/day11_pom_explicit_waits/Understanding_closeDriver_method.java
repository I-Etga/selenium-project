package src.cydeo.tests.day11_pom_explicit_waits;

import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.Driver;

public class Understanding_closeDriver_method extends TestBase {

    @Test
    public void test1() {
        Driver.getDriver().get("https://google.com");
        //verify something
        //Driver.getDriver() --> driver
        //Driver.getDriver().close();
        Driver.closeDriver();
    }

    @Test
    public void test2() {
        Driver.getDriver().get("https://google.com");
        //verify something else
        //Driver.getDriver().close();
        Driver.closeDriver();
    }

    @Test
    public void test3() {
        Driver.getDriver().get("https://google.com");
        //verify something completely different
        //Driver.getDriver().close();
        Driver.closeDriver();
    }
}
