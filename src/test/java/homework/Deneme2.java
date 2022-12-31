package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Deneme2 extends TestBase {
    //Bir class olusturun: IframeOdev
    //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
    //sayfadaki toplam iframe sayısını bulunuz.
    //Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
    //Paragrafdaki yaziyi silelim  w.clear elemani siler
    //Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
    //Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim


    @Test
    public void test01() throws InterruptedException {
        //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");



        //sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement>w=driver.findElements(By.tagName("iframe"));
        System.out.println(w.size());

        //Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("Editor"));

        //Paragrafdaki yaziyi silelim  ----->w.clear elemani siler
        driver.switchTo().frame(0);
        WebElement w1=driver.findElement(By.xpath("//*[@id='tinymce']//p"));
        w1.clear();
        Thread.sleep(2000);

        //Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        w1.sendKeys("iframein icindeyim");
        Thread.sleep(2000);

        //Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim

        driver.switchTo().defaultContent();
       String d= driver.findElement(By.linkText("Elemental Selenium")).getText();
       Assert.assertTrue(d.contains("Elemental Selenium"));


    }
}
