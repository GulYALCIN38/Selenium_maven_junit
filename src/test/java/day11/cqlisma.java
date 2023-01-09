package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class cqlisma extends TestBase {


    //Go to https://www.amazon.com.tr/
    //Search iPhone13 512
    //Check that the results are listed
    //Click iPhone13 at the top of the list
    //Log the following values for each size .Size information .Price .Color .Stock status
    //Isim - Renk - Stok - Boyut - Fiyat
    @Test
    public void test01() {
        // https://www.amazon.com.tr/ adresine gidin
        driver.get("https://www.amazon.com.tr/");
        //iPhone13 512'de ara
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone13 512", Keys.ENTER);
        driver.findElement(By.id("sp-cc-accept")).click();
        //Sonuçların listelenip listelenmediğini kontrol edin
        //List<WebElement> results = driver.findElements(By.xpath("//div[@class='sg-col-4-of-12 s-result-item s-asin sg-col-4-of-16 sg-col s-widget-spacing-small sg-col-4-of-20']"));
        //Assert.assertTrue(!results.isEmpty());
        //Listenin en üstündeki iPhone13'e tıklayın
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        waitFor(2);
        //results.get(0).click();
        //Her beden için aşağıdaki değerleri loglayın .Beden bilgisi .Fiyat .Renk .Stok durumu
        List<WebElement> boyutlar = driver.findElements(By.xpath("(//ul[@class='a-unordered-list a-nostyle a-button-list a-declarative a-button-toggle-group a-horizontal dimension-values-list'])[2]//li[@data-asin]"));
        List<WebElement> renkler = driver.findElements(By.xpath("(//ul[@class='a-unordered-list a-nostyle a-button-list a-declarative a-button-toggle-group a-horizontal dimension-values-list'])[1]//li[@data-asin]"));
        renkler.stream().forEach(t-> System.out.println(t.getText()));
        for (int i = 0; i < renkler.size(); i++) {
            renkler.get(i).click();
            waitFor(2);
            for (int j = 0; j < boyutlar.size(); j++) {
                waitFor(2);
                if (!boyutlar.get(j).getText().contains("Mevcut")) {
                    boyutlar.get(j).click();
                    waitFor(2);
                    driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
                    waitFor(2);
                    driver.findElement(By.xpath("//a[@id='attach-close_sideSheet-link']")).click();//alisverise devam etmek icin acilan sayfayi kapatir
                    System.out.println();
                }
            }
        }
        driver.findElement(By.xpath("//span[@id='nav-cart-count']")).click();
        List<WebElement>w=driver.findElements(By.xpath("//span[@class='a-list-item']"));//konsolda gormek istedigimiz tum bilgileri bir list icine attik
        waitFor(1);
        w.add(driver.findElement(By.xpath("//span[text()='Fiyat']")));
        w.add(driver.findElement(By.xpath("//*[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")));
        waitFor(1);
        w.stream().skip(4).filter(t->!t.getText().startsWith("B")).forEach(t-> System.out.println(t.getText()));
    }

}
