package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_MouseActions extends TestBase {


    @Test
    public void test(){
        //1- https://www.amazon.com/ adresine gidelim

        driver.get("https://www.amazon.com");
        //2-Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        // mouse’u bu menunun ustune getirelim

        WebElement liste= driver.findElement(By.id("nav-link-accountList-nav-line-1"));

        Actions actions=new Actions(driver);
        actions.moveToElement(liste).perform();

        //3-“Create a list” butonuna basalim

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        //4-Acilan sayfada “Your Lists” yazisi oldugunu test edelim

        WebElement yourListYazıElementi= driver.findElement(By.xpath("//li[@class='a-tab-heading a-active a-size-large']"));

        String actualYazıElementi= yourListYazıElementi.getText();
        String expectedYazıElementi="Your Lists";

        Assert.assertTrue(yourListYazıElementi.isEnabled());




    }
}
