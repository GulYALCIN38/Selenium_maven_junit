package day14;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Extendreport1 extends TestBase {
    // bilmek gereken 3 onemli degisken

    // extend report ayri bir api dir selenyumun parcasi degildir. selenyumun disinda da kullanilabilir
    // extent report ta 3 class kullandik 1.ExtentReports sablon olustururr, 2.ExtentHtmlReporter sablonu generate
    // projeye ekler eder gosterir, 3.ExtentTest raporlama yapar ve loglari rapora yazdirir
    // ropert dosyayi gormek icin ustune sag tikla --open in --Browser --CHROME
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;


    @Test
    public void test01() {
        //      REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";
//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();

        //  ***********************************RAPORU CUSTOMIZE EDEBILIRIZ****************************
        extentReports.setSystemInfo("test envionement","regretion");
        extentReports.setSystemInfo("Aplication","amazon");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("takim","Eagles");
        extentReports.setSystemInfo("Epic","odeme sayfasi");
        extentReports.setSystemInfo("sprint no","sprint-145");
        extentReports.setSystemInfo("qa","gul");

        //************************** EXTRA RAPOR ISMI VE DOKUMAN ISMI EKLEYEBILIRIZ ******************
        extentHtmlReporter.config().setDocumentTitle("TechproEd Extent Report");
        extentHtmlReporter.config().setDocumentTitle("Regretion test sonucu");

        //************************** RAPOR AYARLARI BITTI ******************
        extentReports.attachReporter(extentHtmlReporter);

        // extent test objesi olusturduk
        extentTest=extentReports.createTest("Extent report login test","smoke test raporu");

        // tum ayarlar bitti loglama(rapor yazdirma) islemi yapilabilir


        extentTest.pass("Kullanici ana sayfaya gider");
        driver.get("https://www.techproeducation.com");

        // LMS sayfasina gidelim
        extentTest.pass("Kullanici LMS sayfaya gider");
        driver.findElement(By.linkText("LMS LOGIN")).click();

        //TEST BITTI
        extentTest.pass("TEST BASARI ILE GERCEKLESTI");

        //RAPORU GOSTER. raporun olusmasi icin bu rapor zorunludur
         extentReports.flush();






    }
}
