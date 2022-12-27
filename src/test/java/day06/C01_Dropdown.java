package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {

    WebDriver driver;

    // eger test sinifinda  birden fazla methot varsa @before kullanilir
    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //        Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }

    @Test
    public void selectByIndexTest() {


//        Dogun yilini, ayini, ve gununu su sekilde secer : 2000, January, 10
       WebElement year= driver.findElement(By.xpath("//select[@id='year']"));
        //select objesi olustur
        Select yearDropdown=new Select(year);
        // bu obje ile 3 farklii sekilde secim yapabilirim
        yearDropdown.selectByIndex(22);//secenek sirasi 0 dan baslar

        WebElement month= driver.findElement(By.xpath("//*[@id='month']"));
        Select monthDropdown=new Select(month);
        monthDropdown.selectByValue("0");//option value degeri ile secim yapilir

        //        Gun secimi selectByVisibleTest
        WebElement gun = driver.findElement(By.id("day"));
        Select gunDropdown = new Select(gun);
        gunDropdown.selectByVisibleText("10");//CASE SENSITIVE -


    }

    @Test
    public void printAllTest() {
        //tum eyalet isimlerimi konsola yazdir

        WebElement state= driver.findElement(By.xpath("//*[@id='state']"));
        Select stateDropdown=new Select(state);
        List<WebElement>states= stateDropdown.getOptions();
        states.forEach(t-> System.out.print(t.getText()+" "));


    }

    @Test
    public void getSelectedOptionsTest(){

        //State dropdowndaki varsayilan secili secenegin "select a state" oldunu kontrol edin
        WebElement state= driver.findElement(By.xpath("//*[@id='state']"));
        Select stateDropdown=new Select(state);
        String actuelText=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State",actuelText);


    }

    //REUSABLE METHOT;DROPdOWN ICIN TEKRAR TEKRAR KULLANILAN BIR METHOD YAP



    /*
    1. What is dropdown? Dropdown nedir?
    Dropdown liste olusturmak icin kullanilir.
    2. How to handle dropdown elements? Dropdown nasil automate edilir?
    -dropdown i locate ederim
    -select objesi olustururum
    -select objesi ile istedigim secenegi secerim
    NOT: select objesi olusturma nedenim, dropdownlarin Select classi ile olusturulmasi
    3. Tum dropdown seceneklerini nasil print ederiz?
    - tum dropdown elementlerini getOptions() methodu ile listeye koyariz
    - sonra secenekleri loop ile yazdirabilirz
    4. Bir secenegin secili oldugunu otomate etmek icin ne yapilir?
    Ornek: Gun olarak 10 i secdik ama ya secilmediyse?
    getFirstSelectedOption() secili olan secenegi return eder
     */
    @After
    public void tearDown() {

        driver.close();
    }

}
