package practice.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_dropdown {

    // ...Exercise 1...


// https://www.amazon.com/ sayfasina gidin
// dropdown'dan "Books" secenegini secin
// arama cubuguna "Java" aratın
// arama sonuclarinin Java icerdigini test edin

    WebDriver driver;
    @Before
    public void setup(){
        //1. Tarayıcıyı başlatın
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {

        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");
        // dropdown'dan "Books" secenegini secin
        //
       WebElement w= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(w);
        //select.selectByVisibleText("Books");
        //select.selectByValue("search-alias=stripbooks-intl-ship");
       select.selectByIndex(5);
        // arama cubuguna "Java" aratın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Jawa", Keys.ENTER);
        // arama sonuclarinin Java icerdigini test edin
        WebElement w1= driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(w1.getText().contains("Jawa"));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
