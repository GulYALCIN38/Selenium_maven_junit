package day10;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Action3 extends TestBase {
    @Test
    public void scrollupDown() {

        //https://techproeducation.com a git
        driver.get("https://techproeducation.com");
        Actions actions=new Actions(driver);
        //Sayfanin altına doğru gidelim
       /* actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);*/
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        actions.sendKeys(Keys.ARROW_DOWN).perform();//ARROW DOWN SAYFAYI BIRTIK ASAGI INDIREN ASAGI OK KOMUTUDUR
        //Sonra sayfanın üstüne doğru gidelim
        waitFor(2);
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitFor(2);
        actions.sendKeys(Keys.ARROW_UP).perform();
        waitFor(2);

        actions.sendKeys(Keys.ARROW_RIGHT).perform();
        waitFor(2);
        actions.sendKeys(Keys.ARROW_LEFT).perform();

    }
}
