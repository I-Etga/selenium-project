package src.cydeo.tests.review.week4;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import src.cydeo.utilities.ConfigurationReader;
import src.cydeo.utilities.Driver;

public class DragAndDropTest  {
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void guru99DragAndDropTest() {
        Driver.getDriver().get(ConfigurationReader.getProperty("draganddrop.url"));

        WebElement bank = Driver.getDriver().findElement(By.linkText("BANK"));
        WebElement accountType = Driver.getDriver().findElement(By.id("bank"));

        actions.dragAndDrop(bank, accountType).build().perform();

        WebElement fiveK = Driver.getDriver().findElement(By.linkText("5000"));
        WebElement bankAmount = Driver.getDriver().findElement(By.id("amt7"));

       //actions.dragAndDropBy(fiveK, 121, 50).perform();
       actions.dragAndDrop(fiveK , bankAmount).perform();

        Driver.closeDriver();

    }


}
