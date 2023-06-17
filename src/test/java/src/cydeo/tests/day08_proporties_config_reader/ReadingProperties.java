package src.cydeo.tests.day08_proporties_config_reader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_test() throws IOException {
        //STEPS TO READ FROM PROPERTIES TYPE OF FILE

        //create object of Properties
        Properties properties = new Properties();

        //We need to open the file in the Java memory using FileInputStream
        FileInputStream file = new FileInputStream("configuration.properties");

        //Load the properties file in the Properties object
        properties.load(file);

        //Use the "properties" object to read value from the file
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));

        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));
        System.out.println("properties.getProperty(\"password\") = " + properties.getProperty("password"));

        
    }
}
