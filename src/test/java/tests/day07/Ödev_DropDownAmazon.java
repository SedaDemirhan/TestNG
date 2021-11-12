package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ödev_DropDownAmazon {
    //● Bir class oluşturun: C3_DropDownAmazon
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Ignore
    @Test
    public void amazonTest(){

        //● https://www.amazon.com/ adresine gidin.
        driver.get(" https://www.amazon.com/");

        //- Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori
        //sayisinin 45 oldugunu test edin

        WebElement dropDown=driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));

        Select select=new Select(dropDown);

        List<WebElement>tumKategoriler=select.getOptions();
        System.out.println("Tüm kategorilerin Listesi");

        for (WebElement each:tumKategoriler) {
            System.out.println(each.getText());

        }

        Assert.assertEquals(45,tumKategoriler.size(),"kategoriler 45 seçenek yoktur");

    }
 @Test
         public void arama(){
        //-Test 2
        //1. Kategori menusunden Books secenegini secin

         driver.get(" https://www.amazon.com/");
         WebElement dropDown=driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
         Select select=new Select(dropDown);
         select.selectByVisibleText("Books");
         System.out.println(select.getFirstSelectedOption().getText());

        //2. Arama kutusuna Java yazin ve aratin

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin

        WebElement sonucSayısı=driver.findElement(By.xpath("//span[@dir='auto']"));
        System.out.println("Books kategorisinde Java sonuçlarının sayısı: "+sonucSayısı.getText());

        //4. Sonucun Java kelimesini icerdigini test edin

        WebElement javaKelimesi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        Assert.assertTrue(javaKelimesi.getText().contains("Java"),"java kelimesini  içermiyor");
}


    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}

