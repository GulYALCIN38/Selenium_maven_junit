package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionClass extends TestBase {
    @Test
    public void test01() {
        //1. https://www.flipkart.com adresine gidin
        //2. Electronics Audio mağazasından kablolu kulaklıkları bulun ve tıklayın
        //3. Başlığı görüntüleyin
        //4. Man mağazasından Tişörtleri bulun ve tıklayın
        //5. Başlığı görüntüleyin ve programı kapatın

        driver.get("https://www.flipkart.com");
        waitFor(2);

        driver.findElement(By.xpath("//*[text()='✕']")).click();

        waitFor(2);
        System.out.println(driver.getTitle());
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[text()='Electronics']"))).perform();
        driver.findElement(By.linkText("Wired Headphones")).click();
     ;


        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//*[text()='Men']")).click();
        waitFor(2);

        driver.findElement(By.linkText("T-Shirts")).click();

        System.out.println(driver.getTitle());
    }
}
