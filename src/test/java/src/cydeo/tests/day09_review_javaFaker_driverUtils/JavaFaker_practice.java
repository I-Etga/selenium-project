package src.cydeo.tests.day09_review_javaFaker_driverUtils;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFaker_practice {

    @Test
    public void test1(){

        // Create Java Faker Object
        Faker faker = new Faker();

        //Print out a RANDOM first name using Faker object
        System.out.println("faker.name().firstName() = " + faker.name().firstName());

        //print out a RANDOM last name using Faker object
        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        //print out a RANDOM full name using Faker object
        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        //print out a city
        System.out.println("faker.address().city() = " + faker.address().city());

        //print out a zipcode
        System.out.println("faker.address().zipCode() = " + faker.address().zipCode());

        //numerify() method is used to generate digits with specific formatting
        System.out.println("faker.numerify(\"###-###-###\") = " + faker.numerify("###-###-###"));

        System.out.println("faker.numerify(\"####-####-####\") = " + faker.numerify("####-####-####"));

        //letterify() method is used to generate RANDOM letters with specific formatting
        System.out.println("faker.letterify(\"????-????-????\") = " + faker.letterify("????-????-????"));

        //chuckNorris method is used to create chuckNorris facts
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());
        System.out.println("faker.Rachel().fact() = " + faker.chuckNorris().fact().replace("Chuck Norris","Rachel"));

        System.out.println("faker.howIMetYourMother().character() = " + faker.howIMetYourMother().character());
    }
}
