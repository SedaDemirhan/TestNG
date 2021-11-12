package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C01_ExplicitlyWait extends TestBase {

    //1. Bir class olusturun : C01_WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //  Iki metod icin de asagidaki adimlari test edin.

    @Test
    public void implicitlyWaitTest(){

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        SoftAssert softAssert=new SoftAssert();
        WebElement sonucYazısı= driver.findElement(By.id("message"));
        softAssert.assertTrue(sonucYazısı.isDisplayed());
        softAssert.assertAll();

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        sonucYazısı= driver.findElement(By.id("message"));
        Assert.assertTrue(sonucYazısı.isDisplayed());

    }

    @Test
    public void explicitlyWaitTest(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini test edin.
        WebDriverWait wait=new WebDriverWait(driver,20);

        //explicitly wait'i istersek locate işlemi ile birlikte tek satırda yapabiliriz

        WebElement yazıLocateIleBirlikte=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(yazıLocateIleBirlikte.isDisplayed());

        //veya önce locate edip uygun method kullanarak beklemeyi yaptırabilirz
      /*  WebElement sonucYazısı= driver.findElement(By.id("message"));
        wait.until(ExpectedConditions.visibilityOf(sonucYazısı));
        Assert.assertTrue(sonucYazısı.isDisplayed());*/

        // ancak bu test icin once webelement'i olusturmak anlamsiz olur
        // cunku biz wait i;lemini zaten o webelement olussun diye yapiyoruz
        // wait olmadan o element olmaz , o element olmadan da sectigimiz method caismaz

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackLocateIle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsBackLocateIle.isDisplayed());

    }



}
