package practice.day07;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class FilesUpload extends TestBase {

    // Exercise 3...

    // masaustunde bir deneme dosyası olusturun
    // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
    // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
    // 'Upload' butonuna basın
    // 'File Uploaded!' yazısının goruntulendigini test edin

    @Test
    public void test01() {
        // Exercise 3...

        // masaustunde bir deneme dosyası olusturun

        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");

        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
        driver.findElement(By.id("file-upload")).sendKeys(System.getProperty("user.home")+"\\Desktop\\deneme.txt");

        // 'Upload' butonuna basın
        driver.findElement(By.id("file-submit")).click();

        // 'File Uploaded!' yazısının goruntulendigini test edin
        assert driver.findElement(By.xpath("//h3")).isDisplayed();


    }
}
