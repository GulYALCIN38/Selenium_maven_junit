package day7ErolHc.jsexecuter;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class JsExecuter extends TestBase {

    /*
                                -- JavascriptExecutor --
        -- ID'si ILE LOCATE
        WebElement element = (WebElement)
                js.executeScript("return document.getElementById('twotabsearchtextbox');");
          js.executeScript("return document.getElementById('twotabsearchtextbox');") kodu, JavaScriptExecutor
       aracılığıyla belirli bir ID değerine sahip bir web elementini locate etmek için kullanılan bir koddur.
       Bu kod, JavaScriptExecutor aracılığıyla tarayıcıda çalıştırılır ve getElementById()
       metodu kullanılarak 'twotabsearchtextbox' ID değerine sahip bir elementi locate eder.
       Bu kodun döndürdüğü sonuç, locate edilen elementi temsil eden bir WebElement nesnesidir.
       Bu WebElement nesnesi, daha sonra Selenium komutları ile bu element üzerinde işlem yapmak için kullanılabilir.
        -- XPATH ILE LOCATE
        WebElement element = (WebElement) js.executeScript
                ("return document.evaluate(\"//*[@id='twotabsearchtextbox']\", " +
                        "document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null ).singleNodeValue;");
        --CSS SELECTOR ILE LOCATE
        WebElement element = (WebElement)
                js.executeScript("return document.querySelector('input[id=twotabsearchtextbox]');");
        */
    /*
    -- Amazon sayfasına gidiniz
    -- Arama bölümünde selenium aratınız
    -- Back to top bölümüne kadar scroll yapınız
    -- Back to top bölümüne tıklayınız
     */

    @Test
    public void test() {
        JavascriptExecutor js= (JavascriptExecutor) driver;
        //-- Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        //    -- Arama bölümünde selenium aratınız
        WebElement element = (WebElement)
                js.executeScript("return document.querySelector('input[id=twotabsearchtextbox]');");
        js.executeScript("arguments[0].value='selenium'",element);
        element.submit();
        //    -- Back to top bölümüne kadar scroll yapınız
        WebElement backToTop = (WebElement)
                js.executeScript("return document.getElementsByClassName('navFooterBackToTopText')[0];");
        js.executeScript("arguments[0].scrollIntoView(true);",backToTop);
        //    -- Back to top bölümüne tıklayınız
        js.executeScript("arguments[0].click();",backToTop);

    }
}
