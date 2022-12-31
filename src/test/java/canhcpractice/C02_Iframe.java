package canhcpractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_Iframe extends TestBase {

//go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
//maximize the web site
// ikinci emojiye tıklayın
// ikinci emoji altındaki tüm öğelere tıklayın
// ana iframe'e geri dön
//formu doldurun,(Formu istediğiniz metinlerle doldurun)
// uygula butonuna tıklayın


    @Test
    public void test01() throws InterruptedException {
        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        //maximize the web site

        // ikinci emojiye tıklayın
        driver.switchTo().frame("emoojis");
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
        Thread.sleep(2000);

        // ikinci emoji altındaki tüm öğelere tıklayın
        List<WebElement>l=driver.findElements(By.xpath("//*[@class='mdl-tabs__panel is-active']//img"));
        l.stream().forEach(t->t.click());
        Thread.sleep(2000);

        // ana iframe'e geri dön
        driver.switchTo().defaultContent();

        //formu doldurun,(Formu istediğiniz metinlerle doldurun)
        // uygula butonuna tıklayın
        driver.findElement(By.xpath("//*[@id='text']")).sendKeys("explication", Keys.TAB,"rose",
                Keys.TAB,"LALE",Keys.TAB,"banana",Keys.TAB,"tenis",Keys.TAB,"maison",Keys.TAB,"fenetre",Keys.TAB,"drape",Keys.TAB,"france",
                Keys.TAB,":))",Keys.TAB,"sourire",Keys.TAB,Keys.ENTER);

        Thread.sleep(2000);



    }
}
