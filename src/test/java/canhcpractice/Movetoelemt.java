package canhcpractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Movetoelemt extends TestBase {
    //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2. "Hover over Me First" kutusunun ustune gelin
    //3. "Link 1" e tiklayin
    //4. Popup mesajini yazdirin
    //5. Popup'i tamam diyerek kapatin
    //6. "Click and hold" kutusuna basili tutun
    //7. "Click and hold" kutusunda cikan yaziyi yazdirin
    //8. "Double click me" butonunu cift tiklayin
    //9. "Double click me" butonunun renk değiştridiğini doğrulayın


    @Test
    public void test01() {
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"))).perform();
        waitFor(2);

        //3. "Link 1" e tiklayin
        driver.findElement(By.linkText("Link 1")).click();
        waitFor(2);

        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();



        //6. "Click and hold" kutusuna basili tutun
        actions
                .clickAndHold(driver.findElement(By.id("click-box"))).perform();
        waitFor(2);

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//*[text()='Well done! keep holding that click now.....']")).getText());



        //8. "Double click me" butonunu cift tiklayin
        WebElement w=driver.findElement(By.id("double-click"));
        String ilkrenk=w.getCssValue("background-color");
        System.out.println("ilkrenk = " + ilkrenk);
        actions.doubleClick(w).perform();



        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        String ikinci=w.getCssValue("background-color");
        System.out.println("ikinci = " + ikinci);
        Assert.assertFalse(ilkrenk.equals(ikinci));


    }
}
