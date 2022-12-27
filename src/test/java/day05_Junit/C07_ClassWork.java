package day05_Junit;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C07_ClassWork {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public  void tearDown()  {
        driver.close();

    }


    @Test
    public void test01() {
        //2)https://www.amazon.com adresinegidin
        driver.get("https://www.amazon.com");

        //3)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleriyapin
        //○ title Test  => Sayfa başlığının “Amazon” oldugunu testedin
        String actuelTitle= driver.getTitle();
        System.out.println(actuelTitle);
        String expectedTitle="Amazon";
        Assert.assertTrue(actuelTitle.contains(expectedTitle));


    }

    @Test
    public void test02() {
        //○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) testedin

        WebElement logo=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void test03() {
        //○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
        WebElement aramaKutusu=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Assert.assertTrue(aramaKutusu.isEnabled());
    }

    @Test
    public void test04() {
        //○ wrongTitleTest => Sayfa basliginin “amazon” olmadigini dogrulayin
        String actuelTitle= driver.getTitle();
        String expectedTitle="amazon";
        Assert.assertFalse(actuelTitle.contains("amazon"));

    }
}
