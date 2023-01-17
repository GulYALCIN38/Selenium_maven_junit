package practice.day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02Allert extends TestBase {


     //    go to url :http://demo.automationtesting.in/Alerts.html
    //    click  "Alert with OK" and click 'click the button to display an alert box:'
    //    accept Alert(I am an alert box!) and print alert on console
    //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    //    cancel Alert  (Press a Button !)
    //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    //    and then sendKeys 'TechProEducation' (Please enter your name)
    //    finally print on console this message "Hello TechproEducation How are you today"
    //    aseertion these message

    @Test
    public void test1() throws InterruptedException {
        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");
        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("//*[@onclick='alertbox()']")).click();// WebElement alert=
        //    accept Alert(I am an alert box!) and print alert on console
        System.out.println(driver.switchTo().alert().getText());//alert ustundeki yaziyi yazdirdik
        driver.switchTo().alert().accept();//alert te tamam a bastik

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'

        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();
        //    cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//*[@onclick='promptbox()']")).click();
        Thread.sleep(2000);
        //    and then sendKeys 'gul' (Please enter your name)
        driver.switchTo().alert().sendKeys("gul");
        driver.switchTo().alert().accept();

        //    finally print on console this message "Hello Gul How are you today"
        WebElement w=driver.findElement(By.xpath("//*[@id='demo1']"));
        Thread.sleep(2000);
        System.out.println(w.getText());
        Assert.assertTrue(w.getText().contains("gul"));
        //    aseertion these message
        Assert.assertNotEquals("Hello Gul How are you today",w.getText());
    }
}
