package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Practice02 {
    //C01_TekrarTesti isimli bir class olusturun
//2 https://www.google.com/ adresine gidin
//3 cookies uyarisini kabul ederek kapatin
//4 Sayfa basliginin "Google" ifadesi icerdigini test edin
//5 Arama cubuguna "Nutella" yazip aratin
//6 Bulunan sonuc sayisini yazdirin
//7 sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
//8 Sayfayi kapatin
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//2 https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
//3 cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//*[@id='L2AGLb']")).click();

//4 Sayfa basliginin "Google" ifadesi icerdigini test edin
        String actueltitle=driver.getTitle();
        String expectedTitle="Google";
        if(actueltitle.contains(expectedTitle)){
            System.out.println(" title test passed");
        }else{
            System.out.println("title test failed");
        }
//5 Arama cubuguna "Nutella" yazip aratin
        driver.findElement(By.cssSelector("input[class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);
//6 Bulunan sonuc sayisini yazdirin
        WebElement w=driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println("sonuc yazisi="+w.getText());
        Thread.sleep(3000);
//7 sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
        String [] sonuc=w.getText().split(" ");
        System.out.println(sonuc[1]);

        sonuc[1] = sonuc[1].replaceAll("[^0-9]", "");
        System.out.println("sonuc[1] = " + sonuc[1]);
      Thread.sleep(2000);
        int num =Integer.parseInt(sonuc[1]);
        if (num > 10000000) {
            System.out.println("Passed");
        } else System.out.println("Failed");



//8 Sayfayi kapatin
    }
}
