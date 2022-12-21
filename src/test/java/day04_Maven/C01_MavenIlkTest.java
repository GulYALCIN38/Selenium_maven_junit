package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_MavenIlkTest {
    //1https://www.amazon.com/ sayfasina gidelim
//2arama kutusunu locate edelim
//3"Samsung headphones" ile arama yapalim
//4Bulunan sonuc sayisini yazdiralim
//5Ilk urunu tiklayalim
//6Sayfadaki tum basliklari yazdiralim
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //2arama kutusunu locate edelim
        WebElement aramakututsu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

        //3"Samsung headphones" ile arama yapalim
        aramakututsu.sendKeys("Samsung headphones");
        aramakututsu.submit();

        //4Bulunan sonuc sayisini yazdiralim
        WebElement w = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(w.getText());
        String[] aramasonucyazisi = w.getText().split(" ");
        System.out.println(Arrays.toString(aramasonucyazisi));

        //5Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        //6Sayfadaki tum basliklari yazdiralim
        List<WebElement> l = driver.findElements(By.xpath("//h1"));
        for (WebElement j : l
        ) {
            System.out.println(j.getText());


        }
        //2.yol
        l.stream().forEach(t -> System.out.println(t.getText()));

        driver.close();


    }
}
