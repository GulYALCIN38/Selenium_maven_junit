package day15;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Extentreport2 extends TestBase {
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;


    @BeforeClass
    public static void extentraporsetup() throws Exception {
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


    }

    @Test
    public void extentreporttest() {
        extentTest.pass("PASS");
        extentTest.info("BILGILENDIRME NOTU");
        extentTest.fail("FAILED");
        extentTest.warning("UYARI MESAJI");
        extentTest.skip("ATLAMA MESAJI");
        extentTest.fatal("COKUS HATASI");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        extentReports.flush();
    }
}
