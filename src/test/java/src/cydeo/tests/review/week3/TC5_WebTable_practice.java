package src.cydeo.tests.review.week3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.cydeo.tests.base.TestBase;
import src.cydeo.utilities.Driver;

import java.util.List;

public class TC5_WebTable_practice extends TestBase{


    @Test
    public void webTables_test1() {

        // 2. Go to https://practice.cydeo.com/tables
        //String URL = ConfigurationReader.getProperty("practiceWebTablesURL");
        Driver.getDriver().get("https://practice.cydeo.com/tables");

        // 3. Print table data as a single String, not so common, but useful sometimes

        // Find all tables on the page
        List<WebElement> tables = Driver.getDriver().findElements(By.tagName("table"));

        // Initialize an empty string to store the table data
        String tableData = "";

        // Iterate over each table
        for (WebElement table : tables) {
            // Find all rows in the table body
            List<WebElement> rows = table.findElements(By.tagName("tr"));

            // Iterate over each row
            for (WebElement row : rows) {
                // Find all cells in the row
                List<WebElement> cells = row.findElements(By.tagName("td"));

                // Iterate over each cell and extract the text
                for (WebElement cell : cells) {
                    if (cell.getText().contains("edit")) { // ignores edit delete !!
                        continue;
                    }
                    tableData += cell.getText().trim() + " ";
                }

                tableData += "\n";  // Add a new line after each row
            }
        }
        System.out.println(tableData);

        // 4. verify tconway@earthlink.net is anywhere in the table
        String expectedText = " tconway@earthlink.net";
        Assert.assertTrue(tableData.contains(expectedText));

        // 5. print all column names in single line
        // Find all th on the page
        List<WebElement> textHeaders = Driver.getDriver().findElements(By.tagName("th"));
        String tHeaders = "";
        String tHeadersLine ="";
        for (WebElement each : textHeaders) {
            String text = each.getText();
            if(tHeaders.contains(text)){
                continue;
            }
            tHeaders += text.trim() + "-";
            tHeadersLine += text.trim() + "\n";
        }
        if(tHeaders.endsWith("-")) { // removes the last '-'
            tHeaders = tHeaders.substring(0,tHeaders.length() - 1);
        }

        System.out.println(tHeaders);

        // 6. print each column name in separate lines using a loop and findElements method
        System.out.println(tHeadersLine);
    }

}
