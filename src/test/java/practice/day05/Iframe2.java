package practice.day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Iframe2 extends TestBase {

    // https://the-internet.herokuapp.com/iframe sayfasina gidiniz
    // 'An iFrame containing the TinyMCE WYSIWYG Editor' basliginin erisilebilir oldugunu test edin ve konsolda yazdırın.
    // TextBox'a 'Merhaba Dunya' yazin.
    // TextBox'in altinda bulunan 'Elemental Selenium' linkinin gorunur oldugunu test edin ve konsolda yazdirin

    @Test
    public void test1() {

        // https://the-internet.herokuapp.com/iframe sayfasina gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 'An iFrame containing the TinyMCE WYSIWYG Editor' basliginin erisilebilir oldugunu test edin ve konsolda yazdırın.
        WebElement title= driver.findElement(By.xpath("//*[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(title.isEnabled());
        System.out.println("title "+title.getText());

        // TextBox'a 'Merhaba Dunya' yazin.
        WebElement w= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(w);
        WebElement w1=driver.findElement(By.xpath("//p"));
        w1.clear();
        w1.sendKeys("merhaba dunya");

        driver.switchTo().parentFrame();



        // TextBox'in altinda bulunan 'Elemental Selenium' linkinin gorunur oldugunu test edin ve konsolda yazdirin
        WebElement w2=driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(w2.isDisplayed());


    }
}
