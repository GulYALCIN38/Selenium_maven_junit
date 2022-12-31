package day07alerts_iframes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_DismisAllert extends TestBase {

    @Test
    public void dissmisAllert() throws InterruptedException {
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        // “You clicked: Cancel” oldugunu test edin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().dismiss();// bu cancel secenegine tiklar
        Thread.sleep(5000);
        String actueldResult=driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You clicked: Cancel",actueldResult);

    }
}
