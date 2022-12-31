package day07alerts_iframes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_PromtAllert extends TestBase {
    ////3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve
    // result mesajında isminizin görüntülendiğini doğrulayın.

    @Test
    public void promtAllert() throws InterruptedException {
            driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        ////3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().sendKeys("gul");
        Thread.sleep(5000);
        //OK butonuna tıklayın
        driver.switchTo().alert().accept();//ok tiklar
        Thread.sleep(5000);
        // result mesajında isminizin görüntülendiğini doğrulayın.
        String actuelResult=driver.findElement(By.id("result")).getText();
        Assert.assertTrue(actuelResult.contains("gul"));

    }
}
