package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class StaleElementExeption extends TestBase {
    /*
    Seleniumda aldigin 5 exception
    Null pointer, no such element, time out, slale element reference, web driver
    Genel olarak exception aldiginda bozum yolun nedir?
    Hata mesajini oku
    Genel olarak zamanlama, yanlis locator, iframe hataları olabiliyor
    Hata mesajina gore exception I cozdukden sonra tekrar kodumu calistirim
    Selniumda kullandigin waitler nelerdir>
    Implicit yada explicit yada fluent
    Hangi waiti tercih edersin?
    Test Base (Driver sinifinda) implicit wait kullanıyorum. Cogu problemi bozuyor Cozemedigi durumlarda explicit wait kullanıyorum.
    Neden Explicit wait?
    Explicit wait element e ouzel yazilabilir. Yerel cozum gerektiğinde explicit wait I kullanmak zorundayiz.
    Senkronize(bekleme) problemlerini nasıl çözersin
    Selenium waitlerini kullanarak. Implicit wait driver im da var, ama yetmedigi durumlarda explicit wait kullanirim. Bu yüzden ReusableMethod sinifimda tekrar tekrar kullanabileceğimiz explicit wait method lari var. Kolaylıkla explicit wait ile bekleme problemlerini cozebuliyoruz.



     */
       /*
       Tester olarak ekran görüntüsü neden alınır ?
          Dökümantasyon için
             Geçen Test Case'lerin geçtiğini kayda geçirmek
             Kalan Test Case'lerin de kaldığını/ bug bulunduğunda kayda geçirmek için
     */

    //webdriver exeption  driver surumu eski ise veya driver kapatildiktan sonra  tekrar acilirsa  bu exeption alinabilir


    @Test
    public void test01() {
        driver.get("https://www.techproeducation.com");
        //        LMS LOGIN linkine tikla ve o sayfanin URL inin lms icerdigini test et
        WebElement w=driver.findElement(By.linkText("LMS LOGIN"));
        w.click();
        waitFor(3);

        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));


//        Tekrar ana sayfaya gel ve LMS LOGIN sayfasina tekrar
        driver.navigate().back();
        waitFor(3);
        w.click();
        //at day13.StaleElementExeption.test01(StaleElementExeption.java:26)




    }
    @Test
    public void test02() {
        driver.get("https://www.techproeducation.com");
        //        LMS LOGIN linkine tikla ve o sayfanin URL inin lms icerdigini test et
        WebElement w=driver.findElement(By.linkText("LMS LOGIN"));

        driver.navigate().refresh();
        w.click();
        waitFor(3);
        //at day13.StaleElementExeption.test01(StaleElementExeption.java:40)
        // bu exeptionun cozumu elemanti tekrar locate etmek
        //driver.findElement(By.linkText("LMS LOGIN")).click();



    }
}
