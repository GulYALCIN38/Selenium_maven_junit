package day7ErolHc.practicebasic_aut;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Cookies extends TestBase {
    /*
                                    Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.
     */
    //Techproeducation adresine gidiniz
    //Sayfadaki cookie lerin sayısını yazdırınız
    //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
    //Yeni bir cookie ekleyiniz
    //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
    //Oluşturduğumuz cookie'i silelim
    //Tüm cookieleri silelim

    @Test
    public void test1() {
        //Techproeducation adresine gidiniz
        driver.get("https://techproeducation.com");

        //Sayfadaki cookie lerin sayısını yazdırınız

        Set<Cookie>cookies=driver.manage().getCookies();
        System.out.println(cookies.size());


        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        cookies.forEach(t-> System.out.println(t +" :"+t.getName()+ " :"+t.getValue()));

        //Yeni bir cookie ekleyiniz
        Cookie mycooki=new Cookie("my COOKIE","123456");
        driver.manage().addCookie(mycooki);


        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        Set<Cookie>cookies1=driver.manage().getCookies();
        System.out.println(cookies1.size());
        cookies1.forEach(t-> System.out.println(t +" :"+t.getName()+ " :"+t.getValue()));


        //Oluşturduğumuz cookie'i silelim
        //driver.manage().deleteCookieNamed(mycooki.getName());
        driver.manage().deleteCookie(mycooki);
        Set<Cookie>cookies2=driver.manage().getCookies();
        System.out.println(cookies2.size());

        //Tüm cookieleri silelim
        driver.manage().deleteAllCookies();
        Set<Cookie>cookies3=driver.manage().getCookies();
        System.out.println(cookies3.size());

    }
}
