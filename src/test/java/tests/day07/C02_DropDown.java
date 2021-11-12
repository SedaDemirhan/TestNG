package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C02_DropDown {
    //Bir class oluşturun: DropDown


    //    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın




    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    //https://the-internet.herokuapp.com/dropdown adresine gidin.

    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    Thread.sleep(2000);
   //1.Adım: DropDown ı locate et

        WebElement dropDown=driver.findElement(By.id("dropdown"));

     //2.Adım,select clasını kullanarak bir obje oluştur ve
    //parametre olarak locate ettiğimiz webelementi yazdır

        Select select=new Select(dropDown);

     //3.Adım:istediğin option'ı select objesi kullanarak sec

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        Thread.sleep(2000);
    //    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

    //    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

    //    4.Tüm dropdown değerleri(value) yazdırın

      List< WebElement>tumOpsiyonlar=select.getOptions();

        System.out.println("Tüm opsiyonlar listesi");

        for (WebElement each:tumOpsiyonlar) {
            System.out.println(each.getText());
            }


    //    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.

        System.out.println(tumOpsiyonlar.size());
       // Assert.assertEquals(tumOpsiyonlar.size(),4);2.yol

        if (tumOpsiyonlar.size()==4){
            System.out.println("TRUE");

        }else{
            System.out.println("FALSE");
        }

}
@AfterMethod
    public void tearDown(){
        driver.close();
}
}