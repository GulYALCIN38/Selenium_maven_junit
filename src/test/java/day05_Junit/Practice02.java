package day05_Junit;

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

import java.time.Duration;
/* Given kullanici "https://editor.datatables.net/" sayfasina gider
    Then new butonuna basar
    And editor firstname kutusuna "<firstName>" bilgileri girer
    And editor lastname kutusuna "<lastName>" bilgileri girer
    And editor position kutusuna "<position>" bilgileri girer
    And editor office kutusuna "<office>" bilgileri girer
    And editor extension kutusuna "<extension>" bilgileri girer
    And editor startdate kutusuna "<startDate>" bilgileri girer
    And editor salary kutusuna "<salary>" bilgileri girer
    When Create tusuna basar
    Then Kullanıcının eklendiğini doğrular.
   And Eklediği kullanıcı kaydını siler
    Then Kullanıcinin silindiğini doğrular.
    */

public class Practice02 {
    WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //* Given kullanici "https://editor.datatables.net/" sayfasina gider
        driver.get("https://editor.datatables.net/");

        Thread.sleep(2000);
        //    Then new butonuna basar
        driver.findElement(By.xpath("//*[@class='dt-button buttons-create']")).click();

        Thread.sleep(2000);
        //    And editor firstname kutusuna "<firstName>" bilgileri girer
        //    And editor lastname kutusuna "<lastName>" bilgileri girer
        //    And editor position kutusuna "<position>" bilgileri girer
        //    And editor office kutusuna "<office>" bilgileri girer
        //    And editor extension kutusuna "<extension>" bilgileri girer
        //    And editor startdate kutusuna "<startDate>" bilgileri girer
        //    And editor salary kutusuna "<salary>" bilgileri girer
        driver.findElement(By.cssSelector("input[id='DTE_Field_first_name']")).sendKeys("Manuel",
                Keys.TAB,"Macron",Keys.TAB,"President",Keys.TAB,"Paris",Keys.TAB,"gerer",Keys.TAB,"2017-06-16",
                Keys.TAB,"200000");

        Thread.sleep(2000);
        //    When Create tusuna basar
        driver.findElement(By.xpath("//*[text()='Create']")).click();
        Thread.sleep(2000);
        //    Then Kullanıcının eklendiğini doğrular.
        WebElement w=driver.findElement(By.xpath("//*[text()='Next']"));
        w.click();
        WebElement w2=driver.findElement(By.xpath("//*[text()='Next']"));
        w2.click();
        WebElement w3=driver.findElement(By.xpath("//*[text()='Next']"));
        w3.click();


    }

    @After
    public void tearDown() {

        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        WebElement w1=driver.findElement(By.xpath("//*[text()='Manuel Macron']"));
        Assert.assertTrue(w1.isDisplayed());

    }

    @Test
    public void test02() throws InterruptedException {
        //    And Eklediği kullanıcı kaydını siler
        driver.findElement(By.xpath("//*[text()='Manuel Macron']")).click();
        driver.findElement(By.xpath("//*[text()='Delete']")).click();
        driver.findElement(By.xpath("//*[@class='btn']")).click();
//    Then Kullanıcinin silindiğini doğrular.
        Thread.sleep(2000);
        boolean gorunuyormu;
        try {
            gorunuyormu=driver.findElement(By.xpath("//*[text()='Manuel Macron']")).isDisplayed();
        } catch (Exception e) {
           gorunuyormu=false;
        }
        Assert.assertEquals(false,gorunuyormu);
    }


}
