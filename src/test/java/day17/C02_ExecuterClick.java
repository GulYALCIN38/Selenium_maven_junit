package day17;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_ExecuterClick extends TestBase {
    //clickByJSTest
    //Techpro education ana sayfasina git
    //LMS LOGIN elementine tikla
    //Cikan sayfayinin URL inin “https://lms.techproeducation.com/” oldugunu test et

    @Test
    public void test01() {
        driver.get("https://www.techproeducation.com");
        waitFor(3);

        //LMS LOGIN elementine tikla  LMS LOGIN
        WebElement w= driver.findElement(By.linkText("LMS LOGIN"));
        clickAvecJS(w);

        //Cikan sayfayinin URL inin “https://lms.techproeducation.com/” oldugunu test et
        Assert.assertEquals("https://lms.techproeducation.com/",driver.getCurrentUrl());



    }

}
