package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Practice02Shadow {
    WebDriver driver;
     /*
1-https://books-pwakit.appspot.com/ adresine gidin.
2-"BOOKS" başlığının görünür olduğunu doğrulayın
3-Arama çubuğunda "Selenium" u aratın.
4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.
*/
     @Before
     public void setUp() throws InterruptedException {
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



     }

    @Test
    public void test01() {

     //1-https://books-pwakit.appspot.com/ adresine gidin.
   driver.get("https://books-pwakit.appspot.com/");

//2-"BOOKS" başlığının görünür olduğunu doğrulayın
        SearchContext s1= driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        WebElement w=s1.findElement(By.cssSelector("a[href='/']"));
        Assert.assertTrue( w.isDisplayed());
//3-Arama çubuğunda "Selenium" u aratın.
        SearchContext s2=driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        s2.findElement(By.cssSelector("#input")).sendKeys("Selenium", Keys.ENTER);

//4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.


    }
}
