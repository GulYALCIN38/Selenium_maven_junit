package practice.day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.Arrays;

public class C02_window extends TestBase {
    //- https://html.com/tags/iframe/ adresine gidiniz
    //    - youtube videosunu çalıştırınız
    //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
    //    - yeni sekmede amazon adresine gidiniz
    //    - iphone aratınız
    //    - arama sonucu olarak sadece sonuc sayısını yazdırınız
    //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım
    //    - ilk sekmeyi kapatalım
    //    - Sonra diğer sekmeyide kapatalım
    @Test
    public void test01() throws InterruptedException {
        //- https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        String handle1 = driver.getWindowHandle();


        //    - youtube videosunu çalıştırınız
        WebElement w = driver.findElement(By.xpath("//div[@class='render']//iframe[@frameborder='0']"));
        driver.switchTo().frame(w);
        driver.findElement(By.xpath("//button[@aria-label='Play']")).click();


        //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
        Thread.sleep(3000);
        driver.navigate().refresh();

        //    - yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com/");
        Thread.sleep(1000);

        //    - iphone aratınız
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);

        //    - arama sonucu olarak sadece sonuc sayısını yazdırınız
        String[] s = driver.findElement(By.xpath("//*[text()='1-16 of over 1,000 results for']")).getText().split(" ");
        System.out.println(Arrays.toString(s));
        System.out.println(s[3]);
        Thread.sleep(1000);

        //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım
        driver.switchTo().window(handle1);
        System.out.println(driver.getCurrentUrl());

        //    - ilk sekmeyi kapatalım
        driver.close();
        //    - Sonra diğer sekmeyide kapatalım
        // test base bu isi halledicek bu asamada aktif hale getirdik


    }
}
