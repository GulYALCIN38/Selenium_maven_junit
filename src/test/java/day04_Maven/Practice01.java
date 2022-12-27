package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Practice01 {
    //1. "https://www.saucedemo.com" Adresine gidin
//2. Username kutusuna "standard_user" yazdirin
//3. Password kutusuna "secret_sauce" yazdirin
//4. Login tusuna basin
//5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
//6. Add to Cart butonuna basin
//7. Alisveris sepetine tiklayin
//8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
//9. Sayfayi kapatin
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");
//2. Username kutusuna "standard_user" yazdirin
        List<WebElement>l=driver.findElements(By.cssSelector("input[class='input_error form_input']"));
        l.get(0).sendKeys("standard_user");
//3. Password kutusuna "secret_sauce" yazdirin
        l.get(1).sendKeys("secret_sauce");
//4. Login tusuna basin
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(20000);
//5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement urunIsmi=driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        String URUNADI=urunIsmi.getText();
        System.out.println("URUNADI = " + URUNADI);
        urunIsmi.click();
        //driver.findElement(By.xpath("//*[@alt='Sauce Labs Backpack']")).click();
//6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
//7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();
//8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement w=driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
       String sonuc= w.getText().equals(URUNADI)? "TEST PASSED" :"TEST FAILED";
        System.out.println("sonuc = " + sonuc);


//9. Sayfayi kapatin
        driver.close();

    }
}
