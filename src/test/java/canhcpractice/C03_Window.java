package canhcpractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C03_Window extends TestBase {
    /*
       url'ye git: http://demo.guru99.com/popup.php
       ilk pencereyi al
       "Click Here" butonuna tıklayın
       setteki tüm pencereyi al
       diğer pencereye geç
       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
       Gönder düğmesine tıklayarak
       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
       Tekrar ilk pencereye geç
       İlk pencerede olduğunu doğrula
      */


    @Test
    public void test01() throws InterruptedException {
        //url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");

        //       ilk pencereyi al
        String handle1 = driver.getWindowHandle();
        Thread.sleep(2000);
        String url1=driver.getCurrentUrl();

       WebElement iframe=driver.findElement(By.id("gdpr-consent-notice"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//div[@class='action-wrapper'])[3]")).click();
        driver.switchTo().parentFrame();
        Thread.sleep(2000);

        //       "Click Here" butonuna tıklayın
        WebElement w = driver.findElement(By.xpath("//*[@target='_blank']"));
        w.click();
        Thread.sleep(2000);


        //       setteki tüm pencereyi al
        Set<String> allWindows = driver.getWindowHandles();

        //       diğer pencereye geç
        System.out.println(allWindows.size());
        for (String w1 : allWindows) {
            if (!w1.equals(handle1)) {
                driver.switchTo().window(w1);
            }
        }
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        //       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        //       Gönder düğmesine tıklayarak

        driver.findElement(By.xpath("//*[@name='emailid']")).sendKeys("somepne@gmail.com", Keys.TAB,Keys.ENTER);
        Thread.sleep(1000);


        //       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
        String actuel=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("This access is valid only for 20 days.",actuel);
        //       Tekrar ilk pencereye geç

        driver.switchTo().window(handle1);
        //  İlk pencerede olduğunu doğrula

        Assert.assertEquals(url1,driver.getCurrentUrl());



    }
}
