package practice.day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Example extends TestBase {
    // https://amazon.com adresine gidiniz
    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
    // Change country/region butonuna basiniz
    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
    // Go to website butonuna tiklayiniz
    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz


    @Test
    public void test01() {
        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");


        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions=new Actions(driver);
        WebElement w= driver.findElement(By.xpath("//div[text()='EN']"));
        actions.moveToElement(w).perform();

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement dropdown=driver.findElement(By.id("icp-dropdown"));
        Select select= new Select(dropdown);
        select.selectByVisibleText("Turkey (Türkiye)");

        driver.findElement(By.xpath("//*[text()='Changing country/region website']")).click();

        // Go to website butonuna tiklayiniz
        driver.findElement(By.id("icp-save-button")).click();

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        switchToWindow(1);
        Assert.assertTrue(driver.getTitle().contains("Elektronik"));
    }
}
