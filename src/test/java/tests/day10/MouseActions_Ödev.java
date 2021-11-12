package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

public class MouseActions_Ödev extends TestBase {

    @Test
    public  void test(){
        //1--https://www.facebook.com adresine gidelim

        driver.get("https://www.facebook.com");

        //2--Yeni hesap olustur butonuna basalim

        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        //3--Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim

        WebElement giriş= driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        giriş.sendKeys("Seda"+ Keys.TAB+"Demirhan"+Keys.TAB+"abcd@gmail.com");
        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("abcd@gmail.com"+Keys.TAB+"12345");

        WebElement dogumTarihi= driver.findElement(By.xpath("//select[@name='birthday_day']"));
        dogumTarihi.sendKeys("15"+Keys.TAB+"06"+Keys.TAB+"1990");
        driver.findElement(By.xpath("//label[@class='_58mt']")).click();

        //4--Kaydol tusuna basalim
        driver.findElement(By.xpath("(//button[@name='websubmit'])[1]")).click();



    }

}
