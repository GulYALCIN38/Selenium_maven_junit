package day07alerts_iframes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_Iframe extends TestBase {
    /*
    1. bir sayfadaki iframe sayisi nasil bulunur? asgidaki ifadeler iframeleri liste atatr
    -- driver.findElements(By.tagname("iframe"));
      veya  driver.findElements(By.xpath("//iframe"));


    2. tekrar ana sayfaya nasil gidersin
    -- iki yol var
    driver.switchTo().defaultContent();
       driver.switchTo().parentFrame(); bu iki method arasindaki fark
       her ikiside frame in disine cikarir.
       default direkt ana sayfaya gonderir
        parentFrame bu bir ust e cikar ustte bir frame varsa ona gider



    3. bir test case de fail olma sebepleri ne olabilir
      i==> yanlis locator cozum: tekrar locate al .Degisken elemet var ise ona gore dinamik bir xPath yazilmalidir

      ii==> sure(wait)/ Syncronisation /B ekleme problemi
      cozum ; implicit wait te yeterli sure  yoksa  sureyi artirabiliriz 30 sn olabilir
            Explicit wait kullanilabilir

       iii ==>iframe cozum ; swich to iframe

       iv ==> Alert olabilir cozum    ;swich to alert

       v==> new window   cozum ; switch to window


     */

    //Iframe nedir?
    //https://testcenter.techproeducation.com/index.php?page=iframe
    //Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim
    //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
    //Son olarak footer daki ‘Powered By’ yazisini varligini test edilip

    @Test
    public void iframetest() throws InterruptedException {
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        Thread.sleep(2000);

        //Ana sayfadaki An iframe with a thin black border: metnin "black border" yazisinin oldugunu test edelim
        String x = driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();//text yerine bunu kullanabiliriz
        String expected = "An iframe with a thin black border:";
        Assert.assertTrue(x.contains("black border"));


        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        // Applications lists iframe icinde iframe girisi olamli

        driver.switchTo().frame(0);//ilk iframe e gecis yaptik index ilen
        String w = driver.findElement(By.xpath("//h1[.='Applications lists']")).getText();
        Assert.assertEquals("Applications lists", w);
        Thread.sleep(2000);

        //iframe den cikmak icin -->kuyudan cik

        driver.switchTo().defaultContent();
        //driver.switchTo().parentFrame(); bu bir ust e cikar ustte bir frame varsa ona gider
       String s= driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        System.out.println(s);
        //Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
        Assert.assertTrue(s.contains("Povered By"));

    }
}
