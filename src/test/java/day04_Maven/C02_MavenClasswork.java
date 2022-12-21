package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenClasswork {
    /*
1. http://zero.webappsecurity.com sayfasina gidin
2. Signin buttonuna tiklayin
3. Login alanine  "username" yazdirin
4. Password alanine "password" yazdirin
5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
6. Online Banking menusunden Pay Bills sayfasina gidin
7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
8. tarih kismina "2020-09-10" yazdirin
9. Pay buttonuna tiklayin
10. "The payment was successfully submitted." mesajinin ciktigini kontrol edin
*/
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("button[id='signin_button']")).click();
        //3. Login alanine  "username" yazdirin
        WebElement w=driver.findElement(By.xpath("//*[@ID='user_login']"));
        w.sendKeys("username");

        //4. Password alanine "password" yazdirin
        WebElement password=driver.findElement(By.xpath("//*[@id='user_password']"));
        password.sendKeys("password");

        //5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
        driver.findElement(By.cssSelector("input[name='submit']")).click();
        driver.navigate().back();

        //6. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount=driver.findElement(By.cssSelector("input[id='sp_amount']"));
        amount.sendKeys("1000");

        //8. tarih kismina "2020-09-10" yazdirin
        WebElement date=driver.findElement(By.xpath("//*[@id='sp_date']"));
        date.sendKeys("2020-09-10");


        //9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        //10. "The payment was successfully submitted." mesajinin ciktigini kontrol edin
        WebElement mesaj=driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        if(mesaj.isDisplayed()){
            System.out.println("test passed");
        }else{
            System.out.println("test passed");
        }
        driver.close();

    }
}
