package day08alerts_iframes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_AllertExept extends TestBase {
    /*
    Bir class olusturun: Alerts
      https://testcenter.techproeducation.com/index.php?page=javascript-alerts  adresine gidin.
        Bir metod olusturun: acceptAlert
        1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        Bir metod olusturun: dismissAlert
        2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “You clicked: Cancel” oldugunu test edin.
        Bir metod olusturun: sendKeysAlert
        3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */
    @Test
    public void acceptAllertTest() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        // 1. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        Thread.sleep(5000);
        // uyarıdaki OK butonuna tıklayın
        driver.switchTo().alert().accept();//OK secenegine tiklar// allertler web element degil locate alamyiz
        Thread.sleep(5000);
        // ve result mesajının
        //“You successfully clicked an alert” oldugunu test edin.
        String actueldResult=driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You successfully clicked an alert",actueldResult);

    }
    /*
    allertler nasil otomate edilir
    allert ler jawascript ile olusur inspect edilemez switchTo().alert() kullanirirz
     */
}
