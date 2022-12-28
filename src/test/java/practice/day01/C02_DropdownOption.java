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
import java.util.List;

public class C02_DropdownOption {
    // ...Exercise 2...


    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Baby" secenegini secin
    // sectiginiz option'i yazdirin
    // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
    WebDriver driver;

    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {//alt tusuna basili tut ve mausun soltusuna basili tutarak asagiya in sonra bosluk ile saga cek yorumu
        // ...Exercise 2...


// https://www.amazon.com/ sayfasina gidinctrl alt tusuna basili tut alasdf
        driver.get("https://www.amazon.com/");
        // dropdown'dan "Baby" secenegini secin
        WebElement w = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(w);
        select.selectByVisibleText("Baby");
        // sectiginiz option'i yazdirin
        String sectigimizOption = select.getFirstSelectedOption().getText();

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> options = driver.findElements(By.tagName("option"));
        System.out.println(options.size());
        Assert.assertEquals(28, options.size());
        //List<WebElement> tumOption=select.getOptions();
    }
}
