package practice.day09iframe;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Iframe extends TestBase {
    // ...Exercise 1...


// https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
// Videoyu görecek kadar asagiya ininiz
// Videoyu izlemek icin Play tusuna basiniz
// videoyu durdurunuz
// videoyu tam ekran yapınız
// videoyu calıstırınız
// videoyu kucultunuz
// videoyu durdurunuz
// Videoyu calistirdiginizi test ediniz
// 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz


    @Test
    public void name() {
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");

        Actions actions = new Actions(driver);

        // Videoyu görecek kadar asagiya ininiz
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        // Videoyu izlemek icin Play tusuna basiniz
driver.switchTo().frame(0);

        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        waitFor(4);

        // videoyu durdurunuz
        driver.findElement(By.xpath("//*[@class='ytp-play-button ytp-button']")).click();

        // videoyu tam ekran yapın
     driver.findElement(By.xpath("//*[@class='ytp-fullscreen-button ytp-button']")).click();
        // videoyu calıstırınız
        driver.findElement(By.xpath("//*[@class='ytp-play-button ytp-button']")).click();
        waitFor(2);
        // videoyu kucultunuz
        driver.findElement(By.xpath("//*[@class='ytp-fullscreen-button ytp-button']")).click();
        waitFor(2);
        // videoyu durdurunuz
        driver.findElement(By.xpath("//*[@class='ytp-play-button ytp-button']")).click();
        // Videoyu calistirdiginizi test ediniz
        assert driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']")).isDisplayed();


        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        assert driver.findElement(By.xpath("//h1")).isDisplayed();
    }
}
