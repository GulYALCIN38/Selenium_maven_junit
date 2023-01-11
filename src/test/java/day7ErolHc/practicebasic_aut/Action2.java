package day7ErolHc.practicebasic_aut;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Action2 extends TestBase {
    /*
        -http://spicejet.com/ sayfasına gidelim
        -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        -Sayfa başlığının Fleet içerdiğini test edelim
     */

    @Test
    public void test1() {

        //  -http://spicejet.com/ sayfasına gidelim
        driver.get("http://spicejet.com/");
        //        -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        WebElement w=driver.findElement(By.xpath("//*[.='About Us']"));

        Actions actions=new Actions(driver);
        actions.moveToElement(w).perform();

        //        -Sayfa başlığının Fleet içerdiğini test edelim
        waitFor(2);
        WebElement w1=driver.findElement(By.xpath("//*[.='Fleet']"));
        w1.click();
    }
}
