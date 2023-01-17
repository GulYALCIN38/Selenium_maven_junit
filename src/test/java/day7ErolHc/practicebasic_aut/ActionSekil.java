package day7ErolHc.practicebasic_aut;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionSekil extends TestBase {
     /*
    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
    - Çizimden sonra clear butonuna basalım
    - Son olarak sayfayı temizleyiniz
     */

    @Test
    public void test01() {
        driver.get("http://szimek.github.io/signature_pad/");

       WebElement w= driver.findElement(By.xpath("//canvas"));
        Actions actions=new Actions(driver);
        actions.moveToElement(w).clickAndHold();
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,5);

        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0,5);

        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,0);

        }
        actions.release().build().perform();
        waitFor(3);
        driver.findElement(By.xpath("//*[text()='Clear']")).click();








    }
}
