package day17;

import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_JSExecuter_Scroll extends TestBase {
        /*
scrollIntoViewTest metotu olustur
Techpro education ana sayfasina git
We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al
Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
     */

    @Test
    public void test01() throws IOException {
        driver.get("https://www.techproeducation.com");
        waitFor(3);
        //We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al-Done
        //1.elementi bul
        WebElement w = driver.findElement(By.xpath("//span[.='we offer']"));

        //2.js executer methodu olustur
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true)", w);//scrollIntoView(true) bu methot ile istenen eleman gekene kadar sayfa kaydirilir
        waitFor(3);
        takeScreenShotOfPage();

        //Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al Enroll Free Course
        WebElement w2 = driver.findElement(By.xpath("//span[.='Enroll Free Course']"));
        scrollIntoViewJS(w2);
        takeScreenShotOfPage();


        //Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al WHY US?
        WebElement w3 = driver.findElement(By.xpath("//h3[.='WHY US?']"));
        scrollIntoViewJS(w3);
        takeScreenShotOfPage();

        //Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al

        scrollIntoViewJS(w2);
        takeScreenShotOfPage();
        waitFor(2);
        //en uste git sayfada
        scrollTopJS();
        waitFor(2);
        //en alta git
        scrollEndJS();
    }
}
