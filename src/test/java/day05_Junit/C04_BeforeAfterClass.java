package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeAfterClass {

    /*
    @beforclass ve after class notasyonlari sadece static methotlar icin calisir
     @beforclass ve after class kullanirsak olusturdugumuz @test methotlarinin hepsini ayni anda calistirip en son
     @after class i calistirirz

     ama sadece before after kullanirsak her test icin@before  @after kullaniriz


     */

    @BeforeClass
    public static void setUp()  {

        System.out.println("butun testlerden once calisti");


    }

    @AfterClass
    public static void tearDown()  {
        System.out.println("butun testlerden sonra calisti");


    }

    @Before
    public void setUp1(){
        System.out.println("her testten once calisir");
    }

    @After
    public  void tearDown1()  {
        System.out.println("her testten sonra calisir");

    }
    @Test
    public  void test01(){
        System.out.println("ilk test");
    }
    @Test
    public  void test02(){
        System.out.println("ikinci test");
    }

    @Test
    @Ignore// BIR TESTI CALISTIRMAK ISTEMEZSEK KULLANIRIZ
    public void test03() {
        System.out.println("3. test");
    }
}
