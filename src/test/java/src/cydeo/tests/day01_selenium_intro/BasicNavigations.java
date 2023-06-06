package src.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {


    public static void main(String[] args) throws InterruptedException {

        // Until we create our utilities class, we'll write two block of code in every class.

        //Setup browser driver
        WebDriverManager.chromedriver().setup();

        //Create instance of crome browser
        WebDriver driver = new ChromeDriver();

        // Go to tesla.com
        driver.get("https://www.tesla.com");
        // https:/" -> it's mandatory. Without protocol an exceptions will be thrown

        //Use navigate back() to go back
        driver.navigate().back();

        // Stop executing for 3 seconds
        Thread.sleep(3000);

        //User navigate forward() to go forward
        driver.navigate().forward();

        // get title of the page
        System.out.println("driver.getTitle() = " + driver.getTitle());


        // Stop executing for 3 seconds
        Thread.sleep(3000);

        //User refreshes the page using navigate.refresh
        driver.navigate().refresh();

        // Stop executing for 3 seconds
        Thread.sleep(3000);


        //navigate to google.com using navigate().to();
        driver.navigate().to("https://www.google.com");


        // get title of the page
        System.out.println("currentTitle = " + driver.getTitle());

        //get current URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


        driver.manage().window().maximize();

        driver.manage().window().fullscreen(); // work only on macOS properly.

        // closes only the currently focused window/tab
        driver.close();

        //closes all the opened browsers.
        driver.quit();
    }
}
