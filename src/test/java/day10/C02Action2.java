package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02Action2 extends TestBase {

    /*
    amazona git
    account list uzerinde bekle
    account ta tikla
    acilan sayfanin title inin your account old dogrula
     */

    @Test
    public void hoveroverTest()  {
        driver.get("https://amazon.com/");
        //account list uzerinde bekle
        Actions actions=new Actions(driver);
        WebElement w= driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(w).perform();//bir elemanin ustunde bekletir mausu altindaki ogeler gorunsun diye
        //    account ta tikla
        driver.findElement(By.linkText("Account")).click();
        //    acilan sayfanin title inin your account old dogrula

        Assert.assertEquals("Your Account", driver.getTitle());
    }
}
