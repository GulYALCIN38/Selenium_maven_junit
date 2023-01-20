package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_JSExecutor_Type extends TestBase {

    //1-JUnit ile baslikta hosgeldiniz yazisini nasil automate ederiz
    //2 ne tur assert kullanirsin
    //3 bir sayfadaki  link sayisini nasil bulursunuz
    //4en son linke nasil tiklarsiniz
    //5 ekran goruntusunu nasil alirsiniz
    //6 test base de ne tur reusable met lar kullanirsiniz
    //7automation test % kac kullanirsiniz
    //8 excelde dosyalari nasil alirsiniz
    //1)typeTest metotu olustur
    //	2)Techpro education ana sayfasina git
    //	3)Arama kutusuna QA yaz
    @Test
    public void test01() {
        //1)typeTest metotu olustur
        //	2)Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        waitFor(3);
        //	3)Arama kutusuna QA yaz
        typeAvecJS(driver.findElement(By.xpath("//input[@type='search']")),"QA" );

    }
}
