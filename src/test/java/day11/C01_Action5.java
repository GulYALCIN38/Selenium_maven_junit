package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Action5 extends TestBase {

    @Test
    public void keyboard() {
        //Create a class: Action5
        //Create a method keyboardActions
        //Google a gidin https://www.google.com

        driver.get("https://www.google.com");
        driver.findElement(By.id("L2AGLb")).click();

        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
        //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
        //Ve ENTER tusuna bas

        WebElement search=driver.findElement(By.name("q"));
        Actions actions= new Actions(driver);
        actions.keyDown(search, Keys.SHIFT)
                .sendKeys("iphone x fiyatlari")
                .keyUp(search,Keys.SHIFT)
                .sendKeys("  cok pahali!"+Keys.ENTER).build().perform();

    }
}
