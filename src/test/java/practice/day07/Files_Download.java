package practice.day07;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Files_Download extends TestBase {

    // Exercise 2...


    //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
    //2. myfile.txt dosyasini indirelim
    //3. dosyanin bilgisayarınızda downloads'a basariyla indirilip indirilmedigini test ediniz


    @Test
    public void test01() {
        // Exercise 2...


        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
        waitFor(3);
        //2. myfile.txt dosyasini indirelim
        driver.findElement(By.linkText("LambdaTest.txt")).click();
        //3. dosyanin bilgisayarınızda downloads'a basariyla indirilip indirilmedigini test ediniz

        //"C:\Users\ASUS\Downloads\LambdaTest.txt"
       String s= System.getProperty("user.home")+"\\Downloads\\LambdaTest.txt";
        assert Files.exists(Paths.get(s));
    }
}
