package day7ErolHc.practicebasic_aut;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class RenkDegistir extends TestBase {
    /*
     -https://jqueryui.com/slider/#colorpicker adrese gidiniz
     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
     -Sarı olduğunu test edelim
     */

    @Test
    public void test01() {
        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz

        driver.get("https://jqueryui.com/slider/#colorpicker");
        WebElement iframe=driver.findElement(By.xpath("//*[@class='demo-frame']"));
        driver.switchTo().frame(iframe);
        WebElement yesiltus=driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        Actions actions=new Actions(driver);
        actions.dragAndDropBy(yesiltus,-175,0);//genellikle sliderlar icin bu methot kullanilir

        WebElement mavitus=driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));
        actions.dragAndDropBy(mavitus,-80,0);
        actions.dragAndDropBy(yesiltus,301,0).release().build().perform();




        //     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız


        //     -Sarı olduğunu test edelim

        WebElement sari= driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 255, 0);']"));
        assert sari.isDisplayed();// sari.isDisplayed() yzzip sonuna nokta koyunca assert true calisiyor
        //!sari.isDisplayed() yazip . koyup assert false calisir assert java dan gelir
        Assert.assertTrue(sari.isDisplayed());

    }
}
