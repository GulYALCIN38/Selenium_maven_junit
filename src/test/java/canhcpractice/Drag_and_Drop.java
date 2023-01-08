package canhcpractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Drag_and_Drop extends TestBase {

  /*
   #url'ye gidin: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
  #Ülkeye göre başkentleri doldurun
 */


    @Test
    public void test01() {
        driver.get(" http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

         Actions actions= new Actions(driver);

        for (int i = 1; i <8 ; i++) {
            actions.dragAndDrop(driver.findElement(By.id("box"+i)), driver.findElement(By.id("box10"+i))).perform();
        }

    }

}
