package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01WindowHandel1 extends TestBase {
    //Tests package’inda yeni bir class olusturun: WindowHandle
    //https://the-internet.herokuapp.com/windows adresine gidin.
    //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //Click Here butonuna basın.
    //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //Sayfadaki textin “New Window” olduğunu doğrulayın.
    //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.


    @Test
    public void name() throws InterruptedException {

            //Tests package’inda yeni bir class olusturun: WindowHandle
            //https://the-internet.herokuapp.com/windows adresine gidin.
        // ---------------------- ilk sayfanin handel al------------------ coklu sayfa oldugunda mutlaka ilk sayfanin handle al
        String handle1=driver.getWindowHandle();
        driver.get("https://the-internet.herokuapp.com/windows");
        String window1text= driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",window1text);
        Thread.sleep(2000);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String title1=driver.getTitle();
        Assert.assertEquals("The Internet",title1);

        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        //-----------------2 pencere acik2. YE GECMEK ICIN;

        Set<String> tumPencereler= driver.getWindowHandles();//buradan iki tane handle gelecek
       tumPencereler.stream().filter(t->!t.equals(handle1)).forEach(t->driver.switchTo().window(t));
       String handle2=driver.getWindowHandle();
        /*for(String w:tumPencereler){
            if(!w.equals(handle1)){
                driver.switchTo().window(w);
            }
        }
*/     // sayfa basliginin "New Window"
        String window2title= driver.getTitle();
        System.out.println(window2title);
        Assert.assertEquals("New Window",window2title);


        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertEquals("New Window",driver.findElement(By.xpath("//h3")).getText());
        Thread.sleep(2000);



        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        Thread.sleep(2000);
        driver.switchTo().window(handle1);
        Assert.assertEquals("The Internet",driver.getTitle());

        // 2. sf gec
        driver.switchTo().window(handle2);
        Thread.sleep(2000);

    }
}
