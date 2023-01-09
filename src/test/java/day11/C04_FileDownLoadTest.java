package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownLoadTest extends TestBase {
    //Class : FileDownloadTest Method : downloadTestExist
    //https://testcenter.techproeducation.com/index.php?page=file-download   adresine gidelim.
    //b10 all test cases dosyasını indirelim
    //Dosyanın başarıyla indirilip indirilmediğini test edelim


    @Test
    public void test01() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download ");
       driver.findElement(By.partialLinkText("b10 all test cases")).click();

        waitFor(3);
        String filePath=System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";
        boolean telechargeoupas=Files.exists(Paths.get(filePath));
        System.out.println("telechargeoupas = " + telechargeoupas);
        Assert.assertTrue(telechargeoupas);//true
        
    }
}
