package src.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    // TASK: NEW METHOD CREATION
    // Method name : getDriver
    // Static method
    // Accepts String arg: browserType

    // Why static? I can call a static method without creating any object !!
    public static WebDriver getDriver(String browserType) {
        //   - This arg will determine what type of browser is opened

        //   - if "chrome" passed --> it will open Chrome browser
        if (browserType.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            // RETURN TYPE: "WebDriver"
            return new ChromeDriver();

        } else if (browserType.equalsIgnoreCase("firefox")) {
            //   - if "firefox" passed --> it will open firefox browser

            WebDriverManager.firefoxdriver().setup();
            // RETURN TYPE: "WebDriver"
            return new FirefoxDriver();

        } else {
            System.out.println("Given string doesn't represent any browser.");
            System.out.println("Either that browser does not exist or not currently supported.");
            System.out.println("driver = null");
            // RETURN TYPE: "WebDriver"
            return null;
        }
    }

}
