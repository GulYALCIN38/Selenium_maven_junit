package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

public class FluentWaitTest extends TestBase {
    @Test
    public void test1() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıkla
        driver.findElement(By.xpath("//*[@id='start']//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        // fluentwait icin obje yap
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))// temp d'attente max
                .pollingEvery(Duration.ofSeconds(3))// intervalles d'essaie
                .withMessage("IGNORE EXCEPTION")//on peut ecrire un mesagge==> sans obligation
                .ignoring(NoSuchMethodException.class);//exeption handle ==>sans obligation
        WebElement helloWordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']//h4")));
        Assert.assertEquals("Hello World!", helloWordElement.getText());


    }
}
