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
        List<WebElement>otelbilgi=driver.findElements(By.xpath("//*[@class='tsc_table_s13']//tbody//tr"));
        otelbilgi.forEach(t-> System.out.println(t.getText()));

        //Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
        for (int i = 0; i < otelbilgi.size(); i++) {
            if(otelbilgi.get(i).getText().contains("601m")){
                System.out.println(otelbilgi.get(i).getText());
            }

        }


        //Bütün Height bilgilerini yazdırınız
        List<WebElement>height=driver.findElements(By.xpath("//*[@class='tsc_table_s13']//tbody//tr//td[3]"));
        height.forEach(t-> System.out.println(t.getText()));




        //Otel uzunluklarının hepsini toplayınız
        int sum=0;
        for (WebElement w:height) {

            String s=w.getText().replace("m","");
            sum+=Integer.valueOf(s);

        }
        System.out.println(sum);


        //Bir method ile satır ve sutun bilgilerini çağıralım


    }
    public void bilgi(int satir,int sutun){
        System.out.println(driver.findElement(By.xpath("//*[@class='tsc_table_s13']//tbody//tr[" + satir + "]//td[" + sutun + "]")).getText());


    }
}
