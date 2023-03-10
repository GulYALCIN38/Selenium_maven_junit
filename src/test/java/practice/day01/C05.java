package practice.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05 {
    //https://the-internet.herokuapp.com/dropdown adresine gidin.
    //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

    // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // 4.Tüm dropdown değerleri(value) yazdırın
    //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
    WebDriver driver;
    Select select;

    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement w= driver.findElement(By.id("dropdown"));
        select=new Select(w);


    }

    @Test
    public void test01() {


        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        //select.selectByValue("2");

        System.out.println(select.getFirstSelectedOption().getText());


    }

    @Test
    public void test02() {
        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
    }

    @Test
    public void test03() {
        // 4.Tüm dropdown değerleri(value) yazdırın


        List<WebElement>l=select.getOptions();
        l.stream().forEach(t-> System.out.println(t.getText()));

    }

    @Test
    public void test04() {
        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.


        List<WebElement>l=select.getOptions();
      String sonuc= l.size()==4 ? "true" : "false";
        System.out.println("sonuc = " + sonuc);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();

    }
}
