package canhcpractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_Allert extends TestBase {
    // go to url :http://demo.automationtesting.in/Alerts.html
    // click  "Alert with OK" and click 'click the button to display an alert box:'
    //"Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
    //    accept Alert(I am an alert box!) and print alert on console
    //Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.
    //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    //"Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
    //    cancel Alert  (Press a Button !)
    //Alert'ü kapatın
    //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    //"Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
    //    and then sendKeys 'TechProEducation' (Please enter your name)
    //Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
    //Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
    //finally print on console this mesaaje "Hello TechproEducation How are you today"


    @Test
    public void test01() throws InterruptedException {
        driver.get("http://demo.automationtesting.in/Alerts.html");
        Thread.sleep(5000);

        // click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("(//*[@class='analystic'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();
        Thread.sleep(1000);

        //Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //"Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
        driver.findElement(By.xpath("//*[text()='Alert with OK & Cancel ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='click the button to display a confirm box ']")).click();
        Thread.sleep(2000);

        driver.switchTo().alert().dismiss();
        //"Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[text()='click the button to demonstrate the prompt box ']")).click();
        Thread.sleep(1000);

        //Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
        driver.switchTo().alert().sendKeys("gul");
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        String s=driver.findElement(By.id("demo1")).getText();
        System.out.println(s);
        Assert.assertTrue(s.contains("gul"));





    }
}
