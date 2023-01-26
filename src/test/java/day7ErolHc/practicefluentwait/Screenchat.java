package day7ErolHc.practicefluentwait;

import com.aventstack.extentreports.utils.FileUtil;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenchat extends TestBase {
    //Amazon sayfasına gidelim
    //Tüm sayfanın resmini alalım
    //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
    //Tekrar amazon sayfasına dönüp iphone aratalım
    //Arama sonucunun resmini alalım


    @Test
    public void test01() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com/");
        String amazon=driver.getWindowHandle();

        //Tüm sayfanın resmini alalım
        String date=new SimpleDateFormat("hh_mm_ss_ddMMyyy").format(new Date());
        TakesScreenshot ts=(TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumsfresmi/tumSayfa"+date+".jpeg"));

        //target/tumsfresmi/tumSayfa09_40_04_18012023.jpeg

        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
waitFor(3);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");
        date=new SimpleDateFormat("hh_mm_ss_ddMMyyy").format(new Date());
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumsfresmi/tumSayfa"+date+".jpeg"));

        //Tekrar amazon sayfasına dönüp iphone aratalım
        driver.switchTo().window(amazon);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"+ Keys.ENTER);


        //Arama sonucunun resmini alalım
        WebElement sonuc = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        FileUtils.copyFile(sonuc.getScreenshotAs(OutputType.FILE),new File("target/WebElementScreenShot/WEScreenShot"+date+".jpeg"));
    }
    }

