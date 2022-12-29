package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Practice {
    //BeforeClass ile driver ı olusturun ve
    //Maximize edin, 15 sn bekletin
    //http://www.google.com adresine gidin
    //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    //AfterClass ile kapatın
    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Before
    public void setUp() throws InterruptedException {


        driver.get("http://www.google.com");
        driver.findElement(By.xpath("//*[text()='Tout accepter']")).click();


    }

    @Test
    public void test01() {

        driver.findElement(By.cssSelector("input[class='gLFyf']")).sendKeys("The God Father", Keys.ENTER);

    }

    @Test
    public void test02() {

        driver.findElement(By.cssSelector("input[class='gLFyf']")).sendKeys("Lord of the Rings", Keys.ENTER);
    }

    @Test
    public void test03() {

        driver.findElement(By.cssSelector("input[class='gLFyf']")).sendKeys("Kill Bill", Keys.ENTER);

    }

    @After
    public void tearDown() {
        String[] s = driver.findElement(By.id("result-stats")).getText().split(" ");
        System.out.println("sonuc=" + s[1]);
        driver.close();


    }

    @AfterClass
    public static void afterClass() {
        driver.quit();

    }
}
