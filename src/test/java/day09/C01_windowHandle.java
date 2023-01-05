package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_windowHandle extends TestBase {
    //https://the-internet.herokuapp.com/windows adresine gidin.
    //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //Click Here butonuna basın.
    //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin

    @Test
    public void windowHandleTest() {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String handle1=driver.getWindowHandle();

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actuel=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",actuel);
        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actuelTitle=driver.getTitle();
        Assert.assertEquals("The Internet",actuelTitle);

        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        waitFor(3);

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin
        switchToWindow(1);
        String actuelTiyle2= driver.getTitle();
        System.out.println(actuelTiyle2);
        Assert.assertEquals("New Window",actuelTiyle2);

        switchToWindow(0);
        System.out.println(driver.getTitle());


    }
}
