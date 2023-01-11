package practice.day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Iframe extends TestBase {
    @Test
    public void test1() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");
        // Videoyu görecek kadar asagiya ininiz
        driver.switchTo().frame(0);
        waitFor(2);
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
waitFor(2);
        // Videoyu izlemek icin Play tusuna basiniz
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
        waitFor(3);
        // Videoyu calistirdiginizi test ediniz
       WebElement w= driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        waitFor(2);
        Assert.assertTrue(w.isDisplayed());

       // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();
        waitFor(2);

        WebElement w1= driver.findElement(By.xpath("//span[text()='Powerful, but easy to misuse'"));
        Assert.assertTrue(w1.isDisplayed());


    }
}
