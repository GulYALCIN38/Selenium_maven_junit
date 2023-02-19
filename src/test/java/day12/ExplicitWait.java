package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class ExplicitWait extends TestBase {
    //https://the-internet.herokuapp.com/dynamic_loading/1
    //Start buttonuna tıkla
    //Hello World! Yazının sitede oldugunu test et

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//*[@id='start']//button")).click();

        //Hello World! Yazının sitede oldugunu test et
       /* WebElement heelloWordelement=driver.findElement(By.xpath("//*[@id='finish']//h4"));
        Assert.assertEquals("Hello World!",heelloWordelement.getText());
*/
        //implicit wait ne peut pas resoudre ce problem, il nous faut explicitWait
        /*
         eger display: none; varsa html kodunda eleman gizlenmistir ve imlicite wait yeterli degildir bu yuzden emplicit wait kullaniriz
         */

       // 1.Webdrivervait  objesi olustur
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

        //2. wait objesini kullanarak bekleme sorununu cozmeye calis
        WebElement helloWordElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']//h4")));
        Assert.assertEquals("Hello World!",helloWordElement.getText());



    }
}
