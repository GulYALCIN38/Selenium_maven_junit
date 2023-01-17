package day7ErolHc.practicebasic_aut;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Explicitewait extends TestBase {
        /*
                                    - Explicit Wait -
        Selenium’da Explicit Wait, Web Sürücüsüne belirli koşulları (Expected Condition) veya
    “ElementNotVisibleException” exception’ı atmadan önce aşılan maksimum süreyi beklemesini söylemek için kullanılır.
    Akıllı bir bekleme türüdür ancak yalnızca belirli öğeler(elementler) için uygulanabilir.
    Dinamik olarak yüklenen web elementleri beklerken implicit wait’ten daha iyi seçenekler sunar.
        Explicit Wait kullandığımızda, “ExpectedConditions” tanımlamalıyız veya Fluent Wait kullanarak durumu ne
    sıklıkla kontrol etmek istediğimizi yapılandırmalıyız.
Syntax:
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(element locator));
     */
    //https://automationfc.github.io/dynamic-loading/ sayfasına gidelim
    //Start button'nuna basalım
    //Hello World! yazısının çıktığını doğrulayalım

    @Test
    public void test01() {
        //https://automationfc.github.io/dynamic-loading/ sayfasına gidelim
        driver.get("https://automationfc.github.io/dynamic-loading/");

        //Start button'nuna basalım
        driver.findElement(By.xpath("//*[text()='Start']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement w=driver.findElement(By.xpath("//h4"));
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='loading']")));//until e kadar demek
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4")));

        //Hello World! yazısının çıktığını doğrulayalım








        Assert.assertEquals("Hello World!",w.getText());



    }
}
