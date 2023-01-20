package day18;

import org.junit.Test;
import utilities.TestBase;

public class C01_Javascript_valueal extends TestBase {
    /*
    JavaScriptExecutor ile input elementindeki değerleri almak için aşağıdaki adımları izleyebilirsiniz:
Web sayfasındaki input elementini locate etmek için WebDriver kullanabilirsiniz. Örneğin, "id" veya "name" attribute'una göre elementi seçebilirsiniz.
JavaScriptExecutor'u kullanarak, input elementinin "value" attribute'unu alabilirsiniz. Örnek olarak aşağıdaki gibi bir kod kullanabilirsiniz:

WebElement element = driver.findElement(By.id("inputId")); JavascriptExecutor js = (JavascriptExecutor) driver; String value = (String) js.executeScript("return arguments[0].value", element);
executeScript metodu ile input elementinin value attribute'unu almış oldunuz.
Not: Bu kod örneği sadece id attribute'una göre elementi seçer. Eğer elementi başka bir yolla seçmek isterseniz, locate etme kodunu değiştirmeniz gerekebilir.
     */

    @Test
    public void test01() {
        //interviwe
        /*
1) Javascript Executor nedir?
    1- Selenium'dan gelen ve javascript kodlarini calistirmaya yarayan bir interface'dir. Normal Selenium method'lari
yeterli olmadigi durumlarda kullanilabilir

2) Ne zaman ve nasil kullanilir?
    1- Ornegin, bazi butonlara tiklamada problem olabilir, ya da belirli bir web elementin gorunur olacagi sekilde sayfanin
kaydirma islemi, ya da input kutularindaki degerleri almak icin kullanilabilir.

3) Sayfayi asagi veya yukari kaydirma islemi seleniumda nasil yapilir
    1- Selenium'daki Actions ya da javascript executor method'lari ile kaydirma islemleri yapilabilir.
Ornegin, actionslarda page_up,page_down,arrow_up,arrow_down method'lari ile ya da javascript executor'daki scrollIntoView(true)
ile yapilabilir. Ben olusturulmus reusable method'larini kullanarak bu islemleri kolaylikla yapabiliyorum.

4) Bir kutucuktaki yani inputtaki elemanin metni nasil alinabilir?
    1- Javascript executor ile alabiliriz. Cunku js executor ile attribute degerlerini alma imkanimiz var. getText() method'u bu durumlarda CALISMAZ

5) Seleniumda click yaparken problem yasadigin oldu mu? (ya da soyle sorulabilir) Selenium outomasyonunda ne tur problemler yasadin?
    1- Bazen yanlis locator, ya da bekleme(wait) problemi gibi durumlarda problem yasadim. Bazen gizli(hidden) elementlere tiklarken de problem yasadim.
Bu durumlarda javascript executor kullandim ve problemi cozdum.

6) Selenium automation'unda ne tur problemler yasadin
1- TEKNIK PROBLEMLER: Yanlis locator, bekleme(wait), alert, iframe, pop-up seklindeki reklam bildirimleri, multiple window, hidden elementlere tiklama
2- TAKIMLA ILGILI PROBLEMLER: (COK GUNDEME GETIRILMEMELI). Developer bazen buldugum buglari kabul etmiyordu.
Cozum: Takimla beraber degerlendirip fikir birligine variyorduk
 */
        //      1)getValueTest metotu olustur
//  2)https://www.priceline.com/ a git
//            3)Tarih kısmındaki Yazili metinleri al ve yazdır

            driver.get("https://www.priceline.com/");
            getValuesAvecJS("hotelDates");



    }
}
