package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class AmazonLocate extends TestBase {

    //Test01 :  1- amazon gidin
    //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
    //dropdown menude 40 eleman olduğunu doğrulayın
    //Test02
    //dropdown menuden elektronik bölümü seçin
    //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
    //sonuc sayisi bildiren yazinin iphone icerdigini test edin
    //ikinci ürüne relative locater kullanarak tıklayin
    //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
    //Test03
    //yeni bir sekme açarak amazon anasayfaya gidin
    //dropdown’dan bebek bölümüne secin
    //bebek puset aratıp bulundan sonuç sayısını yazdırın
    //sonuç yazsının puset içerdiğini test edin
    //5-üçüncü ürüne relative locater kullanarak tıklayin
    //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
    // Test 4
    //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    @Test
    public void test1() {
        //1- amazon gidin
        driver.get("https://amazon.com/");

        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        List<WebElement>w=driver.findElements(By.xpath("//*[@id='searchDropdownBox']//option"));
        int NombreElement=w.size();
        System.out.println("NombreElement = " + NombreElement);

        //dropdown menude 28 eleman olduğunu doğrulayın
        Assert.assertEquals(28,NombreElement);
    }

    @Test
    public void test2() {
        //1- amazon gidin
        driver.get("https://amazon.com/");

        //dropdown menuden elektronik bölümü seçin
        WebElement w=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(w);

        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        select.selectByVisibleText("Electronics");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        waitFor(2);

        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String textDeResulta=driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']")).getText();
        System.out.println("textDeResulta = " + textDeResulta);
        Assert.assertTrue(textDeResulta.contains("iphone"));

        //ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//*[@class='a-link-normal s-no-outline'])[2]")).click();

        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        String title=driver.findElement(By.xpath("//*[@id='titleSection']")).getText();

          String s      =driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")).getText();
        System.out.println("s = " + s);
        System.out.println("title = " + title);
        waitFor(2);
        driver.findElement(By.xpath("//*[@id='submit.add-to-cart']")).click();

        //yeni bir sekme açarak amazon anasayfaya gidin

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com/");
       waitFor(1);


        //dropdown’dan bebek bölümüne secin
        WebElement w1=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select1=new Select(w1);

        select1.selectByVisibleText("Baby");



        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bebek puset", Keys.ENTER);
        String[] resulta=driver.findElement(By.xpath("//*[.='1-16 of 27 results for']")).getText().split(" ");
        System.out.println(resulta[2]+" adet sonuc bulundu");

        //sonuç yazsının puset içerdiğini test edin
        String result=driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']")).getText();
        Assert.assertTrue(result.contains("puset"));
        waitFor(2);

        //5-üçüncü ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//*[@class='a-link-normal s-no-outline'])[3]")).click();
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String title2=driver.findElement(By.xpath("//*[@id='titleSection']")).getText();

        String fitat     =driver.findElement(By.xpath("//*[@class='a-section a-spacing-none aok-align-center']")).getText();
        System.out.println("puset fiyati= = " + fitat);
        System.out.println("title = " + title2);
        waitFor(2);
        driver.findElement(By.xpath("//*[@id='submit.add-to-cart']")).click();

        // Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

        driver.findElement(By.id("nav-cart-count-container")).click();

        List<WebElement> sonuc=driver.findElements(By.xpath("//*[@class='a-list-item']"));
        sonuc.add(driver.findElement(By.xpath("//*[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")));

        System.out.println(sonuc.get(4).getText());
        System.out.println(sonuc.get(9).getText());
        System.out.println(sonuc.get(sonuc.size() - 1).getText());



    }
}
