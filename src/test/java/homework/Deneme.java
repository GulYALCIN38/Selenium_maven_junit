package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class Deneme extends TestBase {
    //https://testcenter.techproeducation.com/index.php?page=multiple-windows
    //Title in ‘Windows’ oldugunu test edin
    //Click here a tiklayin
    //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        String handle1 = driver.getWindowHandle();
        System.out.println("handle1 = " + handle1);
        Thread.sleep(2000);

        //Title in ‘Windows’ oldugunu test edin
        driver.getTitle();
        Assert.assertEquals("Windows", driver.getTitle());
        Thread.sleep(2000);

        //Click here a tiklayin
        driver.findElement(By.xpath("//*[@href='index.php?page=new-windows']")).click();
        Thread.sleep(2000);

        Set<String> hepsi = driver.getWindowHandles();
        hepsi.stream().filter(t -> !t.equals(handle1)).forEach(t -> driver.switchTo().window(t));


        //switchToWindow("New Window");
        String handle2 = driver.getWindowHandle();
        String title2 = driver.getTitle();
        System.out.println("handle2 = " + handle2);
        Assert.assertEquals("New Window", title2);


    }
}
