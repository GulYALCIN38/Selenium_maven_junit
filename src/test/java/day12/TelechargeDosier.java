package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TelechargeDosier extends TestBase {

    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");


        //chooseFile butonuna basalim
       WebElement choosefileButton= driver.findElement(By.id("file-upload"));

        //Yuklemek istediginiz dosyayi secelim.
        String  path=System.getProperty("user.home")+"/desktop/logo.jpeg";
        choosefileButton.sendKeys(path);
        waitFor(5);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        String textUploaded=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!",textUploaded);


    }
}
