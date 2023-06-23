package src.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.cydeo.utilities.Driver;

public class W3Page {
    //#1 Create constructor and initialize the 'driver' instance and 'object' of the current class.
    public W3Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //#2: Instead of using findElement method we use @FindBy annotation
    @FindBy(id= "demo")
    public WebElement paragraph;

    @FindBy(id = "accept-choices")
    public WebElement acceptsAllCookies;

}
