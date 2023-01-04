package canhcpractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_Reklamli extends TestBase {
    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' URL'sine gidin
    //3. 'Ürünler' düğmesine tıklayın
    //4. Sol taraftaki çubukta Markaların göründüğünü doğrulayın
    //5. Herhangi bir marka adına tıklayın
    //6. Kullanıcının marka sayfasına yönlendirildiğini ve marka ürünlerinin görüntülendiğini doğrulayın.
    //7. Sol taraftaki çubukta herhangi bir başka marka bağlantısına tıklayın
    //8. Kullanıcının o marka sayfasına gittiğini ve ürünleri görebildiğini doğrulayın


    @Test
    public void name() throws InterruptedException {
        //https://demoqa.com/ url'ine gidin.
        driver.get("http://automationexercise.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
        Thread.sleep(1000);
        List<WebElement>l=driver.findElements(By.xpath("//div[@class='brands-name']//ul//li"));//marka isimlerinin hepsini aldik
        l.stream().forEach(t-> Assert.assertTrue(t.isDisplayed()));
        l.stream().forEach(t-> System.out.println(t.getText()));
        Thread.sleep(2000);
        //5. Herhangi bir marka adına tıklayın

        driver.navigate().back();
        driver.navigate().forward();
        driver.findElement(By.xpath("//*[@href='/brand_products/Madame']")).click();


        //6. Kullanıcının marka sayfasına yönlendirildiğini ve marka ürünlerinin görüntülendiğini doğrulayın.
        WebElement w=driver.findElement(By.xpath("//*[text()='Brand - Madame Products']"));
        Assert.assertTrue(w.isDisplayed());
        Thread.sleep(2000);

        //7. Sol taraftaki çubukta herhangi bir başka marka bağlantısına tıklayın
        driver.findElement(By.xpath("//*[@href='/brand_products/Babyhug']")).click();
        Thread.sleep(1000);

        //8. Kullanıcının o marka sayfasına gittiğini ve ürünleri görebildiğini doğrulayın
        WebElement w2=driver.findElement(By.xpath("//*[text()='Brand - Babyhug Products']"));
        Thread.sleep(2000);

        Assert.assertTrue(w2.isDisplayed());







    }
}
