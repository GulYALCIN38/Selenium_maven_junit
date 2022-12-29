package practice.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_CheckBox {
    //radyo butonda sadece 1 tik atilir
    //checkbox ise coklu tiklamaya izin verir

    // https://demo.guru99.com/test/radio.html adresine gidin
    // checkbox elementlerini locate edin
    // checkbox1 ve checkbox3  secili degil ise secin
    // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
    // checkbox2 elementinin secili olmadıgını test edi
    WebDriver driver;


    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        //driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");
        Thread.sleep(3000);
        WebElement iframe=driver.findElement(By.id("gdpr-consent-notice"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//div[@class='action-wrapper'])[3]")).click();
        driver.switchTo().parentFrame();
        Thread.sleep(2000);


       // WebElement w=driver.findElement(By.xpath("(//*[@class='mat-button-wrapper'])[4]"));
       // w.click();
        // checkbox elementlerini locate edin
        // checkbox1 ve checkbox3  secili degil ise secin
        // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        // checkbox2 elementinin secili olmadıgını test edi
    }
}

