package day7ErolHc.practicefluentwait;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Downloadfile extends TestBase {
    //https://www.selenium.dev/downloads/ adresine gidelim
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım
    //Açılan pencerede chromedriver'i indirelim
    //Driver'in indiğini doğrulayalım




    @Test
    public void test01() {
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        Actions actions = new Actions(driver);
        WebElement browser = driver.findElement(By.xpath("(//*[@type='button'])[83]"));
        actions.moveToElement(browser).perform();

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        browser.click();
       driver.findElement(By.xpath("(//*[text()='documentation'])[5]")).click();


        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("(//*[@class='XqQF9c'])[2]")).click();

        //Açılan pencerede chromedriver'i indirelim
        List<String> pencereler=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));

        driver.findElement(By.linkText("chromedriver_win32.zip")).click();
        waitFor(3);
        String s=System.getProperty("user.home");
        s=s+"/Downloads/chromedriver_win32.zip";

        //Driver'in indiğini doğrulayalım



        //String farkli=System.getProperty("user.home")+"\\Downloads\\chromedriver_win32.zip\"";
        assert Files.exists(Paths.get(s));


    }
}
