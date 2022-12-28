package practice.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C04_Google {
    /*
       https://www.google.com/ adresine gidin
       cookies uyarisini kabul ederek kapatin
       Sayfa basliginin “Google” ifadesi icerdigini test edin
       Arama cubuguna “Nutella” yazip aratin
       Bulunan sonuc sayisini yazdirin
       sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
       Sayfayi kapatin
     */
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void name() {
        //https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //cookies uyarisini kabul ederek kapatin
        driver.findElement(By.id("L2AGLb")).click();

        //Sayfa basliginin “Google” ifadesi icerdigini test edin
        driver.getTitle();
        Assert.assertTrue(driver.getTitle().contains("Google") );

        //Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);
        //Bulunan sonuc sayisini yazdirin
        String[] sonucYazisi=driver.findElement(By.id("result-stats")).getText().split(" ");
        System.out.println(Arrays.toString(sonucYazisi));

        String sayi=sonucYazisi[1].replaceAll("[^0-9]","");
        System.out.println("sayi = " + sayi);
        int a=Integer.parseInt(sayi);
        Assert.assertTrue(a>10000000);

        //sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        //Sayfayi kapatin



    }

}