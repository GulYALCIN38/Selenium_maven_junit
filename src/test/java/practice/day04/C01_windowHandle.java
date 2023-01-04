package practice.day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_windowHandle  extends TestBase {
    //Amazon anasayfa adresine gidin.
    //Sayfa’nin window handle degerini String bir degiskene atayin
    //Sayfa title’nin “Amazon” icerdigini test edin
    //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
    //Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
    //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    //Sayfa title’nin “Walmart” icerdigini test edin
    //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
    @Test
    public void test01() throws InterruptedException {
        //Amazon anasayfa adresine gidin.
        driver.get("https://amazon.com");
        //Sayfa’nin window handle degerini String bir degiskene atayin
       String handle1= driver.getWindowHandle();

        //Sayfa title’nin “Amazon” icerdigini test edin
        String title=driver.getTitle();
        Assert.assertTrue(title.contains("Amazon"));
        Thread.sleep(2000);

        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);//YENI BIR SEKME ACTIK
        driver.get("https://techproeducation.com");

        //Sayfa title’nin “TECHPROEDUCATION” icermedigini test edin
        String actitle= driver.getTitle();
        Assert.assertFalse(actitle.contains("TECHPROEDUCATION"));
        Thread.sleep(2000);
        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");

        //Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));

        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(handle1);


        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";
        Assert.assertEquals(expectedUrl,actualUrl);





    }
}
