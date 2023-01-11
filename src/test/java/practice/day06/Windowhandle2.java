package practice.day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class Windowhandle2 extends TestBase {

    // 1- https://www.amazon.com sayfasina gidelim
    // 2- url'in 'amazon' icerdigini test edelim
    // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
    // 4- title'in 'Best Buy' icerdigini test edelim
    // 5- ilk sayfaya(amazon) donup sayfada java aratalım
    // 6- arama sonuclarının 'Java' icerdigini test edelim
    // 7- ikinci sayfaya(bestbuy) donelim
    // 8- logonun gorundugunu test edelim

    @Test
    public void test01() {

        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String fenetre1=driver.getWindowHandle();

        // 2- url'in 'amazon' icerdigini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        waitFor(2);

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        waitFor(2);
        driver.get("https://www.bestbuy.com");
        waitFor(3);

        // 4- title'in 'Best Buy' icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(fenetre1);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);

        // 6- arama sonuclarının 'Java' icerdigini test edelim
        WebElement w1= driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']"));
        Assert.assertTrue(w1.getText().contains("java"));

        // 7- ikinci sayfaya(bestbuy) donelim
        switchToWindow(1);

        // 8- logonun gorundugunu test edelim
        WebElement w2=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(w2.isDisplayed());

    }
}
