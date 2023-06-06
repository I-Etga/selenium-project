package src.cydeo.tests.day02_locators_getText_getAttribute.tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_ZeroBankHeader {
    public static void main(String[] args) throws InterruptedException {
        //HWP #2: Zero Bank header verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");


        //3. Verify header text
        //Expected: “Log in to ZeroBank”

        String expectedTitle = "Log in to ZeroBank";
        String actualTitle = driver.getTitle(); // Zero - Log in

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!");
        }

        Thread.sleep(3000);
        driver.close();

    }
}
