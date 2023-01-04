package practice.day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C03_window extends TestBase {
    // https://the-internet.herokuapp.com/iframe adresine gidiniz
    // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
    // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
    // Elemental Selenium linkine tıklayın
    // Açılan sayfada sayfa başlığını yazdırınız
    // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
    // Source labs linkine tıklayın
    // Açılan sayfada sayfa başlığını yazdırınız
    // ilk sekmeye geri dönelim ve url'ini yazdıralım
    // ilk sekmeyi kapatalım


    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe adresine gidiniz

        driver.get("https://the-internet.herokuapp.com/iframe");
        String s = driver.getWindowHandle();
        // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement w = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(w);
        WebElement w1 = driver.findElement(By.xpath("//p"));
        w1.clear();
        w1.sendKeys("Techproeducation");
        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
        //
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Elemental Selenium']")).isDisplayed());
        // Elemental Selenium linkine tıklayın
        driver.findElement(By.xpath("//*[.='Elemental Selenium']")).click();
        Thread.sleep(2000);
        // Açılan sayfada sayfa başlığını yazdırınız
        List<String> pencerelr = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencerelr.get(1));
        System.out.println(driver.getTitle());
        String ikinciSayfa = driver.getWindowHandle();
        /*
        Set<String> butunSekmeler = driver.getWindowHandles();

        // Açılan sayfada sayfa başlığını yazdırınız

       for (String w : butunSekmeler) {
       if (!w.equals(ilkSayfa)) {
        driver.switchTo().window(w);
          }
         }
       System.out.println(driver.getTitle());
        String ikinciSayfa = driver.getWindowHandle();
         */


        // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
        WebElement w3=driver.findElement(By.xpath("//*[text()='Sauce Labs']"));
        Assert.assertTrue(w3.isDisplayed());
        // Source labs linkine tıklayın
        Thread.sleep(2000);
        w3.click();


        // Açılan sayfada sayfa başlığını yazdırınız
        List<String> pencerelr1 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencerelr1.get(2));
        System.out.println(driver.getTitle());
        String ucuncuSayfa = driver.getWindowHandle();

        // ilk sekmeye geri dönelim ve url'ini yazdıralım
        driver.switchTo().window(s);
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);

        // ilk sekmeyi kapatalım
        driver.close();


    }
}
