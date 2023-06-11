package src.cydeo.tests.day05_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_intro {
    //We're not going to use main() method anymore.


    @BeforeClass
    public void setupClass() {
        System.out.println("----> Before class is running!!!");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("----> After class is running !!!");
    }


    @BeforeMethod // run once before EACH TEST
    public void setupMethod() {
        System.out.println("--> Before method is running...");
    }

    @AfterMethod //run once After EACH TEST
    public void tearDownMethod() {
        System.out.println("--> After method is running...");
    }


    // Normally tests get executed in alphabetic order. However, it's not always good practice !!
    // There is a way that gives priority (changes the order of) the tests !! @Test(priority = 1)
    @Test(priority = 1)
    public void test1() {
        System.out.println("Test1 is running...");
        // Assert Equals method will compare two of the same values. If returns true, pass.False, fails.
        String actual = "apple";
        String expected = "apple";

        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("Test2 is running...");
        String actual = "white";
        String expected = "white";

        Assert.assertTrue(actual.equals(expected));

    }

}
