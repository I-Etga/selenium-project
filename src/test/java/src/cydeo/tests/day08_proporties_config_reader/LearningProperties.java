package src.cydeo.tests.day08_proporties_config_reader;

import org.testng.annotations.Test;

public class LearningProperties {

    @Test
    public void java_properties_reading_test(){
        //key = value
        //we pass the key, it will return the value

        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
    }
}
