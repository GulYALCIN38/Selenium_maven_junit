package practice.day01.day03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_iframe extends TestBase {
    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //2) sayfadaki iframe sayısını bulunuz.
    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
    //tıklayınız


    @Test
    public void name() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/guru99home/");

        WebElement iframe= driver.findElement(By.xpath("//*[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@class='action-wrapper'])[3]")).click();
driver.switchTo().defaultContent();
        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement>l=driver.findElements(By.xpath("//iframe"));
        System.out.println(l.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.

        WebElement w=driver.findElement(By.xpath("//*[@wmode='transparent']"));
        driver.switchTo().frame(w);
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
        Thread.sleep(3000);

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.navigate().refresh();
        WebElement w1=driver.findElement(By.xpath("//*[@id='a077aa5e']"));
        //driver.switchTo().frame("a077aa5e");//iframe adi
        driver.switchTo().frame(w1);

        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();






    }
}
