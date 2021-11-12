package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class C03_DependsOn {

    //● Bir class oluşturun: DependsOnTest
    //● https://www.amazon.com/ adresine gidin.
    // 1. Test : Amazon ana sayfaya gittiginizi test edin
    // 2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin ve aramanizin gerceklestigini Test edin
    // 3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin    $16.83 oldugunu test edin

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void test1(){
        driver.get("https://www.amazon.com/");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com/","URL amazon değil");

    }

    //Testleri birbirine bağladığımızda,
    //1- 2.Methodu tek başına çalıştırmak istersek bile otomatik olarak önce 1.method çalışır
    //2- 1. method failed olursa 2. method ıgnore edilir yani hiç çalıştırılmaz

    @Test(dependsOnMethods = "test1")
    public void test2(){
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("Nutella"),"nutella için arama yapılamıyor");

    }

    @Test(dependsOnMethods = "test2")
    public void test3(){
        driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).click();
        WebElement fiyat= driver.findElement(By.xpath("//span[@class='a-size-base a-color-price']"));
        System.out.println(fiyat.getText());
        Assert.assertEquals(fiyat.getText(),"$16.83");

    }

    @AfterClass
    public void tearDown(){
       driver.close();
    }
}



//eğer 3 test veya daha fazlası birbirine dependsOn ile bağlandıysa
//3.yü calıştırmak istediğimizde zincir reaksiyon çalışıp 1.gitmez