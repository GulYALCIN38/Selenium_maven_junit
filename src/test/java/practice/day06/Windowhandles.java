package practice.day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Windowhandles extends TestBase {
    // 'https://www.n11.com' adresine gidin
    // arama motoruna 'oppo' yazıp aratın
    // ilk ürüne tıklayın
    // Basligin 'Oppo' icerdigini test edin.
    // ilk sayfaya donun ve Title'ını yazdırın

    @Test
    public void test1() {
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");

        // arama motoruna 'oppo' yazıp aratın
        WebElement w=driver.findElement(By.id("searchData"));
        w.clear();
        w.sendKeys("oppo", Keys.ENTER);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//*[@class='lazy cardImage'])[1]")).click();
        // Basligin 'Oppo' icerdigini test edin.

                List<String> titles=new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(titles.get(1));
        WebElement title=driver.findElement(By.xpath("//h1"));

        Assert.assertTrue(title.getText().contains("Oppo"));
        // ilk sayfaya donun ve Title'ını yazdırın
    }
}
