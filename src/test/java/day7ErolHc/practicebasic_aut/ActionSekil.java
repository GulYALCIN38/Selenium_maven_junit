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
        Actions actions=new Actions(driver);
       WebElement w= driver.findElement(By.xpath("//*[@ style='touch-action: none; user-select: none;']"));
        actions.clickAndHold(w).moveToElement(w,120,0).release(w).perform();
        actions.clickAndHold(w).moveToElement(w,0,120).release(w).perform();
        actions.clickAndHold(w).moveToElement(w,-120,0).release(w).perform();
        actions.clickAndHold(w).moveToElement(w,0,-120).release(w).perform();
        actions.clickAndHold(w).moveToElement(w,120,120).release(w).perform();
        actions.clickAndHold(w).moveToElement(w,-120,-120).release(w).perform();
        actions.clickAndHold(w).moveToElement(w,-120,120).release(w).perform();
        actions.clickAndHold(w).moveToElement(w,120,-120).release(w).perform();







    }
}
