package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    //driver objesi olustur, bu ya public veya protected olmali. sebebi child klaslarda gorunur olmasi
    // TestBase i abstract yapmamizin sebebi bu sinifin objesini olusturmak istemiyorum
// TestBase testBase = new TestBase(); -> YAPILAMAZ!
// Amacim bu sinifi extend etmek ve icindeki hazir method'lari kullanmak
    protected static WebDriver driver;

    // setUp


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    //teardown
    @After
    public void tearDown() {
        driver.quit();

    }
    //    MULTIPLE WINDOW
    public static void switchToWindow(String targetTitle) {//targettitle gecis yapmak istedigim sayfanin title si
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;//loop tan disari cik
            }
        }
        driver.switchTo().window(origin);
    }
}
