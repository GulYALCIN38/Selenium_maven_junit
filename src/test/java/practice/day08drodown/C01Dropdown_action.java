package practice.day08drodown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C01Dropdown_action extends TestBase {
    // Exercise 1...

    // https://www.amazon.com/ sayfasina gidin
    // sag ust bolumde bulunan dil menusunun acilmasi icin mause'u bu menunun ustune getirelim
    // Change butonuna basiniz
    // DropDown'dan Visible Text kullanarak 'TRY - Turkish Lira' optionunu secin ve yazdırın
    // Tüm option'ları yazdırın
    // dropdown'daki tum optionlarin toplam sayısının 68'ye esit oldugunu test edin
    // Save Changes butonuna basınız
    // arama motoruna 'Kitap' yazip aratin
    // ilk cikan urunun parabiriminin 'TRY' oldugunu test edin

    @Test
    public void test1() {
        // Exercise 1...

        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");
        extentTest.info("url ye gidildi");

        // sag ust bolumde bulunan dil menusunun acilmasi icin mause'u bu menunun ustune getirelim
        WebElement w = driver.findElement(By.xpath("//*[@id='icp-nav-flyout']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(w).perform();
extentTest.info("dil menusune move to element yapildi");
        // Change butonuna basiniz
        driver.findElement(By.linkText("Change")).click();

        // DropDown'dan Visible Text kullanarak 'TRY - Turkish Lira' optionunu secin ve yazdırın
        WebElement w1 = driver.findElement(By.xpath("//*[@id='icp-currency-dropdown']"));
        Select select = new Select(w1);
        select.selectByVisibleText("TRY - Turkish Lira");
        System.out.println(select.getFirstSelectedOption().getText());

        // Tüm option'ları yazdırın
        List<WebElement> l = driver.findElements(By.xpath("//*[@id='icp-currency-dropdown']//option"));
        l.forEach(t -> System.out.println(t.getText()));
        //List<WebElement> l1 =select.getOptions();
        extentTest.info("tum opsiyonla yazdirildi");


        // dropdown'daki tum optionlarin toplam sayısının 68'ye esit oldugunu test edin
        Assert.assertEquals(68, l.size());
        waitFor(3);
        extentTest.pass("toplam sayi 68 oldugu dogrulandi");
        // Save Changes butonuna basınız
        WebElement w3 = driver.findElement(By.xpath("//*[@class='a-button-input']"));
        w3.click();
        waitFor(2);

        // arama motoruna 'Kitap' yazip aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Kitap", Keys.ENTER);
        // ilk cikan urunun parabiriminin 'TRY' oldugunu test edin
        Assert.assertEquals("TRY",driver.findElement(By.xpath("(//*[@class='a-price-symbol'])[1]")).getText());
    }
}
