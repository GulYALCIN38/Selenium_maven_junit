package day7ErolHc.extentreport;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Deneme extends TestBase {

    @Test
    public void name() {
        //https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelim
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        List<WebElement>lf=driver.findElements(By.xpath("//*[@class='tsc_table_s13']//thead//th"));
        lf.stream().forEach(t-> System.out.println(t.getText()));
        //Demo Table altındaki tablodaki otel bilgilerini yazdırınız
       // List<WebElement>l=driver.findElements(By.xpath("//*[@class='tsc_table_s13']//thead//th"));




        //Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
        //Bütün Height bilgilerini yazdırınız
        //Otel uzunluklarının hepsini toplayınız
        //Bir method ile satır ve sutun bilgilerini çağıralım
        //OGYHGH    JJHJHJHJ    HFH    NGJGMHNJGJHNJHJGJHF

    }
}
