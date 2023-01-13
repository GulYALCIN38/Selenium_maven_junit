package practice.day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends TestBase {
    //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
    //2. some-file.txt dosyasini indirelim
    //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)


    @Test
    public void test01() {
        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        //2. some-file.txt dosyasini indirelim
        driver.findElement(By.linkText("some-file.txt")).click();




        /*
        eger bir dosyanin ustune sag click yaparsak copie as path  e tiklarsak dosya yolu gelir
        "C:\Users\ASUS\Downloads\some-file (1).txt"
        ""C:\Users\ASUS\Downloads\some-file.txt"
         */

        //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)
        String s=System.getProperty("user.home");
        s=s+"\\Downloads\\some-file.txt";
        boolean a=Files.exists(Paths.get(s));

        Assert.assertTrue(a);
        System.out.println(a);



    }
}
