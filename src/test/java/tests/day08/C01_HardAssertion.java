package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_HardAssertion {

    //Amazon sayfasına gidin
    //URL'in amazon içerdiğini test ediN
    //TİTLE'in amazon içerdiğini test edin
    //JAVA kelimesi aratın ve listedeki ilk ürünün JAVA kelimesi içerdiğini test edin


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
        //Amazon sayfasına gidin
        driver.get("https://www.amazon.com/");

        //URL'in amazon içerdiğini test ediN
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        //TİTLE'in amazon içerdiğini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //JAVA kelimesi aratın ve listedeki ilk ürünün JAVA kelimesi içerdiğini test edin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java"+ Keys.ENTER);

        WebElement ilkÜrün= driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        Assert.assertTrue(ilkÜrün.getText().contains("Java"));
    }
   @AfterClass
    public void tearDown(){
        driver.close();
    }


}
