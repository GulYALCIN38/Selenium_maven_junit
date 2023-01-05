package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle3 extends TestBase {
    //3 yeni window ac ve title larini verify et
    //3 yeni tab ac ve title larini verify et
    @Test
    public void newwindowhandletest01() {
        //        1. TechPro education sayfasinin titleinin "Techpro Education" metnini icerdigini test edin
        driver.get("https://techproeducation.com/");
        String s = driver.getWindowHandle();
        waitFor(3);
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));

        //        2. Yeni bir pencerede Amazon sayfasini acip titleinin "Amazon" metnini icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://amazon.com/");
        waitFor(3);
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //        3. Yeni bir pencerede linkedin sayfasini acip titleinin "LinkedIn" metnini icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com/");
        waitFor(3);
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));

        //1. pencereye don
        driver.switchTo().window(s);
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));


    }
}
