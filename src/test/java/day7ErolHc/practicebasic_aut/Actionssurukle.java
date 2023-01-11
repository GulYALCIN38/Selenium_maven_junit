package day7ErolHc.practicebasic_aut;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Actionssurukle extends TestBase {

    @Test
    public void test01() {

        /*
     -https://jqueryui.com/slider/#colorpicker adrese gidiniz
     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
     */
        driver.get("https://jqueryui.com/slider/#colorpicker");
        driver.switchTo().frame(0);
       WebElement w2=driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
       w2.click();

        WebElement recource=driver.findElement(By.xpath("//*[@style='left: 54.902%;']"));
        WebElement sible=driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 0, 60);']"));

        Actions actions=new Actions(driver);
        //actions.dragAndDrop(recource,sible).perform();
        actions.clickAndHold(w2).moveToElement(sible,0,0).perform();

    }
}
