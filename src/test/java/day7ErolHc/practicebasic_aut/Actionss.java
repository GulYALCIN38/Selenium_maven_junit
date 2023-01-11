package day7ErolHc.practicebasic_aut;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Actionss extends TestBase {
    /*
                                            Actions
    Action sınıfı, belirli web öğelerinde bir klavyeden veya fareden giriş eylemlerini simüle etmek için kullanılır.
Örneğin, Sol Tıklama, Sağ Tıklama, Çift Tıklama, sürükleyip bırakma, bir webelementin üzerinde bekletme vb.
 */
/*
    http://uitestpractice.com/Students/Actions adresine gidelim
    Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
    Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
    Accept ile alert'ü kapatalım
    Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
     */
    @Test
    public void test1() {
        // http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");

        //    Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
        WebElement boitBlue=driver.findElement(By.id("div2"));
        Actions actions=new Actions(driver);

        actions.moveToElement(boitBlue);// buraya perform koymadik asagidaki build 3 saniye bekletmeden iki actions islemini birlestirdi
        waitFor(3);




        //    Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
        WebElement w= driver.findElement(By.name("dblClick"));
        actions.doubleClick(w).build().perform();
        waitFor(2);
        Assert.assertEquals("Double Clicked !!",driver.switchTo().alert().getText());


        //    Accept ile alert'ü kapatalım
        driver.switchTo().alert().accept();

        //    Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
         WebElement source=driver.findElement(By.id("draggable"));
         WebElement sible= driver.findElement(By.id("droppable"));
         actions.dragAndDrop(source,sible).perform();

         Assert.assertEquals("Dropped!",driver.findElement(By.id("droppable")).getText());


    }
}
