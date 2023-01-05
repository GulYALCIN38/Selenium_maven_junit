package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_BasicOtantication extends TestBase {
    //Bir class olusturun : BasicAuthentication
    //https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    //asagidaki yontem ve test datalarini kullanarak authentication'i yapin
    //URL              : https://username:password@URL
    //Username    : admin
    //password    : admin
    //Basarili sekilde sayfaya girin ve 'Congratulations!' yasizini doğrulayın

    @Test
    public void basicotantication() {
        //https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/basic_auth");

        //asagidaki yontem ve test datalarini kullanarak authentication'i yapin
        //URL              : https://username:password@URL
        //Username    : admin
        //password    : admin

        // AUTHENTICATION URL  ; https://admin:admin@the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        waitFor(3);

        //Basarili sekilde sayfaya girin ve 'Congratulations!' yasizini doğrulayın
        String s=driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(s.contains("Congratulations!"));


    }
}
