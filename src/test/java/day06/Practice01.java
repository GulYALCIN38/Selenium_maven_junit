package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.time.Duration;

public class Practice01 {

    WebDriver driver;


    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");

    }
    //1. Tarayıcıyı başlatın
//2. 'http://automationexercise.com' URL'sine gidin
//3. Ana sayfanın başarıyla göründüğünü doğrulayın
//4. 'Kaydol / Giriş Yap' düğmesine tıklayın
//5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
//6. Adı ve e-posta adresini girin
//7. 'Kaydol' düğmesini tıklayın
//8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
//9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi
//10. 'Bültenimize kaydolun!' onay kutusunu seçin.
//11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
//12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
//13. 'Hesap Oluştur düğmesini' tıklayın
//14. 'HESAP OLUŞTURULDU!' görünür
//15. 'Devam Et' düğmesini tıklayın
//16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
//17. 'Hesabı Sil' düğmesini tıklayın
//18. 'HESAP SİLİNDİ!' görünür ve 'Devam Et' düğmesini tıklayın




    @Test
    public void test02() throws InterruptedException {
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        WebElement w = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(w.isDisplayed());
        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        WebElement u = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(u.isDisplayed());

        //6. Adı ve e-posta adresini girin
        //7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("GUL YALCIN", Keys.TAB, "gulfen3@gmail.com", Keys.TAB, Keys.ENTER);

        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed());
        Thread.sleep(2000);

        Actions action= new Actions(driver);
        driver.findElement(By.id("id_gender2")).click();
        action.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,"1234");

      /*  //9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi
        driver.findElement(By.id("id_gender2")).click();
        //driver.findElement(By.xpath("//*[@id='name']")).sendKeys("",Keys.TAB,"",Keys.TAB,"Endemik38*");
        driver.findElement(By.id("password")).sendKeys("Endemik38*");

        WebElement wi = driver.findElement(By.id("days"));
        Select gun = new Select(wi);
        gun.selectByVisibleText("1");

        WebElement w1 = driver.findElement(By.id("months"));
        Select ay = new Select(w1);
        ay.selectByVisibleText("January");

        WebElement w2 = driver.findElement(By.id("years"));
        Select yil = new Select(w2);
        yil.selectByValue("2000");

        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        WebElement s = driver.findElement(By.id("newsletter"));
        s.click();
        driver.findElement(By.id("optin")).click();

        //12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        //13. 'Hesap Oluştur düğmesini' tıklayın
        Thread.sleep(2000);
        driver.findElement(By.id("first_name")).sendKeys("gul",Keys.TAB,"YALCIN",Keys.TAB,"BANQUE POSTAL",
                Keys.TAB, "45 RUE TONY ESTANGUET",Keys.TAB,"OYRENES ORIENTAL");
        C02_Dropdownreusable obj=new C02_Dropdownreusable();
        obj.selectfromDropDown(driver.findElement(By.id("country")),"Canada" );
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[data-qa='state']")).sendKeys("FRANCE",Keys.TAB,
               "PERPIGNAN",Keys.TAB,"66450",Keys.TAB," 507 3124 6789");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();
        Thread.sleep(2000);

       //14. 'HESAP OLUŞTURULDU!' görünür
       Assert.assertEquals("ACCOUNT CREATED!",driver.findElement(By.xpath("//*[text()='Account Created!']")).getText());
        Thread.sleep(2000);
       //15. 'Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
//16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın  om
       // driver.navigate().back();
        //driver.findElement(By.xpath("//*[text()=['Congratulations! Your new account has been successfully created!']")).isDisplayed();
//17. 'Hesabı Sil' düğmesini tıklayın
//18. 'HESAP SİLİNDİ!' görünür ve 'Devam Et' düğmesini tıklayın*/


    }
}
