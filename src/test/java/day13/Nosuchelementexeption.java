package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class Nosuchelementexeption extends TestBase {
    @Test
    public void test1() {
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//input[@type='searchh']")).sendKeys("QA"+ Keys.ENTER);

        //	at day13.Nosuchelementexeption.test1(Nosuchelementexeption.java:12)
        //yanlis locate


    }
}
