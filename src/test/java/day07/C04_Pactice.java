package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_Pactice {
    // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
// Add Element butonuna 100 defa basınız
// 100 defa basıldığını test ediniz
// 90 defa delete butonuna basınız
// 90 defa basıldığını doğrulayınız
// Sayfayı kapatınız
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna 100 defa basınız
        WebElement w=driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        for (int i = 1; i < 101; i++) {
            w.click();
        }



// 100 defa basıldığını test ediniz
        List<WebElement> l=driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        int actuelno=l.size();
        System.out.println("actuelno = " + actuelno);
        Assert.assertEquals(100,actuelno);

// 90 defa delete butonuna basınız

        for (int i = 1; i < 91; i++) {
            driver.findElement(By.xpath("//*[@onclick='deleteElement()']")).click();
        }
// 90 defa basıldığını doğrulayınız
        List<WebElement> deleteButtonList=driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        int kalanButton=actuelno-90;
        Assert.assertEquals(kalanButton,deleteButtonList.size());
        driver.close();

// Sayfayı kapatınız

    }
}
