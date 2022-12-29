package practice.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C06 {
    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' URL'sine gidin
    //3. Ana sayfanın başarıyla göründüğünü doğrulayın
    //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
    //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
    //6. Doğru e-posta adresini ve şifreyi girin
    //7. 'Giriş' düğmesine tıklayın
    //8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
    //9. 'Çıkış' düğmesini tıklayın
    //10. Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın

    WebDriver driver;


    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test
    public void test01() {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
        //6. Doğru e-posta adresini ve şifreyi girin
        //7. 'Giriş' düğmesine tıklayın
        //8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        //9. 'Çıkış' düğmesini tıklayın
        //10. Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın




    }
}
