package day15;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class webtables extends TestBase {
    //https://the-internet.herokuapp.com/tables
    //Create a class: WebTables
    //Task 1 : Table1’i print edin
    //Task 2 : 3. Row’ datalarını print edin
    //Task 3 : Son row daki dataları print edin
    //Task 4 : 5. Column datalarini print edin
    //Task 5 : Iki parametreli bir Java metot oluşturalım: printData
    //Parameter 1 = row numarasi
    //Parameter 2 = column numarasi
    //printData(2,3);  => 2nd row, 3rd column daki datayı print etsin

private static Logger logger= LogManager.getLogger(webtables.class.getName());
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");

        //Create a class: WebTables
        //Task 1 : Table1’i print edin
        String table1=driver.findElement(By.xpath("//table[@id='table1']")).getText();
       // System.out.println("table1 = " + table1);
        logger.info("TABLE 1 VERILERI");//21:47:53.171 [main] INFO  day15.webtables - TABLE 1 VERILERI
        List<WebElement>tableElemanlari=driver.findElements(By.xpath("//table[@id='table1']//td"));
        tableElemanlari.forEach(t-> System.out.println(t.getText()));//foreach ile de alabilirsiniz
        System.out.println("-------------------------------------------------------------");

       //Task 2 : 3. Row’ datalarını print edin

        List<WebElement>ucuncusatir=driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));
        ucuncusatir.forEach(t-> System.out.println(t.getText()));

        System.out.println("-------------------------------------------------------------");



    }

    @Test
    public void test02() {
        driver.get("https://the-internet.herokuapp.com/tables");
        //Task 3 : Son row daki dataları print edin
        List<WebElement>sonsatir=driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
        sonsatir.forEach(t-> System.out.println(t.getText()));


    }

    @Test
    public void test03() {
        driver.get("https://the-internet.herokuapp.com/tables");
        //Task 4 : 5. Column datalarini print edin

        List<WebElement>besincisutun=driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        besincisutun.forEach(t-> System.out.println(t.getText()));



    }

    @Test
    public void test04() {
        //Task 5 : Iki parametreli bir Java metot oluşturalım: printData
        //Parameter 1 = row numarasi
        //Parameter 2 = column numarasi
        //printData(2,3);  => 2nd row, 3rd column daki datayı print etsin
        driver.get("https://the-internet.herokuapp.com/tables");
        //2. satir 3. sutun verisini yazdir
        printData(2,3);

    }

    public void printData(int a, int b){
       String data=driver.findElement(By.xpath("//table[@id='table1']//tbody//tr["+a+"]//td["+b+"]")).getText();
        System.out.println("data = " + data);



    }
}
