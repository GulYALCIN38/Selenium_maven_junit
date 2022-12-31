package day07alerts_iframes;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_testBaseDemo extends TestBase {
    /*
    UTILITIES;
    -UTILITIES TEKRLI kullanacagimiz methot ve classlari koydugumuz paketin adidir
    -testbase
    -driver
    -exelutil
    -configuration
    ** utilities paketinde test caseler yazilmaz

     */

    @Test
    public void test1() {
        driver.get("https://www.techproeducation.com");
        // baslik icinde Bootcams oldunu test et
        String title=driver.getTitle();
        Assert.assertTrue(title.contains("Bootcamp"));


    }
}
