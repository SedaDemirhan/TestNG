package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_UploadFile extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //1.Tests packagenin altina bir class oluşturun : C05_UploadFile
        //2.https://the-internet.herokuapp.com/upload adresine gidelim

        driver.get("https://the-internet.herokuapp.com/upload");
        //3.chooseFile butonuna basalim

        //4.Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu=System.getProperty("user.home")+"\\Masaüstü\\picture.jpg";
        WebElement dosyaYukle= driver.findElement(By.id("file-upload"));
        dosyaYukle.sendKeys(dosyaYolu);

        //5.Upload butonuna basalim.

        driver.findElement(By.id("file-submit")).click();
        //6.“File Uploaded!” textinin goruntulendigini test edelim.

        Thread.sleep(3000);
        WebElement sonucYazısıElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(sonucYazısıElementi.isDisplayed());
    }
}
