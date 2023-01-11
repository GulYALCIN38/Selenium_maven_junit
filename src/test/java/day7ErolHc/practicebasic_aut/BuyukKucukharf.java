package day7ErolHc.practicebasic_aut;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class BuyukKucukharf extends TestBase {
    //google sayfasina gidelim
   //Buyuk kucuk harf olucak sekilde "HeLlO" yazdiralim
    @Test
    public void test1() {
        //google sayfasina gidelim
        driver.get("https://google.com");
       //Buyuk kucuk harf olucak sekilde "HeLlO" yazdiralim
        driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.SHIFT,"h",
                Keys.SHIFT,"e",Keys.SHIFT,"l",Keys.SHIFT,"l",Keys.SHIFT,"o",Keys.SHIFT);



    }
}
