package homework;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class FakerTest extends TestBase {

    //"https://facebook.com"  Adresine gidin
    //“create new account”  butonuna basin
    //“firstName” giris kutusuna bir isim yazin
    //“surname” giris kutusuna bir soyisim yazin
    //“email” giris kutusuna bir email yazin
    //“email” onay kutusuna emaili tekrar yazin
    //Bir sifre girin
    //Tarih icin gun secin
    //Tarih icin ay secin
    //Tarih icin yil secin
    //Cinsiyeti secin
    //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
    //Sayfayi kapatin
    //Collapse

    @Test
    public void name() {
        //"https://facebook.com"  Adresine gidin

        driver.get("https://facebook.com");
        driver.findElement(By.xpath("//button[.='Allow essential and optional cookies']")).click();

        //“create new account”  butonuna basin
        driver.findElement(By.linkText("Create new account")).click();

        //“firstName” giris kutusuna bir isim yazin
        Faker faker = new Faker();
        String prenom = faker.name().firstName();
        String nom = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String pasword = faker.internet().password();
        int day = faker.number().numberBetween(1, 28);
        String day_ = String.valueOf(day);
        int month = faker.number().numberBetween(1, 12);
        String month__ = String.valueOf(month);
        int year = faker.number().numberBetween(1905, 2023);
        String year_ = String.valueOf(year);

        WebElement w1 = driver.findElement(By.name("firstname"));
        w1.sendKeys(prenom, Keys.TAB, nom);


        //“email” giris kutusuna bir email yazin
        //“email” onay kutusuna emaili tekrar yazin
        //Bir sifre girin

        WebElement w3 = driver.findElement(By.name("reg_email__"));
        w3.sendKeys(email);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys(email, Keys.TAB, pasword);


        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        WebElement w = driver.findElement(By.id("month"));
        WebElement wday = driver.findElement(By.id("day"));
        WebElement wyear = driver.findElement(By.id("year"));
        Select select = new Select(w);
        select.selectByValue(month__);
        Select select1 = new Select(wday);
        select1.selectByValue(day_);
        waitFor(3);
        Select select2 = new Select(wyear);
        select2.selectByVisibleText(year_);

        //Cinsiyeti secin
        int randomIndex = faker.number().numberBetween(1, 3);
        WebElement cinsiyet = driver.findElement(By.xpath("(//*[@class='_8esa'])[" + randomIndex + "]"));
        cinsiyet.click();


        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assert.assertTrue(cinsiyet.isSelected());


    }
}
