package day7ErolHc;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01Oractice {


            /*
-"amazon.com" adresine gidelim
-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
-title ve url'nin "spend" kelimesinin icerip icermedigini kontrol edelim
-Ardindan "trendyol.com" adresine gidelim
-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
-Bi onceki web sayfamiza geri donelim
-sayfayi yenileyelim
-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
 */

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //-"amazon.com" adresine gidelim
        driver.get("https://amazon.com");
        //-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        System.out.println("url = " + url);
        System.out.println("title = " + title);

        //-title ve url'nin "spend" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(title.contains("spend") && url.contains("spend"));

        Thread.sleep(2000);
        //-Ardindan "trendyol.com" adresine gidelim
        driver.get("https://trendyol.com");

        //-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String titleTrendyol = driver.getTitle();
        System.out.println("titleTrendyol = " + titleTrendyol);
        Assert.assertFalse(titleTrendyol.contains("Sitesi"));
        Thread.sleep(2000);
        //-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();
        Thread.sleep(2000);
        //-sayfayi yenileyelim
        driver.navigate().refresh();
        Thread.sleep(2000);
        //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.quit();
    }
}
