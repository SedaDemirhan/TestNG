package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C05_ÖdevQA4 {
    /*
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     * Choose price low to high
     * Verify item prices are sorted from low to high
     */


    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
      //Navigate to  https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

       //Enter the user name  as standard_user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Enter the password as   secret_sauce
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click on login button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //Choose price low to high

        WebElement dropDown= driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select=new Select(dropDown);
        select.selectByValue("lohi");

        //Verify item prices are sorted from low to high

        String actualData=driver.findElement(By.className("active_option")).getText();
        String expectedValue="PRICE (LOW TO HIGH)";

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualData,expectedValue,"Seçilen option doğru değil");

        softAssert.assertAll();

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
