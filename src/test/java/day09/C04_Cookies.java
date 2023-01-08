package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {
    private Cookie favoriCooki;

//1.toplam cookie sayisini bul
//3. Bir Cookie yi smiyle bul
//4. Yeni bir cookie ekle
//5. Bir Cookie yi ismiyle sil
//6. Tum cookie leri sil


    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
        waitFor(2);
        //1.toplam cookie sayisini bul
        Set<Cookie> allcookies=driver.manage().getCookies();
        int cookiesSayisi=allcookies.size();
        System.out.println(allcookies.size());//8




        //3. Bir Cookie yi ismiyle bul
        allcookies.forEach(t-> System.out.print(t.getName()+" "));//sp-cdn i18n-prefs ubid-main session-id-time skin session-token csm-hit session-id
        //allcookies.forEach(t-> System.out.println(t +" "));
        System.out.println();
        System.out.println("cooki yi ismiyle cagirdim="+driver.manage().getCookieNamed("sp-cdn"));// cookiyi ismiyle cagirdik


        //4. Yeni bir cookie ekle

        Cookie favoriCooki= new Cookie("cerez","fistik");
        driver.manage().addCookie(favoriCooki);
        waitFor(2);
        System.out.println("toplam  cookie sayisi"+driver.manage().getCookies().size());//9


        //5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("ubid-main");


        //6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        waitFor(3);
        System.out.println("tum cookiler silinince toplam cookies sayisi="+driver.manage().getCookies().size());//0\


    }
}
