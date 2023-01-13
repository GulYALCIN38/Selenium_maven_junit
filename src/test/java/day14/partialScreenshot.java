package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class partialScreenshot extends TestBase {

    @Test
    public void test01() throws IOException {
        //Tecproya gir
        driver.get("https://www.techproeducation.com");
        WebElement w= driver.findElement(By.xpath("(//div[@class='elementor-widget-container'])[1]"));
        File image=w.getScreenshotAs(OutputType.FILE);

       // 2. Save screenshot
       // getting the current time as string to use in teh screenshot name, previous screenshots will be kept
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
       // Path of screenshot save folder               folder / folder    /file name
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));


    }

    @Test
    public void test02() throws IOException {
        driver.get("https://www.techproeducation.com");


        takeScreenshotOfElement(driver.findElement(By.xpath("//img[@class='attachment-large size-large lazyloaded']")));


    }
}
