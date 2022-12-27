package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class C02_Dropdownreusable {
    WebDriver driver;


    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //        Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }

    public void selectfromDropDown(WebElement dropdown, String text) {
          //selectfromDropDown(driver.findElement(By.xpath("//select[@id='year']")),"2005");
        //  selectfromDropDown(driver.findElement(By.xpath("//*[@id='month']")),"January");
        // selectfromDropDown(driver.findElement(By.id("day")),"12");

        //
       List<WebElement> options= dropdown.findElements(By.tagName("option"));//tum option tagli elementleri aliriz
        for(WebElement eachOption:options){
            if(eachOption.getText().equals(text)){
                eachOption.click();
                break;

            }
      }
  }
    @Test
    public void selectfromdropdovn() {
        selectfromDropDown(driver.findElement(By.xpath("//select[@id='year']")),"2007");
    }

 /*   public void goster(WebElement a,String b){

        List<WebElement>webs=driver.findElements(By.tagName("option"));
        List<WebElement>y=webs.stream().filter(t->t.getText().equals(b)).collect(Collectors.toList());
        y.get(0).click();
    }*/
}
