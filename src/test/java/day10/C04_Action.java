package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Action extends TestBase {
    @Test
    public void clickAndHold() {
        //Class: Action4
        //Method: dragAndDropTest
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        WebElement kaynak=driver.findElement(By.id("draggable"));//kucuk kutunun locate
        WebElement hedef=driver.findElement(By.id("droppable"));//buyuk kutunun locate
        Actions actions=new Actions(driver);
        actions
                .clickAndHold(kaynak)
                .moveToElement(hedef)
                .release()//kaynagi birak
                .build()//birden fazla fonksiyon varsa bunlari birbirine bagla ve calistir  kullanimi sart degildur
                .perform();//perform islemi gerceklestirir build.den daha guclu


    }



    @Test
    public void dragandDrap() {//dragAndDrop bir elemani tutar ve baska bir yere surukleyip birakir en cok kullanilian methot
        //Class: Action4
        //Method: dragAndDropTest
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        WebElement kaynak=driver.findElement(By.id("draggable"));//kucuk kutunun locate
        WebElement hedef=driver.findElement(By.id("droppable"));//buyuk kutunun locate
        Actions actions=new Actions(driver);
        actions.dragAndDrop(kaynak,hedef).perform();

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)kucuk kutuyu buyuk kutunun icine tasi

    }

    @Test
    public void moveByOffset() {
        //Class: Action4
        //Method: dragAndDropTest
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        WebElement kaynak=driver.findElement(By.id("draggable"));//kucuk kutunun locate

        Actions actions=new Actions(driver);
        actions.clickAndHold(kaynak).moveByOffset(430,30).build().perform();

    }
}
