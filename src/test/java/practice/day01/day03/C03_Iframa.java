package practice.day01.day03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C03_Iframa extends TestBase {
       /*
  // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
  // ikinci emojiye tıklayın
  // tüm ikinci emoji öğelerini tıklayın
  // parent iframe e geri donun
  // formu doldurun,(Formu istediğiniz metinlerle doldurun)
  //  apply button a basin
*/

    @Test
    public void testo1() throws InterruptedException {

        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın

        WebElement w = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(w);
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//*[@data-upgraded=',MaterialRipple'])[2]")).click();
        // tüm ikinci emoji öğelerini tıklayın
        List<WebElement> emojis = driver.findElements(By.xpath("//*[@id='nature']//img"));
        emojis.stream().forEach(t -> t.click());
        // parent iframe e geri donun
        Thread.sleep(2000);
        driver.switchTo().defaultContent();//
        //driver.navigate().refresh();
        Thread.sleep(2000);
        // formu doldurun,(Formu istediğiniz metinlerle doldurun)
        //driver.findElement(By.xpath("//*[@id='text']")).sendKeys("gul");
        List<WebElement>l=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        System.out.println(l.size());
        List<String>veriler=new ArrayList<>(Arrays.asList("gul","muz","1","2","3","4","5","sql","6","7","8"));
        for (int i = 0; i < l.size(); i++) {
            l.get(i).sendKeys(veriler.get(i));

        }
        l.get(l.size()-1).click();

        //  apply button a basin
        l.get(l.size()-1).sendKeys("",Keys.TAB, Keys.ENTER);


    }
}
