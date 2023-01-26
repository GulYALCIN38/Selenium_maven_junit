package day7ErolHc.extentreport;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExeldenBilgiOkuma extends TestBase {
    //Bilgisayarınızdaki data isimli excel dosyasından kullanıcı bilgilerini alıp
    //https://www.bluerentalcars.com/ adresine gidip
    //Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
    //Login olduğumuzu doğrulayalım

    @Test
    public void test01() throws IOException {
        //Bilgisayarınızdaki data isimli excel dosyasından kullanıcı bilgilerini alıp
        String dosyayolu="C:\\Users\\ASUS\\Desktop\\data.xlsx";
        FileInputStream fis=new FileInputStream(dosyayolu);
        Workbook workbook= WorkbookFactory.create(fis);
        String email=workbook.getSheet("Sayfa1").getRow(1).getCell(1).toString();

        System.out.println("email = " + email);
        String password=workbook.getSheet("Sayfa1").getRow(2).getCell(1).toString();
        System.out.println("password = " + password);
          //https://www.bluerentalcars.com/ adrenaline gidip
        driver.get("https://www.bluerentalcars.com/");
               //Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
        driver.findElement(By.xpath("(//*[@role='button'])[1]")).click();
       WebElement w= driver.findElement(By.id("formBasicEmail"));
       w.sendKeys(email, Keys.TAB,password,Keys.TAB,Keys.ENTER);

             //Login olduğumuzu doğrulayalım
        WebElement login = driver.findElement(By.xpath("//*[@id='dropdown-basic-button']"));
        assert login.getText().equals("Erol Evren");

    }


}
