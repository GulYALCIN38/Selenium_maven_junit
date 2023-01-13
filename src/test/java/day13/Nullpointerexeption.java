package day13;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class Nullpointerexeption  {
    // driver icin veya baska bir element icin new keyword kullanmadigimiz zaman null pointer ex olur
WebDriver driver;
Faker faker;

    @Test
    public void test1() {
        driver.get("https://www.techproeducation.com");
        //	at day13.Nullpointerexeption.test1(Nullpointerexeption.java:13)


    }

    @Test
    public void nullPointerExceptionTest2(){
       //faker=new Faker();
        System.out.println(faker.name().fullName());//java.lang.NullPointerException
    }
}
