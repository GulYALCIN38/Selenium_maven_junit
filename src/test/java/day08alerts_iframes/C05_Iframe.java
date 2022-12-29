package day08alerts_iframes;

import dev.failsafe.internal.util.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_Iframe extends TestBase {

    @Test
    public void iframetest() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        String x=driver.findElement(By.xpath("//*[text()='An iframe with a thin black border:']")).getText();

    }
}
