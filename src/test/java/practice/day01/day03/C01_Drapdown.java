package practice.day01.day03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_Drapdown extends TestBase {
    //Amazon sayfasına gidelim
    //Dropdown menuden baby seçelim
    //arama bölumunden milk aratalım

    @Test
    public void dropdown() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Dropdown menuden baby seçelim


        /*WebElement we = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select selecObject = new Select(we);
        selecObject.selectByIndex(3);*/
        List<WebElement> l = driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
        l.stream().forEach(t -> System.out.println(t.getText()));
        //arama bölumunden milk aratalım
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby",
                Keys.TAB, "Milk", Keys.ENTER);


    }
    /*
    public class Dropdown extends TestBase {
    @Test
    public void test01() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //Dropdown menuyu yazdıralım
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropdown);
        for (WebElement w:select.getOptions()) {
            System.out.println(w.getText());
        }
        //Dropdown menuden baby secelim
        //arama bölümünden milk aratalım
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby"
                , Keys.TAB,"Milk",Keys.ENTER);
    }
}
     */
}
