package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    /*
    Amazon sayfasına gidin,nutella için arama yapın,9.urunu tıklayın
     */

    @Test
    public void test() throws InterruptedException {

        driver.get("https://amazon.com");

        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("nutella"+ Keys.ENTER);

       driver.findElement(By.xpath("(//img[@class='s-image'])[9]")).click();
    }

}
