package day7ErolHc.practicefluentwait;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Uploadfiles extends TestBase {
    //https://demo.guru99.com/test/upload/ adresine gidiniz
    //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
    // I accept terms of service bölümünü tikleyin
    // Submit File buttonuna basınız
    // "1 file has been successfully uploaded" görünür olduğunu test edin

    @Test
    public void test01() throws InterruptedException {
        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");

        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz

        //"C:\Users\ASUS\Desktop\sorulqr.docx"
/*        String farklikisim=System.getProperty("user.home");
        String  ortak="\\Desktop\\sorulqr.docx";
        String dosya=farklikisim+ortak;
        */
        String dosyayolu= "C:\\Users\\ASUS\\Desktop\\sorulqr.docx" ;




        WebElement dosyaSec= driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
        dosyaSec.sendKeys(dosyayolu);
        // I accept terms of service bölümünü tikleyin
        //driver.findElement(By.xpath("//*[text()='Accept All']")).click();
        WebElement checkBox =  driver.findElement(By.xpath("//*[@id='terms']"));
        checkBox.click();
        checkBox.sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER);
        // Submit File buttonuna basınız
        // "1 file has been successfully uploaded" görünür olduğunu test edin

        // "1 file has been successfully uploaded" görünür olduğunu test edin
        Thread.sleep(2000);
        assert driver.findElement(By.xpath("//*[@id='res']")).isDisplayed();





    }
}
